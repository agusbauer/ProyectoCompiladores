/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una expresion.
 * Es implementado por los distintos tipos de expresiones que puede haber en un programa
 */

package ir.ast;

public abstract class Expression extends AST {
	protected Expression expr;
	protected Type type;
        protected int TACid;
        protected String label;
	
	public Type getType() {
		return this.type;
	}
	
	public void setType(Type t) {
		this.type = t;
	}

    public int getTACid() {
        return TACid;
    }

    public void setTACid(int TACid) {
        this.TACid = TACid;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public abstract String getClase();
}
