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
    
    
    
     public DescriptorSimple(String nombre, Type tipo, boolean glob){
        if (!glob){
            DescriptorSimple.setOffsetCorriente(DescriptorSimple.getOffsetCorriente() - 4);
            this.setOffset(DescriptorSimple.getOffsetCorriente());
        }
        this.nombre = nombre;
        this.tipo = tipo;
        this.esGlobal = glob;
    }
    
 
    
    @Override
    public String getClase(){
        return "descriptorSimple";
    }
}
