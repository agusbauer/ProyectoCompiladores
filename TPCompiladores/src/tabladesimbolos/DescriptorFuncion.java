/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladesimbolos;

import java.util.LinkedList;

/**
 *
 * @author luciano
 */
public class DescriptorFuncion extends Descriptor {

    private LinkedList<DescriptorSimple> parametros;
    
     public DescriptorFuncion(String nombre, String tipo, LinkedList<DescriptorSimple> parametros){
        this.nombre = nombre;
        this.tipo = tipo;
        this.parametros = parametros;
    }

    public LinkedList<DescriptorSimple> getParametros() {
        return parametros;
    }

    public void setParametros(LinkedList<DescriptorSimple> parametros) {
        this.parametros = parametros;
    }
     
    
            
}
