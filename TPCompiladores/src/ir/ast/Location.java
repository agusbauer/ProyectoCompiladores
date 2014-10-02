/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que es implementado por una variable simple, arrreglo o metodo.
 */

package ir.ast;

public abstract class Location extends Expression {
	protected String id;
	 
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
