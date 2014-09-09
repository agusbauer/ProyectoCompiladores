/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcompiladores;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author luciano
 */
public class TablaDeSimbolos {
   
    private LinkedList<HashMap<String,Descriptor>> pila;
    private int cantidad;
    
    public TablaDeSimbolos(){
        pila = new LinkedList();
        cantidad = 0;
    }
    
    public void push(HashMap<String,Descriptor> ambiente){
        pila.add(ambiente);
        cantidad++;
    }
    
    public void pop(){
        pila.removeFirst();
        cantidad--;
    }
    
    public boolean isEmpty(){
        return cantidad==0;
    }
    
    public boolean search(String id){
        for(HashMap<String, Descriptor> nivel : pila){
            if(nivel.containsKey(id)){
                return true;
            }
        }
        
        return false;
    }
    
}
