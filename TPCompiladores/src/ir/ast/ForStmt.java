/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una sentencia "for"
 */
package ir.ast;

import ir.ASTVisitor;


public class ForStmt extends Statement {
    private String id;
    private Expression expr;
    private Expression condition;
    private Block block;

    public ForStmt(String id, Expression expr, Expression condition, Block block) {
        this.id = id;
        this.expr = expr;
        this.condition = condition;
        this.block = block;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "for " + id + "=" + expr + "," + condition + block.toString() ;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
