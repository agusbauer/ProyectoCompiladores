package ir.semcheck;

import java.util.List;

import ir.ASTVisitor;
import ir.ast.*;
import error.Error; // define class error
import java.util.LinkedList;
import tabladesimbolos.*;


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
        if (!stmt.getExpression().accept(this).isUndefined())
            return Type.VOID;
        else
            addError(stmt,"Retorno invalido");
            return Type.UNDEFINED;    
    }

    @Override
    public Type visit(IfStmt stmt) {
        Type expr = stmt.getCondition().accept(this);
        Type ifBlock = stmt.getIfBlock().accept(this);
        Type elseBlock = stmt.getElseBlock().accept(this);
        if (expr.isBool()){
            if (!ifBlock.isUndefined() && !elseBlock.isUndefined())
                return Type.VOID;
            else
                addError(stmt,"Hay problemas en alguno de los bloques");
                return Type.UNDEFINED;
        }
        else
            addError(stmt,"La condicion no es logica");
            return Type.UNDEFINED;
    }

    @Override
    public Type visit(IntLiteral lit) {
        if (lit.getType().isInt())
            return Type.INT;
        else
            addError(lit,"Tipo invalido, se esperaba un entero");
            return Type.UNDEFINED;
    }

    @Override
    public Type visit(VarLocation loc) {
        return loc.getType();
    }

    @Override
    public Type visit(Block bl) {
        List<Statement> ls = bl.getStatements();
        for (Statement elem : ls) {
           if (elem.accept(this).isUndefined()){
               addError(bl,"El bloque contiene problemas en alguna sentencia");
               return Type.UNDEFINED;
           }              
        }
        return Type.VOID;
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
        List<Expression> ls = expr.getExpressions();
        for (Expression elem : ls) {
           if (elem.accept(this).isUndefined()){
               addError(expr,"hay parametros con tipos inapropiados");
               return Type.UNDEFINED;
           }              
        }
        return expr.getType();
    }

    @Override
    public Type visit(BoolLiteral lit) {
        if (lit.getType().isBool())
            return Type.BOOL;
        else
            addError(lit,"Tipo invalido, se esperaba un valor logico");
            return Type.UNDEFINED;
    }

    @Override
    public Type visit(FloatLiteral lit) {
        if (lit.getType().isFloat())
            return Type.FLOAT;
        else
            addError(lit,"Tipo invalido, se esperaba un real");
            return Type.UNDEFINED;
    }

    @Override
    public Type visit(Extern expr) {
        return expr.accept(this);
    }

    @Override
    public Type visit(SkipStmt stmt) {
        return Type.VOID;
    }

    @Override
    public Type visit(ExternStmt stmt) {
       if(!stmt.getE().accept(this).isUndefined())
           return Type.VOID;
       else
           return Type.UNDEFINED; 
           
    }

    @Override
    public Type visit(MethodCallStmt stmt) {
        if(!stmt.getM().accept(this).isUndefined())
           return Type.VOID;
       else
           return Type.UNDEFINED; 
    }
}
