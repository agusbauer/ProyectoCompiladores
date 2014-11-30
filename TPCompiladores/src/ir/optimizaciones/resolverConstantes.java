/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.optimizaciones;

/**
 *
 * @author luciano
 */

import ir.ASTVisitor;
import ir.ast.AssignOpType;
import ir.ast.AssignStmt;
import ir.ast.BinOpExpr;
import ir.ast.BinOpType;
import ir.ast.Block;
import ir.ast.BoolLiteral;
import ir.ast.BreakStmt;
import ir.ast.ContinueStmt;
import ir.ast.Expression;
import ir.ast.Extern;
import ir.ast.ExternStmt;
import ir.ast.FloatLiteral;
import ir.ast.ForStmt;
import ir.ast.IfStmt;
import ir.ast.IntLiteral;
import ir.ast.MethodCall;
import ir.ast.MethodCallStmt;
import ir.ast.ReturnStmt;
import ir.ast.SkipStmt;
import ir.ast.Statement;
import ir.ast.Type;
import ir.ast.UnaryOpExpr;
import ir.ast.VarLocation;
import ir.ast.WhileStmt;
import static ir.gencodint.TACOpType.*;
import java.util.LinkedList;
import java.util.Stack;
import tabladesimbolos.Descriptor;
import tabladesimbolos.DescriptorSimple;


public class resolverConstantes implements ASTVisitor<Expression>{

    @Override
    public Expression visit(AssignStmt stmt) {
        Expression e = stmt.getExpression().accept(this);
        stmt.setExpression(e);
        return null;
    }

    @Override
    public Expression visit(ReturnStmt stmt) {
        if (stmt.getExpression()!=null){
            Expression e = stmt.getExpression().accept(this);
            stmt.setExpression(e);
        }
        return null;
    }

    @Override
    public Expression visit(IfStmt stmt) {
        Expression e = stmt.getCondition().accept(this);
        stmt.setCondition(e);
        stmt.getIfBlock().accept(this);
        if(stmt.getElseBlock()!=null)
            stmt.getElseBlock().accept(this);
        return null;
    }

    @Override
    public Expression visit(ForStmt stmt) {
        Expression e0 = stmt.getExpr().accept(this);
        Expression e1 = stmt.getExprfin().accept(this);
        stmt.setExpr(e0);
        stmt.setExprfin(e1);
        stmt.getBlock().accept(this);
        return null;
    }

    @Override
    public Expression visit(WhileStmt stmt) {
        Expression e = stmt.getExpr().accept(this);
        stmt.setExpr(e);
        stmt.getBlock().accept(this);
        return null;
    }

    @Override
    public Expression visit(BreakStmt stmt) {
        return null;
    }

    @Override
    public Expression visit(ContinueStmt stmt) {
        return null;
    }

    @Override
    public Expression visit(SkipStmt stmt) {
    return null;
    }

    @Override
    public Expression visit(ExternStmt stmt) {
        return null;
    }

    @Override
    public Expression visit(MethodCallStmt stmt) {
        return null;
    }

    @Override
    public Expression visit(BinOpExpr expr) {
        Expression e0 = expr.getLeftOperand().accept(this);
        BinOpType op = expr.getOperator();
        Expression e1 = expr.getRightOperand().accept(this);
        if (e0 instanceof BoolLiteral && e1 instanceof BoolLiteral){
            BoolLiteral b0 = (BoolLiteral) e0;
            BoolLiteral b1 = (BoolLiteral) e1;
            switch (op) {
                case EQEQ : b0.setValue(b0.isValue() == b1.isValue()); break;
                case NOTEQ : b0.setValue(b0.isValue() != b1.isValue()); break;
                case AND : b0.setValue(b0.isValue() && b1.isValue()); break;
                case OR : b0.setValue(b0.isValue() || b1.isValue()); break;    
            }
            return b0;
        }
        if (e0 instanceof IntLiteral && e1 instanceof IntLiteral){
            IntLiteral i0 = (IntLiteral) e0;
            IntLiteral i1 = (IntLiteral) e1;
            BoolLiteral b = null;
            switch (op) {
                case EQEQ : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())==0,0,0); break;
                case NOTEQ : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())!=0,0,0); break;
                case LT : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())<0,0,0); break;
                case GT : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())>0,0,0); break;
                case LTEQ : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())<=0,0,0); break;
                case GTEQ : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())>=0,0,0); break;
                case PLUS : i0.setValue(i0.getValue()+i1.getValue()); break;
                case MINUS : i0.setValue(i0.getValue()-i1.getValue()); break;
                case TIMES : i0.setValue(i0.getValue()*i1.getValue()); break;
                case DIVIDE : i0.setValue(i0.getValue()/i1.getValue()); break;
                case MOD : i0.setValue(i0.getValue()%i1.getValue()); break;
            }
            if (b!=null)
                return b;
            else
                return i0;
        }
        if (e0 instanceof FloatLiteral && e1 instanceof FloatLiteral){
            FloatLiteral i0 = (FloatLiteral) e0;
            FloatLiteral i1 = (FloatLiteral) e1;
            BoolLiteral b = null;
            switch (op) {
                case EQEQ : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())==0,0,0); break;
                case NOTEQ : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())!=0,0,0); break;
                case LT : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())<0,0,0); break;
                case GT : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())>0,0,0); break;
                case LTEQ : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())<=0,0,0); break;
                case GTEQ : b = new BoolLiteral(i0.getValue().compareTo(i1.getValue())>=0,0,0); break;
                case PLUS : i0.setValue(i0.getValue()+i1.getValue()); break;
                case MINUS : i0.setValue(i0.getValue()-i1.getValue()); break;
                case TIMES : i0.setValue(i0.getValue()*i1.getValue()); break;
                case DIVIDE : i0.setValue(i0.getValue()/i1.getValue()); break;
                case MOD : i0.setValue(i0.getValue()%i1.getValue()); break;
            }
            if (b!=null)
                return b;
            else
                return i0;
        }
        return expr;
    }

    @Override
    public Expression visit(UnaryOpExpr expr) {
        Expression e = expr.getOperand().accept(this);
        if (e instanceof BoolLiteral){
            BoolLiteral b = (BoolLiteral) e;
            b.setValue(!b.isValue());
            e=b;
            return b;
        }
        if (e instanceof IntLiteral){
            IntLiteral i = (IntLiteral) e;
            i.setValue(-i.getValue());
            e=i;
            return i;
        }
        if (e instanceof FloatLiteral){
            FloatLiteral f = (FloatLiteral) e;
            f.setValue(-f.getValue());
            e=f;
            return f;
        }
        return expr;
    }

    @Override
    public Expression visit(MethodCall expr) {
        for (Expression e: expr.getExpressions()){
            e=e.accept(this);
        }
        return expr;
    }

    @Override
    public Expression visit(Extern expr) {
        return expr;
    }

    @Override
    public Expression visit(IntLiteral lit) {
        return lit;
    }

    @Override
    public Expression visit(BoolLiteral lit) {
        return lit;
    }

    @Override
    public Expression visit(FloatLiteral lit) {
        return lit;
    }

    @Override
    public Expression visit(VarLocation loc) {
        return loc;
    }

    @Override
    public Expression visit(Block bl) {
        if(bl.getStatements()!=null)
            for (Statement s : bl.getStatements()){
                 s.accept(this);
            }
        return null;
    }
    
}
