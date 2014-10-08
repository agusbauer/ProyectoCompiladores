/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Representa un arreglo.
 */
package tabladesimbolos;

import ir.ast.Type;


public class DescriptorArreglo extends Descriptor {

    private Integer longitud;
    
     public DescriptorArreglo(String nombre, Type tipo, Integer longitud){
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
