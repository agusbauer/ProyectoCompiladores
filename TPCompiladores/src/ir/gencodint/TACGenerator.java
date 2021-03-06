
 
/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPComiterLabelsdores
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
import static ir.gencodint.TACOpType.*;
import java.util.LinkedList;
import java.util.Stack;
import tabladesimbolos.Descriptor;
import tabladesimbolos.DescriptorSimple;


public class TACGenerator implements ASTVisitor<Expression> {

    private LinkedList<TACCommand> code;
    private int commId;
    private int labelId;
    private Stack<Pair<Integer,Integer>> iterLabels;
    private int cantMetodos;
    
    public TACGenerator(){
        code = new LinkedList();
        iterLabels = new Stack();
    }

    public int getCantMetodos() {
        return cantMetodos;
    }
    
    @Override
    public Expression visit(AssignStmt stmt) {
        Expression loc = stmt.getLocation().accept(this);
        
        AssignOpType op = stmt.getOperator();
        Expression expr = stmt.getExpression().accept(this);
        
        if (op.isAssign()){
            code.add(new TACCommand(TACOpType.STR,loc,expr,null));
        }else
            if (op.isDecrement())
               code.add(new TACCommand(TACOpType.SUB,loc,expr,loc));
            else
               code.add(new TACCommand(TACOpType.ADD,loc,expr,loc)); 
            
        return null;
    }

    @Override
    public Expression visit(ReturnStmt stmt) {;
        if(stmt.getExpression()!=null)
            code.add(new TACCommand(TACOpType.RET,stmt.getExpression().accept(this),null,null));
        else
            code.add(new TACCommand(TACOpType.RET,null,null,null));;
        
        return null; 
    }

