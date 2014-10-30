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
    
    public Ambiente getFirst(){
        return pila.getLast(); //retorna el nivel 0 de la pila.
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

    public LinkedList<Ambiente> getPila() {
        return pila;
    }

    public void setPila(LinkedList<Ambiente> pila) {
        this.pila = pila;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public TablaDeSimbolos clone(){
        TablaDeSimbolos t = new TablaDeSimbolos();
        t.cantidad = cantidad;
        LinkedList<Ambiente> l = new LinkedList();
        for(Ambiente a : pila){
            Ambiente am = (Ambiente) a.clone();
            l.add(am);
         }
        t.setPila(l);
        return t;
    }
    
}
