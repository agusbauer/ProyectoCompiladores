/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ast;

import ir.ASTVisitor;

/**
 *
 * @author luciano
 */
public class FloatLiteral extends Literal {

    private Float value;

    public FloatLiteral(Float value) {
        this.value = value;
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
    
}