    @Override
    public Expression visit(IfStmt stmt) {
        Expression cond = stmt.getCondition().accept(this); // cmp o lcon o opp
        String claseDeCondicion = stmt.getCondition().getClase();
        int labelIf = labelId++;
        if (claseDeCondicion.equals("bool")){
            BoolLiteral e =  (BoolLiteral)stmt.getCondition();
            if (!e.isValue()){
                code.add(new TACCommand(TACOpType.JMP,new IntLiteral(labelIf, ".LIF"), null, null));
            }
        }
        else{
            if (claseDeCondicion.equals("unary")){
               code.add(new TACCommand(TACOpType.JNOT,new IntLiteral(labelIf, ".LIF"), cond, null));
            }
            else{
                if(claseDeCondicion.equals("loc")){
                    code.add(new TACCommand(TACOpType.JNOT,new IntLiteral(labelIf, ".LIF"), cond, null));
                }
                else{
                    BinOpExpr e =  (BinOpExpr)stmt.getCondition();
                    switch (e.getOperator()){ // salto condicional
                        case NOTEQ : code.add(new TACCommand(TACOpType.JNE,new IntLiteral(labelIf, ".LIF"), null, null)); break;
                        case EQEQ : code.add(new TACCommand(TACOpType.JE,new IntLiteral(labelIf, ".LIF"), null, null)); break;
                        case GTEQ : code.add(new TACCommand(TACOpType.JGE,new IntLiteral(labelIf, ".LIF"), null, null)); break;
                        case LTEQ : code.add(new TACCommand(TACOpType.JLE,new IntLiteral(labelIf, ".LIF"), null, null)); break;
                        case GT : code.add(new TACCommand(TACOpType.JG,new IntLiteral(labelIf, ".LIF"), null, null));break;
                        case LT : code.add(new TACCommand(TACOpType.JL,new IntLiteral(labelIf, ".LIF"), null, null));break;
                        case AND : code.add(new TACCommand(TACOpType.JAND,new IntLiteral(labelIf, ".LIF"), cond, null));break;
                        case OR : code.add(new TACCommand(TACOpType.JOR,new IntLiteral(labelIf, ".LIF"), cond, null));break;
                    }
                }
            }
        }
        stmt.getIfBlock().accept(this); //bloque if
        if(stmt.getElseBlock()!=null){
            code.add(new TACCommand(TACOpType.JMP,new IntLiteral(labelIf, ".LEIF"), null, null));
        }
        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(labelIf, ".LIF"), null, null)); // label del else
        if(stmt.getElseBlock()!=null){
            stmt.getElseBlock().accept(this); //bloque else
            code.add(new TACCommand(TACOpType.LBL,new IntLiteral(labelIf, ".LEIF"), null, null));
        }
        return null;
    }

    @Override
    public Expression visit(ForStmt stmt) {
        iterLabels.push(new Pair<>(++labelId,labelId)); //guardo los valores del begin y end
        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(iterLabels.peek().fst(), ".BI"), null, null)); // label del for
        Expression from = stmt.getExpr().accept(this);
        VarLocation variableDelFor = new VarLocation(stmt.getId(),stmt.getVar());
        code.add(new TACCommand(TACOpType.STR,variableDelFor,from,null)); //asignacion ojo aca!!!
        Expression to = stmt.getExprfin().accept(this);
        ++commId;
        int id = commId;
        DescriptorSimple d = new DescriptorSimple("temp" + id,Type.INT,false); // hay que ver si esto es asi!!!!!!
        d.setOp(BinOpType.LTEQ);
        VarLocation var = new VarLocation("temp" + id,d);
        
        code.add(new TACCommand(TACOpType.CMP,variableDelFor,to,var));
        code.add(new TACCommand(TACOpType.JLE,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null));
        stmt.getBlock().accept(this);
        code.add(new TACCommand(TACOpType.ADD,variableDelFor,new IntLiteral(1,null),variableDelFor));
        code.add(new TACCommand(TACOpType.JMP,new IntLiteral(iterLabels.peek().fst(), ".BI"), null, null));//salto al comienzo del for
        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null));//label end del for
        iterLabels.pop(); // elimino los valores de end y begin     
        return null;
    }

    @Override
    public Expression visit(WhileStmt stmt) {
        iterLabels.push(new Pair<>(++labelId,labelId)); //guardo valores de begin y end

        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(iterLabels.peek().fst(), ".BI"), null, null)); // label del while
        Expression cond = stmt.getExpr().accept(this); // cmp o lcon o opp
        String claseDeCondicion = stmt.getExpr().getClase();
        if (claseDeCondicion.equals("bool")){
            BoolLiteral e =  (BoolLiteral)stmt.getExpr();
            if (!e.isValue()){
                code.add(new TACCommand(TACOpType.JMP,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null));
            }
        }
        else{
            if (claseDeCondicion.equals("unary")){
               code.add(new TACCommand(TACOpType.JNOT,new IntLiteral(iterLabels.peek().snd(), ".EI"), cond, null));
            }
            else{ 
                if(claseDeCondicion.equals("loc")){
                    code.add(new TACCommand(TACOpType.JNOT,new IntLiteral(iterLabels.peek().snd(), ".EI"), cond, null));
                }
                else{
                    BinOpExpr e = (BinOpExpr) stmt.getExpr();
                    switch (e.getOperator()){ // salto condicional
                        case NOTEQ : code.add(new TACCommand(TACOpType.JNE,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null)); break;
                        case EQEQ : code.add(new TACCommand(TACOpType.JE,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null)); break;
                        case GTEQ : code.add(new TACCommand(TACOpType.JGE,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null)); break;
                        case LTEQ : code.add(new TACCommand(TACOpType.JLE,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null)); break;
                        case GT : code.add(new TACCommand(TACOpType.JG,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null));break;
                        case LT : code.add(new TACCommand(TACOpType.JL,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null));break;
                        case AND : code.add(new TACCommand(TACOpType.JAND,new IntLiteral(iterLabels.peek().snd(), ".EI"), cond, null));break;
                        case OR : code.add(new TACCommand(TACOpType.JOR,new IntLiteral(iterLabels.peek().snd(), ".EI"), cond, null));break;
                    }        
                }
            }
        }
        stmt.getBlock().accept(this);
        code.add(new TACCommand(TACOpType.JMP,new IntLiteral(iterLabels.peek().fst(), ".BI"), null, null)); //salto al comienzo del while
        code.add(new TACCommand(TACOpType.LBL,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null)); //label end del while
        iterLabels.pop(); //elimino los valores del begin y end
        return null;
    }

    @Override
    public Expression visit(BreakStmt stmt) {
        code.add(new TACCommand(TACOpType.JMP,new IntLiteral(iterLabels.peek().snd(), ".EI"), null, null));
        return null;
    }

    @Override
    public Expression visit(ContinueStmt stmt) {
        code.add(new TACCommand(TACOpType.JMP,new IntLiteral(iterLabels.peek().fst(), ".BI"), null, null));
        return null;
    }

    @Override
    public Expression visit(SkipStmt stmt) {
        return null;
    }

    @Override
    public Expression visit(ExternStmt stmt) {
        stmt.getE().accept(this);
        return null;
    }

    @Override
    public Expression visit(MethodCallStmt stmt) {
        stmt.getM().accept(this);
        return null;
    }

    @Override
    public Expression visit(BinOpExpr expr) {
        BinOpType op = expr.getOperator();
        Expression left = expr.getLeftOperand().accept(this); // codigo de primer operando
        Expression right = expr.getRightOperand().accept(this); // codigo de segundo operando
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,expr.getType(),false));
        if (op.isRelational() || op.isEquational()){
            var.getDesc().setOp(op);
            code.add(new TACCommand(TACOpType.CMP,left,right,var)); 
        }    
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
        Expression e = expr.getOperand().accept(this);
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,expr.getType(),false));
        if (expr.getOperator().isMinus())
            code.add(new TACCommand(TACOpType.OPP,e,var,null));
        else
            code.add(new TACCommand(TACOpType.NOT,e,var,null));
        return var;
    }

    @Override
    public Expression visit(MethodCall expr) {
        if (expr.getExpressions()!=null){
            LinkedList<Expression> list = (LinkedList)expr.getExpressions();
            for (int i=0; i< list.size(); i++){
                    Expression e = list.get(i).accept(this);
                    list.set(i, e);   
            }
            expr.setExpressions(list);
        }
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,expr.getType(),false));
        code.add(new TACCommand(TACOpType.CALL,expr, var, null));
        return var;
   
    }

    @Override
    public Expression visit(Extern expr) {
        if (expr.getArgs()!=null){
            LinkedList<Object> list = (LinkedList)expr.getArgs();
            for (int i=0; i< list.size(); i++){
                if (list.get(i) instanceof Expression){
                    Expression e = ((Expression)list.get(i));
                    Expression e2 = e.accept(this);
                    list.set(i, e2);
                }
            }
            expr.setArgs(list);
        }
        ++commId;
        int id = commId;
        VarLocation var = new VarLocation("temp" + id,new DescriptorSimple("temp" + id,expr.getType(),false));
        code.add(new TACCommand(TACOpType.EXCALL,expr, var, null));
        return var;

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
        if (loc.getIndice()!=null){
            loc.setIndice(loc.getIndice().accept(this)); // guarda el resultado de evaluar la expresion del indice del arreglo
        }  
        return loc;
    }

    @Override
    public Expression visit(Block bl) {
        if (bl.getMethodName()!=null){ //es un metodo
            IntLiteral i = new IntLiteral(null, bl.getMethodName());
            Descriptor.setOffsetCorriente(bl.getOffSetMax());
            i.setAuxValue(Descriptor.getOffsetCorriente());// offset maximo sin temporales
            TACCommand mname = new TACCommand(TACOpType.MNAME, i , null, null);
            code.add(mname);
            cantMetodos++;
            if(bl.getStatements()!=null)
            for (Statement s : bl.getStatements()){
                 s.accept(this);
            }
            IntLiteral il = (IntLiteral) mname.getP1();
            il.setAuxValue(Descriptor.getOffsetCorriente()); // offset maximo con temporales
            code.add(new TACCommand(TACOpType.RET,null,null,null)); // return por defecto
        }
        else{
            if(bl.getStatements()!=null)
                for (Statement s : bl.getStatements()){
                     s.accept(this);
                }
        }
        return null;
    }

    public LinkedList<TACCommand> getCode() {
        return code;
    }
    
    
    
}
