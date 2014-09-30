/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa un literal
 * Es implementada por los enteros, float, boolean 
 */
package ir.ast;

public abstract class Literal extends Expression {
	/*
	 * @return: returns Type of Literal instance
	 */
	public abstract Type getType();
}
