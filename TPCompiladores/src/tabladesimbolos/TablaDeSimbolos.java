/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladesimbolos;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author luciano
 */
public class TablaDeSimbolos {
   
    private LinkedList<Ambiente> pila;
    private int cantidad;
    
    public TablaDeSimbolos(){
        pila = new LinkedList();
        cantidad = 0;
    }
    
    public void push(Ambiente ambiente){
        pila.add(ambiente);
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
