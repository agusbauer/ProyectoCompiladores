/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una sentencia de invocacion externa.
 */
package ir.ast;

import ir.ASTVisitor;

public class ExternStmt extends Statement {
    private Extern e;

    public ExternStmt(Extern e) {
        this.e = e;
    }

    public Extern getE() {
        return e;
    }

    public void setE(Extern e) {
        this.e = e;
    }

    @Override
    public String toString() {
        if(e!=null)
            return e.getString();
        else
            return "null";
    }
    
    
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
