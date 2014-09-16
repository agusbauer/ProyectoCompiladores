/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladesimbolos;

/**
 *
 * @author luciano
 */
public class DescriptorSimple extends Descriptor {

    public DescriptorSimple(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    @Override
    public String getClase(){
        return "descriptorSimple";
    }
}
