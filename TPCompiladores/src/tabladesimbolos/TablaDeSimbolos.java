/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Tabla de simbolos: Funciona como una pila para guardar los ambientes de cada bloque del programa.
 */
package tabladesimbolos;
import java.util.HashMap;
import java.util.Iterator;
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
    
    /*public Descriptor search(String id){
        for(int i = pila.size()-1; i >= 0; i--){
            Ambiente a = pila.get(i);
            Descriptor d = a.get(id);
            if(d != null){
                return d;
            }
        }
        return null;
       
    }*/
    
    public Descriptor search(String id){
        for(int i = 0; i < pila.size(); i++){
            Ambiente a = pila.get(i);
            Descriptor d = a.get(id);
            if(d != null){
                return d;
            }
        }
        return null;
       
    }
    
    /*public int searchLevel(String id){
        for(Ambiente nivel : pila){
            if(nivel != pila.getLast()){
                System.out.println("MUCHACACACACACACACACACAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!");
                Descriptor d = nivel.get(id);
                if(d!=null){
                    System.out.println("nivelll"+nivel.getLevel());
                    return nivel.getLevel();
                }
            }
        }
        Ambiente a = pila.getLast();
        if(a.get(id) != null){
            return a.getLevel(); // retorna 0
        }else{
            return -1;
        }
    }
    
    public void imprimir(){
        for(Ambiente a : pila){
            System.out.println("AMBIENTE/NIVEL: "+a.getLevel());
            for(Descriptor d : a.values()){
                System.out.println(d.getTipo().toString()+" "+d.getNombre());
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }*/

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
