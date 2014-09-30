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
	
	public Type getType() {
		return this.type;
	}
	
	public void setType(Type t) {
		this.type = t;
	}
}
