/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * 
 */
package ir;

import ir.ast.AssignStmt;
import ir.ast.BinOpExpr;
import ir.ast.Block;
import ir.ast.BoolLiteral;
import ir.ast.BreakStmt;
import ir.ast.ContinueStmt;
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
import ir.ast.UnaryOpExpr;
import ir.ast.VarLocation;
import ir.ast.WhileStmt;

public class ImplementsASTVisitor implements ASTVisitor<String>{

    @Override
    public String visit(AssignStmt stmt) {
        return stmt.toString();
    }

    @Override
    public String visit(ReturnStmt stmt) {
        return stmt.toString();
    }

    @Override
    public String visit(IfStmt stmt) {
        return stmt.toString();
    }

    @Override
    public String visit(ForStmt stmt) {
        return stmt.toString();
    }

    @Override
    public String visit(WhileStmt stmt) {
        return stmt.toString();
    }

    @Override
    public String visit(BreakStmt stmt) {
        return stmt.toString();
    }

    @Override
    public String visit(ContinueStmt stmt) {
        return stmt.toString();
    }

    @Override
    public String visit(SkipStmt stmt) {
        return stmt.toString();
    }

    @Override
    public String visit(BinOpExpr expr) {
        return expr.toString();
    }

    @Override
    public String visit(UnaryOpExpr expr) {
        return expr.toString();
    }

    @Override
    public String visit(MethodCall expr) {
        return expr.toString();
    }

    @Override
    public String visit(Extern expr) {
        return expr.toString();
    }

    @Override
    public String visit(IntLiteral lit) {
        return lit.toString();
    }

    @Override
    public String visit(BoolLiteral lit) {
        return lit.toString();
    }

    @Override
    public String visit(FloatLiteral lit) {
        return lit.toString();
    }

    @Override
    public String visit(VarLocation loc) {
        return loc.toString();
    }

    @Override
    public String visit(Block bl) {
        return bl.toString();
    }

    @Override
    public String visit(ExternStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(MethodCallStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
