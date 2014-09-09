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
public class BooleanLiteral extends Literal {
    boolean value;
    
    public BooleanLiteral(Boolean val){
		value = val; 
	}

	@Override
	public Type getType() {
		return Type.INT;
	}

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
	return v.visit(this);
    }
}
