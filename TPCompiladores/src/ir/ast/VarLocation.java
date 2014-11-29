/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una variable simple, arreglo o metodo
 */
package ir.ast;

import ir.ASTVisitor;
import tabladesimbolos.Descriptor;
import tabladesimbolos.DescriptorArreglo;
import tabladesimbolos.DescriptorSimple;

public class VarLocation extends Location {

    private Block block;
    private Descriptor desc;
    private Expression indice;

    public VarLocation(String id, Descriptor d) {
        this.id = id;
        this.desc = d;
    }

    public VarLocation(String id, Descriptor d,Expression e, int line, int col) {
        this.indice = e;
        this.setLineNumber(line);
        this.setColumnNumber(col);
        this.id = id;
        this.desc = d;
    }    

    public VarLocation(String id, Block b, Descriptor d, int line, int col) {
        this.setLineNumber(line);
        this.setColumnNumber(col);
        this.id = id;
        this.block = b;
        this.desc = d;
    }

    public Expression getIndice() {
        return indice;
    }

    public void setIndice(Expression indice) {
        this.indice = indice;
    }
    

    public Descriptor getDesc() {
        return desc;
    }

    public void setDesc(Descriptor desc) {
        this.desc = desc;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }

    @Override
    public String getClase() {
        return "loc";
    }
}
