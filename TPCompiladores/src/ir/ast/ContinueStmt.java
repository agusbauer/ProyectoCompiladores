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
public class ContinueStmt extends Statement {

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
