/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una expresion de llamada de un metodo.
 */
package ir.ast;

import ir.ASTVisitor;
import java.util.List;


public class MethodCall extends Expression {
    private String id;
    private List<Expression> expressions; 

    public MethodCall(String id,Type type, List<Expression> expressions,int line, int col) {
        this.setLineNumber(line);
        this.setColumnNumber(col);
        this.id = id;
        this.expressions = expressions;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String res = id+"(";
        for (Expression e: expressions) {
			res += e.toString() + ',';
		}
        res+=')';
        return res;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }

    @Override
    public String getClase() {
        return "method";
    }
    
}
