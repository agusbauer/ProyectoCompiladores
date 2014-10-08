/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.genAssembly;

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

/**
 *
 * @author luciano
 */
public class GenAssembly {
    
    private LinkedList<TACCommand> TACCode;
    
    public GenAssembly(LinkedList l){
        TACCode = l;
    }
    public LinkedList<String> genAssembly(){
        LinkedList<String> assembly = new LinkedList();
        for (TACCommand c : TACCode){
            switch (c.getOp()) {
                case STR : {
                    assembly.add("MOV $"+c.getP2().toString()+", %rax");
                    VarLocation loc = (VarLocation) c.getP1();
                    assembly.add("MOV %rax, " + "-"+loc.getDesc().getOffset()+"(%rbp)");        
                }
                case ADD : {
                    VarLocation loc = (VarLocation) c.getP1();
                    assembly.add("MOV "+ "-"+loc.getDesc().getOffset()+"(%rbp)"+", %rax");
                    assembly.add("ADD $"+c.getP2().toString()+", %rax");
                    assembly.add("MOV "+" %rax, "+"-"+loc.getDesc().getOffset()+"(%rbp)");
                }//  add $1, %r10
                case SUB :{
                    
                }
                case MUL :    
                case DIV :
                case AND :
                case OR :
                case MOD :
                case JMP :
                case JG :
                case JL :
                case JGE :
                case JLE :
                case JE :
                case JNE :
                case JAND :
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
    
}
