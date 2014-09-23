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
public class MethodCallStmt extends Statement {

    private MethodCall m;

    public MethodCall getM() {
        return m;
    }

    public void setM(MethodCall m) {
        this.m = m;
    }

    public MethodCallStmt(MethodCall m) {
        this.m = m;
    }
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}