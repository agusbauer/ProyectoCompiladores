/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa un bloque del programa.
 */

package ir.ast;

import java.util.ArrayList;
import java.util.List;
import ir.ASTVisitor;

public class Block extends Statement {
	private List<Statement> statements;
        private String methodName; // para las etiquetas de assembler
        private Integer offSetMax;
        
        public void setMethodName(String n){
            methodName=n;
        }
        
        public String getMethodName(){
            return methodName;
        }
	
	public Block( List<Statement> s) {
		statements = s;
	}
	
	public void addStatement(Statement s) {
		this.statements.add(s);
	}
		
	public List<Statement> getStatements() {
		return this.statements;
	} 
		

	@Override
	public String toString() {
		String rtn = "";
		
	    for (Statement s: statements) {
			rtn += s.toString() + '\n';
		}
		
		if (rtn.length() > 0) return rtn.substring(0, rtn.length() - 1); // remove last new line char
		
		return rtn; 
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

    public Integer getOffSetMax() {
        return offSetMax;
    }
    
    public void setOffSetMax(Integer n){
        offSetMax = n;
    }
	
}
