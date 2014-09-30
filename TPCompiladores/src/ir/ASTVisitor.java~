package ir;

import ir.ast.*;

// Abstract visitor
public interface ASTVisitor<T> {
// visit statements
	T visit(AssignStmt stmt);
	T visit(ReturnStmt stmt);
	T visit(IfStmt stmt);
        T visit(ForStmt stmt);
        T visit(WhileStmt stmt);
        T visit(BreakStmt stmt);
        T visit(ContinueStmt stmt);
        T visit(SkipStmt stmt);
        T visit(ExternStmt stmt);
        T visit(MethodCallStmt stmt);
	
// visit expressions
	T visit(BinOpExpr expr);
        T visit(UnaryOpExpr expr);
        T visit(MethodCall expr);
        T visit(Extern expr);
	
// visit literals	
	T visit(IntLiteral lit);       
        T visit(BoolLiteral lit);
        T visit(FloatLiteral lit);

// visit locations	
	T visit(VarLocation loc);
        
// visit blocks
        T visit(Block bl);

}
