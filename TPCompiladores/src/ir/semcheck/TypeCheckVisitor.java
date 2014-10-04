/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Implementa los visitors para cada clase en ir.ast (nodo del arbol)
 * Recorre el ast buscando errorres semanticos
 */
package ir.semcheck;

import java.util.List;

import ir.ASTVisitor;
import ir.ast.*;
import error.Error; // define class error
import java.util.LinkedList;
import tabladesimbolos.*;


// type checker, concrete visitor 
public class TypeCheckVisitor implements ASTVisitor<Type> {
	
	private LinkedList<Error> errors;

        public TypeCheckVisitor() {
            this.errors = new LinkedList<Error>();
        }

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
        
        public void showErrors(){
            for (Error e : errors){
                e.show();
            }
        }

	public void setErrors(LinkedList<Error> errors) {
		this.errors = errors;
	}

    @Override
    public Type visit(ReturnStmt stmt) {
        Expression e = stmt.getExpression();
        if (e!=null){
            if (!e.accept(this).isUndefined())
                return Type.VOID;
            else{
                addError(e,"Retorno invalido");
                return Type.UNDEFINED; 
            }
        }
        else
            return Type.VOID;    
    }

    @Override
    public Type visit(IfStmt stmt) {
        if (stmt==null){
            System.out.println("stmt es null");
        }
         if (stmt.getIfBlock()==null){
            System.out.println("block es null");
        }
        Type expr = stmt.getCondition().accept(this);
        Type ifBlock = stmt.getIfBlock().accept(this);
        if (stmt.getElseBlock()!=null){
           Type elseBlock = stmt.getElseBlock().accept(this);
            if (expr.isBool()){
                if (!ifBlock.isUndefined() && !elseBlock.isUndefined())
                    return Type.VOID;
                return Type.UNDEFINED;
            }
            else
                addError(stmt.getCondition(),"La condicion no es logica");
            return Type.UNDEFINED; 
        }
        else{
            if (expr.isBool()){
                if (!ifBlock.isUndefined())
                    return Type.VOID;

                return Type.UNDEFINED;
            }
            else
                addError(stmt.getCondition(),"La condicion no es logica");
            return Type.UNDEFINED; 
        }
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
        return loc.getDesc().getTipo();
    }

    @Override
    public Type visit(Block bl) {
        List<Statement> ls = bl.getStatements();
        if (ls!=null)
            for (Statement elem : ls) {
                if (elem.accept(this).isUndefined()){
                    return Type.UNDEFINED;
                }              
            }
        return Type.VOID;
    }

    @Override
    public Type visit(ForStmt stmt) {
        Type block = stmt.getBlock().accept(this);
        Type expr = stmt.getExpr().accept(this);
        Type exprfin = stmt.getExprfin().accept(this);
        if(expr.isInt())
            if (exprfin.isInt())
                if (!block.isUndefined())
                    return Type.VOID;
                else{
                    return Type.UNDEFINED;}
            else{
                 addError(stmt.getExprfin(), "La segunda expresion del for no es de tipo logico");
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
                 addError(stmt.getExpr(), "La condicion no es de tipo logico");
                 return Type.UNDEFINED;}
         else
            {
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
        List<Expression> ls = expr.getExpressions();
        if (ls!=null){
            for (Expression elem : ls) {
            if (elem.accept(this).isUndefined()){
                   addError(expr,"hay parametros con tipos inapropiados");
                return Type.UNDEFINED;
            }              
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
        return expr.getType();
    }

    @Override
    public Type visit(SkipStmt stmt) {
        return Type.VOID;
    }

    @Override
    public Type visit(ExternStmt stmt) {
           return Type.VOID;
           
    }

    @Override
    public Type visit(MethodCallStmt stmt) {
           return Type.VOID;
    }
}
