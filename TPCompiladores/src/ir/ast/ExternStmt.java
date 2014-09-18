/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ast;

import ir.ASTVisitor;

/**
 *
 * @author luciano
 */
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
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
