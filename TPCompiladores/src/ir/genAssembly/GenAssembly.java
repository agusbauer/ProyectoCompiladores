/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * 
 */

package ir.genAssembly;

import ir.ast.Literal;
import ir.ast.VarLocation;
import ir.gencodint.TACCommand;
import static ir.gencodint.TACOpType.ADD;
import static ir.gencodint.TACOpType.AND;
import static ir.gencodint.TACOpType.CALL;
import static ir.gencodint.TACOpType.CMP;
import static ir.gencodint.TACOpType.DIV;
import static ir.gencodint.TACOpType.EXCALL;
import static ir.gencodint.TACOpType.JAND;
import static ir.gencodint.TACOpType.JE;
import static ir.gencodint.TACOpType.JG;
import static ir.gencodint.TACOpType.JGE;
import static ir.gencodint.TACOpType.JL;
import static ir.gencodint.TACOpType.JLE;
import static ir.gencodint.TACOpType.JMP;
import static ir.gencodint.TACOpType.JNE;
import static ir.gencodint.TACOpType.JNOT;
import static ir.gencodint.TACOpType.JOR;
import static ir.gencodint.TACOpType.LBL;
import static ir.gencodint.TACOpType.MOD;
import static ir.gencodint.TACOpType.MUL;
import static ir.gencodint.TACOpType.OPP;
import static ir.gencodint.TACOpType.OR;
import static ir.gencodint.TACOpType.RET;
import static ir.gencodint.TACOpType.STR;
import static ir.gencodint.TACOpType.SUB;
import java.util.LinkedList;


public class GenAssembly {
    
    private LinkedList<TACCommand> TACCode;
    LinkedList<String> assembly;
    
    public GenAssembly(LinkedList l){
        TACCode = l;
        assembly = new LinkedList();
    }
    public LinkedList<String> genAssembly(){      
        for (TACCommand c : TACCode){
            switch (c.getOp()) {
                case STR : str(c);break;
                case ADD : add(c);break;
                case SUB : sub(c);break;
                case MUL : mul(c);break;   
                case DIV : div(c);break;
                case AND : and(c);break; //terminar de hacer bien and y or
                case OR :  or(c);break;
                case MOD : mod(c);break;
                case JMP : assembly.add("JMP, "+c.getP1().toString()); break;
                case JG : assembly.add("JG, "+c.getP1().toString()); break; 
                case JL : assembly.add("JL, "+c.getP1().toString()); break;
                case JGE : assembly.add("JGE, "+c.getP1().toString()); break;
                case JLE : assembly.add("JLE, "+c.getP1().toString()); break;
                case JE : assembly.add("JE, "+c.getP1().toString()); break;
                case JNE : assembly.add("JNE, "+c.getP1().toString()); break;
                case JAND: jand(c); break; //VER SI ESTO ES CORRECTO
                case JOR :
                case JNOT :
                case LBL :
                case OPP :
                case CMP :
                case EXCALL :
                case CALL :
                case RET :
            }
            
        }
        return null;
    }
    
    public void jand (TACCommand c){
        assembly.add("CMP %reax, $1");
        assembly.add("JE "+ c.getP1().toString());
    }
    public void str(TACCommand c){
        assembly.add("MOV $"+c.getP2().toString()+", %rax");
        VarLocation loc = (VarLocation) c.getP1();
        assembly.add("MOV %rax, " + "-"+loc.getDesc().getOffset()+"(%rbp)");         
    }
    
