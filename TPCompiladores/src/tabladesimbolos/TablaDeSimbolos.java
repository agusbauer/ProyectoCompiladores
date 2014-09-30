/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Tabla de simbolos: Funciona como una pila para guardar los ambientes de cada bloque del programa.
 */
package tabladesimbolos;
import java.util.HashMap;
import java.util.LinkedList;

public class TablaDeSimbolos {
   
    private LinkedList<Ambiente> pila;
    private int cantidad;
    
    public TablaDeSimbolos(){
        pila = new LinkedList();
        cantidad = 0;
    }
    
    public void push(Ambiente ambiente){
        pila.addFirst(ambiente);
        cantidad++;
    }
    
    public Ambiente top(){
        return pila.getFirst();
    }
    
    public void pop(){      
        pila.removeFirst();
        cantidad--;
    }
    
    public boolean isEmpty(){
        return cantidad==0;
    }
    
    public Descriptor search(String id){
        for(Ambiente nivel : pila){
            Descriptor d = nivel.get(id);
            if(d!=null){
                return d;
            }
        }
        return null;
    }
    
}
