/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
import ir.ast.UnaryOpExpr;
import ir.ast.VarLocation;
import ir.ast.WhileStmt;
import java.util.LinkedList;

/**
 *
 * @author luciano
 */
public class TACGenerator implements ASTVisitor<Expression> {

    private LinkedList<TACCommand> code;
    private int commId;
    private int labelId;
    private int dirRet;
    private int beginIter; // sirve para el label del comienzo de un bucle 
    private int endIter; // sirve para el label del fin de un bucle 
    
    public TACGenerator(){
        code = new LinkedList();
    }
    
    @Override
    public Expression visit(AssignStmt stmt) {
        Expression loc = stmt.getLocation().accept(this);
        loc.setTACid(++commId);
        AssignOpType op = stmt.getOperator();
        Expression expr = stmt.getExpression().accept(this);
        expr.setTACid(++commId);
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
        code.add(new TACCommand(TACOpType.JMP,new IntLiteral(dirRet,"LFM"),null,null));
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
    public String visit(ForStmt stmt) {
        int oldBegin = beginIter; // guardo los valores anteriores de begin y end
        int oldEnd = endIter;
        beginIter = (++labelId);
        code.add("L"+beginIter); // label del for
        code.add("STR"+" "+stmt.getId()+" "+stmt.getExpr().accept(this)+" "+"r"+(++commId));  //asignacion
        BinOpExpr e = (BinOpExpr) stmt.getCondition();
        e.accept(this); //cmp
        endIter = (++labelId); //label end del for
        String resto ="L"+endIter;
        switch (e.getOperator()){ // salto condicional
            case NOTEQ : code.add("JNE"+resto);break;
            case EQEQ : code.add("JE"+resto);break;
            case GTEQ : code.add("JGE"+resto);break;
            case LTEQ : code.add("JLE"+resto);break;
            case GT : code.add("JG"+resto);break;
            case LT : code.add("JL"+resto);break;
            case AND : code.add("JAND"+resto);break;
            case OR : code.add("JOR"+resto);break;
        }
        stmt.getBlock().accept(this);
        code.add("JMP"+" "+beginIter); //salto al comienzo del for
        code.add("L"+endIter); //label end del for
        beginIter = oldBegin; // restauro los antiguos valores de end y begin
        endIter = oldEnd; 
        return "";
    }

    @Override
    public String visit(WhileStmt stmt) {
        int oldBegin = beginIter; // guardo los valores anteriores de begin y end
        int oldEnd = endIter;
        beginIter = (++labelId);
        code.add("L"+beginIter); // label del while
        BinOpExpr e = (BinOpExpr) stmt.getExpr();
        e.accept(this); //cmp
        endIter = (++labelId); //label end del while
        String resto ="L"+endIter;
        switch (e.getOperator()){ // salto condicional
            case NOTEQ : code.add("JNE"+resto);break;
            case EQEQ : code.add("JE"+resto);break;
            case GTEQ : code.add("JGE"+resto);break;
            case LTEQ : code.add("JLE"+resto);break;
            case GT : code.add("JG"+resto);break;
            case LT : code.add("JL"+resto);break;
            case AND : code.add("JAND"+resto);break;
            case OR : code.add("JOR"+resto);break;
        }
        stmt.getBlock().accept(this);
        code.add("JMP"+" "+beginIter); //salto al comienzo del while
        code.add("L"+endIter); //label end del while
        beginIter = oldBegin; // restauro los antiguos valores de end y begin
        endIter = oldEnd; 
        return "";
    }

    @Override
    public String visit(BreakStmt stmt) {
        code.add("JMP"+" "+"L"+endIter);
        return "";
    }

    @Override
    public String visit(ContinueStmt stmt) {
        code.add("JMP"+" "+"L"+beginIter);
        return "";
    }

    @Override
    public String visit(SkipStmt stmt) {
        return "";
    }

    @Override
    public String visit(ExternStmt stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(MethodCallStmt stmt) {
        code.add("JMP"+" "+stmt.getM().getId());
        dirRet = (++labelId);
        stmt.getM().accept(this);
        code.add("L"+dirRet); //label de retorno
        return "";
    }

    @Override
    public String visit(BinOpExpr expr) {
        BinOpType op = expr.getOperator();
        String left = expr.getLeftOperand().accept(this); // codigo de primer operando
        String right = expr.getRightOperand().accept(this); // codigo de primer operando
        String resto = " " + left +" "+ right +" " + "r"+(++commId); 
        if (op.isRelational() || op.isEquational())
            code.add("CMP"+ resto);
        else
            switch (op) {
                case MINUS :  code.add("SUB"+ resto ); break;
                case PLUS :  code.add("ADD"+ resto ); break;
                case TIMES :  code.add("MUL"+ resto ); break;
                case DIVIDE :  code.add("DIV"+ resto ); break;
                case MOD :  code.add("MOD"+ resto ); break;
                case AND :  code.add("AND"+ resto );  break;   
                case OR :  code.add("OR"+ resto );  break;  
            }
        return "r"+commId;
    }

    @Override
    public String visit(UnaryOpExpr expr) {
        code.add("OPP"+" "+expr.getOperand().accept(this) + " "+ "r"+(++commId));
        return "r"+commId;
    }

    @Override
    public String visit(MethodCall expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(Extern expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String visit(IntLiteral lit) {
        code.add("LCON"+" "+ lit.getValue() + " " + "r"+(++commId));
        return "r"+commId;
    }

    @Override
    public String visit(BoolLiteral lit) {
        code.add("LCON"+" "+ lit.isValue() + " " + "r"+(++commId));
        return "r"+commId;
    }

    @Override
    public String visit(FloatLiteral lit) {
        code.add("LCON"+" "+ lit.getValue() + " " + "r"+(++commId));
        return "r"+commId;
    }

    @Override
    public String visit(VarLocation loc) {
        code.add("LMEM"+" "+ loc.getId() + " " + "r"+(++commId));
        return "r"+commId;
    }

    @Override
    public String visit(Block bl) {
        for (Statement s : bl.getStatements()){
            s.accept(this);
        }
        return "";
    }

    public LinkedList<String> getCode() {
        return code;
    }
    
}