    public void add(TACCommand c){
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
            assembly.add("ADD $"+c.getP2().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");
        }
        if((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
            assembly.add("ADD $"+c.getP1().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)"); //guardo el resultado en el tercer parametro        
        }
        if((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("MOV $"+ c.getP2().toString()+", %rax"); //muevo un literal a un registro
            assembly.add("ADD $"+c.getP1().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc1.getDesc().getOffset()+"(%rbp)"+", %rax"); //muevo el primer operando al registro rax
            assembly.add("MOV "+ "-"+loc2.getDesc().getOffset()+"(%rbp)"+", %rdx"); //muevo el segundo operando al registro rdx
            assembly.add("ADD %rdx, %rax"); //sumo los dos registros
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }
    }
    
    public void sub(TACCommand c){
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
            assembly.add("SUB $"+c.getP2().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");
        }
        if((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rdx");
            assembly.add("MOV $"+ c.getP1().toString()+", %rax");
            assembly.add("SUB %rdx, %rax");   //al primero le resto el segundo
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)"); //guardo el resultado en el tercer parametro        
        }
        if((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("MOV $"+ c.getP1().toString()+", %rax"); //muevo un literal a un registro
            assembly.add("SUB $"+c.getP2().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc1.getDesc().getOffset()+"(%rbp)"+", %rax"); //muevo el primer operando al registro rax
            assembly.add("MOV "+ "-"+loc2.getDesc().getOffset()+"(%rbp)"+", %rdx"); //muevo el segundo operando al registro rdx
            assembly.add("SUB %rdx, %rax"); //resto los dos registros
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }
    }
    
    public void mul(TACCommand c){
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
            assembly.add("IMUL $"+c.getP2().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");
        }
        if((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
            assembly.add("IMUL $"+c.getP1().toString()+", %rax");   
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)"); //guardo el resultado en el tercer parametro        
        }
        if((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("MOV $"+ c.getP2().toString()+", %rax"); //muevo un literal a un registro
            assembly.add("IMUL $"+c.getP1().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc1.getDesc().getOffset()+"(%rbp)"+", %rax"); //muevo el primer operando al registro rax
            assembly.add("MOV "+ "-"+loc2.getDesc().getOffset()+"(%rbp)"+", %rdx"); //muevo el segundo operando al registro rdx
            assembly.add("IMUL %rdx, %rax"); //multiplico los dos registros
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }        
    }
    
    public void div(TACCommand c){
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rdx");
            assembly.add("IDIV $"+c.getP2().toString()); //rdx div divisor
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)"); //el cociente de la division queda en rax
        }
        if((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rcx");
            assembly.add("MOV $"+ c.getP1().toString()+", %rdx");
            assembly.add("IDIV %rcx");   //rdx div rcx
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");     
        }
        if((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("MOV $"+ c.getP1().toString()+", %rdx"); 
            assembly.add("IDIV $"+c.getP2().toString()); 
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc1.getDesc().getOffset()+"(%rbp)"+", %rdx"); //muevo el dividendo operando al registro rdx
            assembly.add("MOV "+ "-"+loc2.getDesc().getOffset()+"(%rbp)"+", %rcx"); //muevo el divisor operando al registro rcx
            assembly.add("IDIV %rcx"); 
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }        
    }
    
    public void and(TACCommand c){
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
            assembly.add("AND $"+c.getP2().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");
        }
        if((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
            assembly.add("AND $"+c.getP1().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)"); //guardo el resultado en el tercer parametro        
        }
        if((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("MOV $"+ c.getP2().toString()+", %rax"); //muevo un literal a un registro
            assembly.add("AND $"+c.getP1().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc1.getDesc().getOffset()+"(%rbp)"+", %rax"); //muevo el primer operando al registro rax
            assembly.add("MOV "+ "-"+loc2.getDesc().getOffset()+"(%rbp)"+", %rdx"); //muevo el segundo operando al registro rdx
            assembly.add("AND %rdx, %rax"); //sumo los dos registros
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }        
    }
    
    public void or(TACCommand c){
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
            assembly.add("OR $"+c.getP2().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");
        }
        if((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
            assembly.add("OR $"+c.getP1().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)"); //guardo el resultado en el tercer parametro        
        }
        if((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("MOV $"+ c.getP2().toString()+", %rax"); //muevo un literal a un registro
            assembly.add("OR $"+c.getP1().toString()+", %rax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc1.getDesc().getOffset()+"(%rbp)"+", %rax"); //muevo el primer operando al registro rax
            assembly.add("MOV "+ "-"+loc2.getDesc().getOffset()+"(%rbp)"+", %rdx"); //muevo el segundo operando al registro rdx
            assembly.add("OR %rdx, %rax"); //sumo los dos registros
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rax, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }               
    }
    
    public void mod(TACCommand c){
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rdx");
            assembly.add("IDIV $"+c.getP2().toString()); //rdx div divisor
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rdx, "+"-"+res.getDesc().getOffset()+"(%rbp)"); //el resto de la division queda en rdx
        }
        if((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rcx");
            assembly.add("MOV $"+ c.getP1().toString()+", %rdx");
            assembly.add("IDIV %rcx");   //rdx div rcx
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rdx, "+"-"+res.getDesc().getOffset()+"(%rbp)");     
        }
        if((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("MOV $"+ c.getP1().toString()+", %rdx"); 
            assembly.add("IDIV $"+c.getP2().toString()); 
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rdx, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }
        if((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("MOV "+ "-"+loc1.getDesc().getOffset()+"(%rbp)"+", %rdx"); //muevo el dividendo operando al registro rdx
            assembly.add("MOV "+ "-"+loc2.getDesc().getOffset()+"(%rbp)"+", %rcx"); //muevo el divisor operando al registro rcx
            assembly.add("IDIV %rcx"); 
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("MOV "+" %rdx, "+"-"+res.getDesc().getOffset()+"(%rbp)");          
        }                
    }
}
