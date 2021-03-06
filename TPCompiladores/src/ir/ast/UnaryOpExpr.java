/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una expresion con un operador unario.
 */
package ir.ast;

import ir.ASTVisitor;

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

    @Override
    public String getClase() {
        return "unary";
    }
    
}
