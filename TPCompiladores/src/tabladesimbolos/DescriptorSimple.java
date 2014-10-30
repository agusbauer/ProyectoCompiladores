/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Representa una variable simple.
 */
package tabladesimbolos;

import ir.ast.Type;


public class DescriptorSimple extends Descriptor {

    private boolean esGlobal = false; // para saber si es global 
    
    public DescriptorSimple(String nombre, Type tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
     public DescriptorSimple(String nombre, Type tipo, boolean glob){
        this.nombre = nombre;
        this.tipo = tipo;
        esGlobal = glob;
    }

    public boolean isEsGlobal() {
        return esGlobal;
    }

    public void setEsGlobal(boolean esGlobal) {
        this.esGlobal = esGlobal;
        
    }
    
 
    
    @Override
    public String getClase(){
        return "descriptorSimple";
    }
}
