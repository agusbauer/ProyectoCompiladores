/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Descriptor: Representa un descriptor, esta clase va a ser implementada por un arreglo, funcion o un descriptor simple.
 */
package tabladesimbolos;

import ir.ast.BinOpType;
import ir.ast.Type;


public abstract class Descriptor {
    
    protected String nombre;
    protected Type tipo;
    protected boolean esGlobal;
    protected static int offsetCorriente;
    protected int offset;
    protected BinOpType op; // solo sirve para assembler
    protected Object valor; //esto es para saber el valor una variable, ya sea para chequear variables no declaradas o hacer movidas con los float en asm

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    
        
    public static int getOffsetCorriente() {
        return offsetCorriente;
    }

    public static void setOffsetCorriente(int offsetCorriente) {
        Descriptor.offsetCorriente = offsetCorriente;
    }

    public BinOpType getOp() {
        return op;
    }

    public void setOp(BinOpType op) {
        this.op = op;
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

    public void setEsGlobal(boolean b) {
        esGlobal = b;
    }
    
      public boolean EsGlobal() {
        return esGlobal;
    }
    
}
