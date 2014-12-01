/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa un booleano.
 */

package ir.ast;

import ir.ASTVisitor;


public class BoolLiteral extends Literal {
    boolean value;
    
    public BoolLiteral(Boolean val,int line, int col){
                this.setLineNumber(line);
                this.setColumnNumber(col);
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
    public String toString() {
        if(value)
            return "1";
        else
            return "0";
    }

    
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
	return v.visit(this);
    }

    @Override
    public String getClase() {
        return "bool";
    }
}
