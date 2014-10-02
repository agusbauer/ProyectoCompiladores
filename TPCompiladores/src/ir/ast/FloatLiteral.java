/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa un numero real.
 */
package ir.ast;

import ir.ASTVisitor;


public class FloatLiteral extends Literal {

    private Float value;

    public FloatLiteral(Float value,int line, int col) {
        this.setLineNumber(line);
        this.setColumnNumber(col);
        this.value = value;
        type = Type.FLOAT;
    }
    
     public FloatLiteral(Number value,int line, int col) {
        this.setLineNumber(line);
        this.setColumnNumber(col);
        this.value = value.floatValue();
        type = Type.FLOAT;
    }
    
    @Override
    public Type getType() {
        return type;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public String getClase() {
        return "float";
    }
    
    
    
}
