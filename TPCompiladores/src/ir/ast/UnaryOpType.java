/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ast;

/**
 *
 * @author luciano
 */
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
}
