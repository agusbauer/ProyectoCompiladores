/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Representa una variable simple.
 */
package tabladesimbolos;

import ir.ast.Type;


public class DescriptorSimple extends Descriptor {

    public DescriptorSimple(String nombre, Type tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public DescriptorSimple(String nombre, Type tipo, int offset){
        this.nombre = nombre;
        this.tipo = tipo;
        this.offset = offset;
    }
    
    @Override
    public String getClase(){
        return "descriptorSimple";
    }
}
