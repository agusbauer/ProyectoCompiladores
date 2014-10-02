/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * 
 */
package ir.gencodint;

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
import java.util.LinkedList;
import java.util.Stack;
import tabladesimbolos.Descriptor;
import tabladesimbolos.DescriptorSimple;


public class TACGenerator implements ASTVisitor<Expression> {

    private LinkedList<TACCommand> code;
    private int commId;
    private int labelId;
    private int beginIter; // sirve para el label del comienzo de un bucle 
    private int endIter; // sirve para el label del fin de un bucle
    private Stack pila;
    
    public TACGenerator(){
        code = new LinkedList();
        pila = new Stack<>();
    }
    
    @Override
    public Expression visit(AssignStmt stmt) {
        Expression loc = stmt.getLocation().accept(this);
        
        AssignOpType op = stmt.getOperator();
        Expression expr = stmt.getExpression().accept(this);
        
        if (op.isAssign())
            code.add(new TACCommand(TACOpType.STR,loc,expr,null));
        else
            if (op.isDecrement())
               code.add(new TACCommand(TACOpType.SUB,loc,expr,loc));
            else
               code.add(new TACCommand(TACOpType.ADD,loc,expr,loc)); 
            
        return null;
    }

    @Override
    public Expression visit(ReturnStmt stmt) {;
        code.add(new TACCommand(TACOpType.RET,null,null,null));
        return null; 
    }

