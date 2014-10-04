/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Representa una funcion o metodo.
 */
package tabladesimbolos;

import ir.ast.Type;
import java.util.LinkedList;


public class DescriptorFuncion extends Descriptor {

    private LinkedList<DescriptorSimple> parametros;
    
     public DescriptorFuncion(String nombre, Type tipo, LinkedList<DescriptorSimple> parametros, int offset){
        this.nombre = nombre;
        this.tipo = tipo;
        this.parametros = parametros;
        this.offset = offset;
    }

    public LinkedList<DescriptorSimple> getParametros() {
        return parametros;
    }

    public void setParametros(LinkedList<DescriptorSimple> parametros) {
        this.parametros = parametros;
    }
    
    @Override
    public String getClase(){
        return "descriptorFuncion";
    }
     
    
            
}
