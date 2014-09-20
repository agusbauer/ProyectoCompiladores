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
        Type block = stmt.getBlock().accept(this);
        Type cond = stmt.getCondition().accept(this);
        Type expr = stmt.getExpr().accept(this);
        if(expr.isInt())
            if (cond == Type.BOOL)
                if (!block.isUndefined())
                    return Type.VOID;
                else{
                    addError(stmt, "Problemas en el bloque");
                    return Type.UNDEFINED;}
            else{
                 addError(stmt, "La condicion no es de tipo logico");
                 return Type.UNDEFINED;}
        else{
             addError(stmt, "A la variable de control le asignas un valor que no es entero");
             return Type.UNDEFINED;}
    }

    @Override
    public Type visit(WhileStmt stmt) {
         Type block = stmt.getBlock().accept(this);
         Type expr = stmt.getExpr().accept(this);
         if(!block.isUndefined())
             if(expr.isBool())
                 return Type.VOID;
             else{
                 addError(stmt, "La condicion no es de tipo logico");
                 return Type.UNDEFINED;}
         else
            {addError(stmt, "Problemas en el bloque");
             return Type.UNDEFINED;}
       
    }

    @Override
    public Type visit(BreakStmt stmt) {
        return Type.VOID;
    }

    @Override
    public Type visit(ContinueStmt stmt) {
        return Type.VOID;
    }

    @Override
    public Type visit(UnaryOpExpr expr) {
       Type operand = expr.getOperand().accept(this);
       UnaryOpType operator =  expr.getOperator();
       if(operator.isMinus() && (operand.isFloat() || operand.isInt()))
           return operand;
       else
           if (operator.isNot() && operand.isBool())
               return Type.BOOL;
       addError(expr, "Error de tipos");
       return Type.UNDEFINED;     
    }

    @Override
    public Type visit(MethodCall expr) {
        
        return Type.UNDEFINED;
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
