/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una sentencia "for"
 */
package ir.ast;

import ir.ASTVisitor;
import tabladesimbolos.Descriptor;


public class ForStmt extends Statement {
    private Descriptor var;
    private String id;
    private Expression expr;
    private Expression exprfin;
    private Block block;

    public ForStmt(Descriptor d,String id, Expression expr, Expression exprfin, Block block) {
        this.var = d;
        this.id = id;
        this.expr = expr;
        this.exprfin = exprfin;
        this.block = block;
    }

    public Descriptor getVar() {
        return var;
    }

    public void setVar(Descriptor var) {
        this.var = var;
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

    public Expression getExprfin() {
        return exprfin;
    }

    public void setExprfin(Expression exprfin) {
        this.exprfin = exprfin;
    }

    

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "for " + id + "=" + expr + "," + exprfin + block.toString() ;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
