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
public class UnaryOpExpr extends Expression {
    private UnaryOpType operator; //operator in the expr = operator expr
    private Expression operand; // expression

    public UnaryOpExpr(UnaryOpType operator, Expression operand,int line, int col) {
        this.setLineNumber(line);
        this.setColumnNumber(col);
        this.operator = operator;
        this.operand = operand;
    }

    public UnaryOpType getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return  operator + " " + operand;
    }

    public void setOperator(UnaryOpType operator) {
        this.operator = operator;
    }

    public Expression getOperand() {
        return operand;
    }

    public void setOperand(Expression operand) {
        this.operand = operand;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
