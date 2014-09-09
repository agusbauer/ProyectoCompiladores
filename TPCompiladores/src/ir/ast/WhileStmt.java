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
public class WhileStmt extends Statement {

    private Block block;
    private Expression expr;

    public WhileStmt(Block block, Expression expr) {
        this.block = block;
        this.expr = expr;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "While" + expr.toString() + " " + block.toString();
    }
    
    
    
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
       return v.visit(this);
    }
    
}
