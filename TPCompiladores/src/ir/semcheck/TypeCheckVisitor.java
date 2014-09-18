package ir.semcheck;

import java.util.List;

import ir.ASTVisitor;
import ir.ast.*;
import error.Error; // define class error


// type checker, concrete visitor 
public class TypeCheckVisitor implements ASTVisitor<Type> {
	
	private List<Error> errors;

	@Override
	public Type visit(AssignStmt stmt) {
            Type left = stmt.getLocation().accept(this);
            AssignOpType op = stmt.getOperator();
            Type right = stmt.getExpression().accept(this);
            if (left.equals(right)){
                if (!left.isArray()){
                    if (left.isBool())
                        if (!op.isAssign())
                            addError(stmt,"Operacion invalida");
                        else
                            return Type.VOID;
                    if (left.isInt() || left.isFloat())
                        return Type.VOID;
                }
                else
                    addError(stmt,"Operacion invalida");        
            }
            else
                addError(stmt,"Al destino le queres asignar algo que no es del mismo tipo");
            return Type.UNDEFINED;

	}

	@Override
	public Type visit(BinOpExpr expr) {
            Type left = expr.getLeftOperand().accept(this);
            BinOpType op = expr.getOperator();
            Type right = expr.getRightOperand().accept(this);
            if (left.equals(right))
               if (left.isBool())
                   if (op.isConditional() || op.isEquational())
                       return Type.BOOL;
                   else
                       addError(expr, "Los operandos son logicos sin embargo el operador no lo es");
               else
                   if (left.isFloat() || left.isInt())
                       if (op.isArithmetic())
                           return left;
                       else
                           if (op.isEquational() || op.isRelational())
                               return Type.BOOL;
                           else
                               addError(expr, "Los operandos son aritmeticos sin embargo el operador es logico");
                   else
                       addError(expr, "Operacion invalida");
            addError(expr, "Los operandos son de tipos distintos");
            return Type.UNDEFINED;
	}


	private void addError(AST a, String desc) {
		errors.add(new Error(a.getLineNumber(), a.getColumnNumber(), desc));
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

    @Override
    public Type visit(ReturnStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(IfStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(IntLiteral lit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(VarLocation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(Block bl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(ForStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(WhileStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(BreakStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(ContinueStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(UnaryOpExpr expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(MethodCall expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(BoolLiteral lit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(FloatLiteral lit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(Extern expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(SkipStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(ExternStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type visit(MethodCallStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
