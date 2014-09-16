/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladesimbolos;

/**
 *
 * @author luciano
 */
public class DescriptorArreglo extends Descriptor {

    private Integer longitud;
    
     public DescriptorArreglo(String nombre, String tipo, Integer longitud){
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
    
    @Override
    public String getClase(){
        return "descriptorArreglo";
    }
    
}
