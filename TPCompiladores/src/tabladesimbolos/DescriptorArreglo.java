/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcompiladores;

/**
 *
 * @author luciano
 */
public class DescriptorArreglo extends Descriptor {

    private int longitud;
    
     public DescriptorArreglo(String nombre, String tipo, int longitud){
        this.nombre = nombre;
        this.tipo = tipo;
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
     
    
}
