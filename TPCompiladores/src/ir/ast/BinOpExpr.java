/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una expresion con operadores binarios
 */

package ir.ast;

import ir.ASTVisitor;

public class BinOpExpr extends Expression {
	private BinOpType operator; //operator in the expr = expr operator expr
	private Expression lOperand; //left expression
	private Expression rOperand; //right expression
	
	public BinOpExpr(Expression l, BinOpType op, Expression r,int line, int col){
                this.setLineNumber(line);
                this.setColumnNumber(col);
		operator = op;
		lOperand = l;
		rOperand = r;
                
	}
	
        /*public BinOpExpr(Expression e, TempExpression t) {
		lOperand = e;
		operator = t.getOperator();
		rOperand = t.getRightOperand();
	}*/
	
	public BinOpType getOperator() {
		return operator;
	}

	public void setOperator(BinOpType operator) {
		this.operator = operator;
	}

	public Expression getLeftOperand() {
		return lOperand;
	}

	public void setLeftOperand(Expression lOperand) {
		this.lOperand = lOperand;
	}

	public Expression getRightOperand() {
		return rOperand;
	}

	public void setRightOperand(Expression rOperand) {
		this.rOperand = rOperand;
	}
	
	@Override
	public String toString() {
		return lOperand + " " + operator + " " + rOperand;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
