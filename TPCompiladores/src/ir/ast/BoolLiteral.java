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
public class BoolLiteral extends Literal {
    boolean value;
    
    public BoolLiteral(Boolean val){
		value = val; 
                type = Type.BOOL;
	}

	@Override
	public Type getType() {
		return type;
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