    @Override
    public Expression visit(IfStmt stmt) {
        BinOpExpr e = (BinOpExpr) stmt.getCondition();
        stmt.getCondition().accept(this); // cmp
        labelId++;
        switch (e.getOperator()){ // salto condicional
            case NOTEQ : code.add(new TACCommand(TACOpType.JNE,new IntLiteral(labelId, "LIF"), null, null)); break;
            case EQEQ : code.add(new TACCommand(TACOpType.JE,new IntLiteral(labelId, "LIF"), null, null)); break;
            case GTEQ : code.add(new TACCommand(TACOpType.JGE,new IntLiteral(labelId, "LIF"), null, null)); break;
            case LTEQ : code.add(new TACCommand(TACOpType.JLE,new IntLiteral(labelId, "LIF"), null, null)); break;
            case GT : code.add(new TACCommand(TACOpType.JG,new IntLiteral(labelId, "LIF"), null, null));break;
            case LT : code.add(new TACCommand(TACOpType.JL,new IntLiteral(labelId, "LIF"), null, null));break;
            case AND : code.add(new TACCommand(TACOpType.JAND,new IntLiteral(labelId, "LIF"), null, null));break;
            case OR : code.add(new TACCommand(TACOpType.JOR,new IntLiteral(labelId, "LIF"), null, null));break;
        }
        stmt.getIfBlock().accept(this); //bloque if
        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(labelId, "LIF"), null, null)); // label del else
        stmt.getElseBlock().accept(this); //bloque else
        return null;
    }

    @Override
    public Expression visit(ForStmt stmt) {
        beginIter = (++labelId);
        endIter = (++labelId); //label end del for
        pila.push(new Pair<>(beginIter,endIter)); //guardo los valores del begin y end
        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(beginIter, "LBI"), null, null)); // label del for
        code.add(new TACCommand(TACOpType.STR,new IntLiteral(0,stmt.getId()),stmt.getExpr().accept(this),new IntLiteral(++commId,"r"))); //asignacion ojo aca!!!
        BinOpExpr e = (BinOpExpr) stmt.getCondition();
        e.accept(this); //cmp  
        switch (e.getOperator()){ // salto condicional
            case NOTEQ : code.add(new TACCommand(TACOpType.JNE,new IntLiteral(endIter, "EI"), null, null)); break;
            case EQEQ : code.add(new TACCommand(TACOpType.JE,new IntLiteral(endIter, "EI"), null, null)); break;
            case GTEQ : code.add(new TACCommand(TACOpType.JGE,new IntLiteral(endIter, "EI"), null, null)); break;
            case LTEQ : code.add(new TACCommand(TACOpType.JLE,new IntLiteral(endIter, "EI"), null, null)); break;
            case GT : code.add(new TACCommand(TACOpType.JG,new IntLiteral(endIter, "EI"), null, null));break;
            case LT : code.add(new TACCommand(TACOpType.JL,new IntLiteral(endIter, "EI"), null, null));break;
            case AND : code.add(new TACCommand(TACOpType.JAND,new IntLiteral(endIter, "EI"), null, null));break;
            case OR : code.add(new TACCommand(TACOpType.JOR,new IntLiteral(endIter, "EI"), null, null));break;
        }
        stmt.getBlock().accept(this);
        code.add(new TACCommand(TACOpType.JMP,new IntLiteral(beginIter, "BI"), null, null));//salto al comienzo del for
        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(endIter, "EI"), null, null));//label end del for
        pila.pop(); // elimino los valores de end y begin      
        return null;
    }

    @Override
    public Expression visit(WhileStmt stmt) {
        beginIter = (++labelId);
        endIter = (++labelId); //label end del while
        pila.push(new Pair<>(beginIter,endIter)); //guardo valores de begin y end
        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(beginIter, "LBI"), null, null)); // label del while
        BinOpExpr e = (BinOpExpr) stmt.getExpr();
        e.accept(this); //cmp
        
        switch (e.getOperator()){ // salto condicional
            case NOTEQ : code.add(new TACCommand(TACOpType.JNE,new IntLiteral(endIter, "EI"), null, null)); break;
            case EQEQ : code.add(new TACCommand(TACOpType.JE,new IntLiteral(endIter, "EI"), null, null)); break;
            case GTEQ : code.add(new TACCommand(TACOpType.JGE,new IntLiteral(endIter, "EI"), null, null)); break;
            case LTEQ : code.add(new TACCommand(TACOpType.JLE,new IntLiteral(endIter, "EI"), null, null)); break;
            case GT : code.add(new TACCommand(TACOpType.JG,new IntLiteral(endIter, "EI"), null, null));break;
            case LT : code.add(new TACCommand(TACOpType.JL,new IntLiteral(endIter, "EI"), null, null));break;
            case AND : code.add(new TACCommand(TACOpType.JAND,new IntLiteral(endIter, "EI"), null, null));break;
            case OR : code.add(new TACCommand(TACOpType.JOR,new IntLiteral(endIter, "EI"), null, null));break;
        }
        stmt.getBlock().accept(this);
        code.add(new TACCommand(TACOpType.JMP,new IntLiteral(beginIter, "BI"), null, null)); //salto al comienzo del while
        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(endIter, "EI"), null, null)); //label end del while
        pila.pop(); //elimino los valores del begin y end
        return null;
    }

    @Override
    public Expression visit(BreakStmt stmt) {
        code.add(new TACCommand(TACOpType.JMP,new IntLiteral(endIter, "BI"), null, null));
        return null;
    }

    @Override
    public Expression visit(ContinueStmt stmt) {
        code.add(new TACCommand(TACOpType.JMP,new IntLiteral(beginIter, "BI"), null, null));
        return null;
    }

    @Override
    public Expression visit(SkipStmt stmt) {
        return null;
    }

    @Override
    public Expression visit(ExternStmt stmt) {
        code.add(new TACCommand(TACOpType.EXCALL,stmt.getE(), null, null));
        return null;
    }

    @Override
    public Expression visit(MethodCallStmt stmt) {
        code.add(new TACCommand(TACOpType.CALL,stmt.getM(), null, null));
        return null;
    }

    @Override
    public Expression visit(BinOpExpr expr) {
        BinOpType op = expr.getOperator();
        Expression left = expr.getLeftOperand().accept(this); // codigo de primer operando
        Expression right = expr.getRightOperand().accept(this); // codigo de primer operando
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,Type.INT,DescriptorSimple.getOffset()+4));
        if (op.isRelational() || op.isEquational())
            code.add(new TACCommand(TACOpType.CMP,left,right,var)); 
            
        else 
            
            switch (op) {
                case MINUS :  code.add(new TACCommand(TACOpType.SUB,left,right,var)); break;
                case PLUS :  code.add(new TACCommand(TACOpType.ADD,left,right,var)); break; 
                case TIMES : code.add(new TACCommand(TACOpType.MUL,left,right,var)); break;
                case DIVIDE : code.add(new TACCommand(TACOpType.DIV,left,right,var)); break;  
                case MOD :  code.add(new TACCommand(TACOpType.MOD,left,right,var)); break;
                case AND :  code.add(new TACCommand(TACOpType.AND,left,right,var)); break;   
                case OR :  code.add(new TACCommand(TACOpType.OR,left,right,var)); break;  
            }
        return var;
    }

    @Override
    public Expression visit(UnaryOpExpr expr) {
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,Type.INT,DescriptorSimple.getOffset()+4));
        code.add(new TACCommand(TACOpType.OPP,expr.getOperand().accept(this),var,null));
        return var;
    }

    @Override
    public Expression visit(MethodCall expr) {
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,expr.getType(),DescriptorSimple.getOffset()+4));
        code.add(new TACCommand(TACOpType.CALL,expr, var, null));
        return var;
    }

    @Override
    public Expression visit(Extern expr) {
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,expr.getType(),DescriptorSimple.getOffset()+4));
        code.add(new TACCommand(TACOpType.EXCALL,expr, var, null));
        return var;
    }

    @Override
    public Expression visit(IntLiteral lit) {
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,Type.INT,DescriptorSimple.getOffset()+4));
        code.add(new TACCommand(TACOpType.LCON,lit,var,null));
        return var;
    }

    @Override
    public Expression visit(BoolLiteral lit) {
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,Type.INT,DescriptorSimple.getOffset()+4));
        code.add(new TACCommand(TACOpType.LCON,lit,var,null));
        return var;
    }

    @Override
    public Expression visit(FloatLiteral lit) {
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,Type.INT,DescriptorSimple.getOffset()+4));
        code.add(new TACCommand(TACOpType.LCON,lit,var,null));
        return var;
    }

    @Override
    public Expression visit(VarLocation loc) {
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,Type.INT,DescriptorSimple.getOffset()+4));
        code.add(new TACCommand(TACOpType.LMEM,loc,var,null));
        return var;
    }

    @Override
    public Expression visit(Block bl) {
        for (Statement s : bl.getStatements()){
            s.accept(this);
        }
        return null;
    }

    public LinkedList<TACCommand> getCode() {
        return code;
    }
    
}
