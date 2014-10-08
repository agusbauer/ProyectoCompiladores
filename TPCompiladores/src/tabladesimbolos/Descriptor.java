/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Descriptor: Representa un descriptor, esta clase va a ser implementada por un arreglo, funcion o un descriptor simple.
 */
package tabladesimbolos;

import ir.ast.Type;


public abstract class Descriptor {
    
    protected String nombre;
    protected Type tipo;
    protected static int offsetCorriente;
    protected int offset;

    public static int getOffsetCorriente() {
        return offsetCorriente;
    }

    public static void setOffsetCorriente(int offsetCorriente) {
        Descriptor.offsetCorriente = offsetCorriente;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    
        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
    
    public String getClase(){
        return "descriptor";
    }
    
}
