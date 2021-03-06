/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Enumerado que representa los tipos de operadores unarios que puede haber en un programa
 */

package ir.ast;


public enum UnaryOpType {
    MINUS,
    NOT;
    
    @Override
    public String toString(){
        switch(this) {
			case NOT:
				return "!";
			case MINUS:
				return "-";
        }
        return null;
    }
    
    public boolean isMinus() {
		if (this == UnaryOpType.MINUS) {
			return true;
		}
		
		return false;
	}
    
    public boolean isNot() {
		if (this == UnaryOpType.NOT) {
			return true;
		}
		
		return false;
	}
}
