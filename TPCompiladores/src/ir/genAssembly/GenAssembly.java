/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * 
 */
package ir.genAssembly;

import static ir.ast.BinOpType.EQEQ;
import static ir.ast.BinOpType.GT;
import static ir.ast.BinOpType.GTEQ;
import static ir.ast.BinOpType.LT;
import static ir.ast.BinOpType.LTEQ;
import static ir.ast.BinOpType.NOTEQ;
import ir.ast.Expression;
import ir.ast.Extern;
import ir.ast.FloatLiteral;
import ir.ast.Literal;
import ir.ast.MethodCall;
import ir.ast.VarLocation;
import ir.gencodint.Pair;
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
import java.util.Iterator;
import java.util.LinkedList;
import parser.parser;
import tabladesimbolos.Ambiente;
import tabladesimbolos.Descriptor;
import tabladesimbolos.DescriptorArreglo;

public class GenAssembly {

    private LinkedList<TACCommand> TACCode;
    LinkedList<String> assembly;
    parser p;
    private static int codFloat = 0; // esto es para los labels que vamos creando para cada valor float
    private LinkedList<Pair<Integer, Float>> listaFloats; //al final del programa declaramos todas las etiquetas con sus valores

    public GenAssembly(LinkedList l, parser par) {
        TACCode = l;
        assembly = new LinkedList();
        p = par;
        listaFloats = new LinkedList();
    }

    public LinkedList<String> genAssembly() {
        //Agrega al assembler las variables globales
        Ambiente a = p.getTds().getFirst();
        Iterator<Descriptor> it = a.values().iterator();
        while (it.hasNext()) {
            Descriptor d = it.next();
            if (d.getClase().equals("descriptorSimple")) {
                assembly.add("COMM " + d.getNombre() + ", 4, 4");
            }
            if (d.getClase().equals("descriptorArreglo")) {
                DescriptorArreglo ar = (DescriptorArreglo) d;
                assembly.add("COMM " + ar.getNombre() + ", " + ar.getLongitud() * 4 + ", 4");
            }
        }
        // fin de variables globales
        assembly.add("");
        assembly.add(".TEXT");
        assembly.add("");
        //  assembly.add("  .GLOBL main");
        // assembly.add(".TYPE main, @function");
        // assembly.add("");
        for (TACCommand c : TACCode) {
            switch (c.getOp()) {
                case STR:
                    str(c);
                    break;
                case ADD:
                    add(c);
                    break;
                case SUB:
                    sub(c);
                    break;
                case MUL:
                    mul(c);
                    break;
                case DIV:
                    div(c);
                    break;
                case AND:
                    and(c);
                    break; //terminar de hacer bien and y or
                case OR:
                    or(c);
                    break;
                case MOD:
                    mod(c);
                    break;
                case JMP:
                    assembly.add("  JMP " + c.getP1().toString());
                    break;
                case JG:
                    assembly.add("  JG " + c.getP1().toString());
                    break;
                case JL:
                    assembly.add("  JL " + c.getP1().toString());
                    break;
                case JGE:
                    assembly.add("  JGE " + c.getP1().toString());
                    break;
                case JLE:
                    assembly.add("  JLE " + c.getP1().toString());
                    break;
                case JE:
                    assembly.add("  JE " + c.getP1().toString());
                    break;
                case JNE:
                    assembly.add("  JNE " + c.getP1().toString());
                    break;
                case JAND:
                    jmp(c);
                    break; //VER SI ESTO ES CORRECTO
                case JOR:
                    jmp(c);
                    break;
                case JNOT:
                    jmp(c);
                    break;
                case LBL:
                    label(c);
                    break;
                case OPP:
                    opp(c);
                    break;
                case NOT:
                    not(c);
                    break; // no me cierra mucho este
                case CMP:
                    cmp(c);
                    break;
                case EXCALL:
                    excall(c);
                    break;
                case CALL:
                    call(c);
                    break;
                case RET:
                    ret(c);
                    break;
                case MNAME:
                    mname(c);
                    break;
            }

        }
        //ALAN
        assembly.add("  LEAVE");//HAY QYE VER COSITAS
        assembly.add("  RET");
        //ALAN
        //LUCHO
        for (Pair<Integer, Float> p : listaFloats) {
            assembly.add(".LC" + p.fst().toString() + ":");
            assembly.add("  .float " + p.snd().toString());
        }
        //LUCHO
        return assembly;
    }

    public void excall(TACCommand c) {
        Extern e = (Extern) c.getP1();
        assembly.add("  CALL " + e.getString());
        if (c.getP2() != null) {
            VarLocation res = (VarLocation) c.getP2();
            assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
        }
    }

    public void call(TACCommand c) {
        MethodCall e = (MethodCall) c.getP1();
        int i = 0;
        for (Expression ex : e.getExpressions()) {
            if(ex instanceof VarLocation){
                VarLocation param = (VarLocation) ex;
                // movl	-4(%ebp), %eax ;K
                // movl	%eax, (%esp) ;
                Ambiente a = p.getTds().getFirst();
                if (a.get(param.getDesc().getNombre()) != null) {
                    assembly.add("  MOVL " + param.getDesc().getNombre() + ", %eax");
                    assembly.add("  MOVL %eax, " + i + "(%esp)");
                } else {
                    assembly.add("  MOVL -" + param.getDesc().getOffset() + "(%ebp), %eax");
                    assembly.add("  MOVL %eax, " + i + "(%esp)");

                }
            }
            else{
                //El lenguaje admite solo variables simples como parametro
            }
            i = i + 4;
        }
        assembly.add("  CALL " + e.getId());
        if (c.getP2() != null) {
            VarLocation res = (VarLocation) c.getP2();
            assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
        }
    }

    public void ret(TACCommand c) {
        if(c.getP1() != null){
            if(c.getP1() instanceof VarLocation){
                VarLocation v = (VarLocation) c.getP1();
                assembly.add("  MOVL " + v.getDesc().getNombre() + ", %eax");
            }else{
                assembly.add("  MOVL " + c.getP1().toString() + ", %eax");
            }
            
        }
        assembly.add("  LEAVE");
        assembly.add("  RET");
        assembly.add("");
    }

    public void cmp(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            if (c.getP2() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre() + "(%ebp)");
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FUCOMPP");
                assembly.add("  FNSTSW %ax");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
                assembly.add("  CMP $" + c.getP2().toString() + ", %eax");
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            if (c.getP1() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre() + "(%ebp)");
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FUCOMPP");
                assembly.add("  FNSTSW %ax");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
                assembly.add("  CMP $" + c.getP1().toString() + ", %eax");
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FUCOMPP");
                assembly.add("  FNSTSW %ax");
            } else {
                assembly.add("  MOVL $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
                assembly.add("  CMP $" + c.getP1().toString() + ", %eax");
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            if (loc.getDesc().getTipo().isFloat()) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre() + "(%ebp)");
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                if (isGlobal(loc2.getDesc())) {
                    assembly.add("  FLDS " + loc2.getDesc().getNombre() + "(%ebp)");
                } else {
                    assembly.add("  FLDS " + loc2.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FUCOMPP");
                assembly.add("  FNSTSW %ax");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
                if (isGlobal(loc2.getDesc())) {
                    assembly.add("  MOVL " + loc2.getDesc().getNombre() + "(%ebp)" + ", %ebx");
                } else {
                    assembly.add("  MOVL " + loc2.getDesc().getOffset() + "(%ebp)" + ", %ebx"); //muevo el segundo operando al registro edx

                }
                //muevo el primer operando al registro eax
                assembly.add("  CMP  %ebx, %eax"); //sumo los dos registros
            }
        }
        VarLocation res = (VarLocation) c.getP3();
        switch (res.getDesc().getOp()) {
            case NOTEQ: {
                assembly.add("  ANDB $68,%ah");
                assembly.add("  XORB $64,%ah");
                assembly.add("  JNE SHORT ok");
            }
            break;
            case EQEQ: {
                assembly.add("  ANDB $69,%ah");
                assembly.add("  CMPB $64,%ah");
                assembly.add("  JE SHORT ok");
            }
            break;
            case GTEQ: {
                assembly.add("  ANDB $5,%ah");
                assembly.add("  JGE SHORT ok");
            }
            break;
            case LTEQ: {
                assembly.add("  ANDB $69,%ah");
                assembly.add("  CMPB $64,%ah");
                assembly.add("  JLE SHORT ok");
            }
            break;
            case GT: {
                assembly.add("  ANDB $69,%ah");
                assembly.add("  JG SHORT ok");
            }
            break;
            case LT: {
                assembly.add("  ANDB $69,%ah");
                assembly.add("  CMPB $1,%ah");
                assembly.add("  JL SHORT ok");
            }
            break;
        }
        assembly.add("  MOVL $0, %eax");
        assembly.add("ok:");
        assembly.add("  MOVL $1, %eax");
        assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
    }

    public void opp(TACCommand c) {
        if (c.getP1() instanceof VarLocation) {
            VarLocation loc = (VarLocation) c.getP1();
            if (loc.getDesc().getTipo().isFloat()) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FCHS ");
                VarLocation res = (VarLocation) c.getP2();
                assembly.add("  FSTPS "  + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }

                assembly.add("  NOT  %eax");
                VarLocation res = (VarLocation) c.getP2();
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        } else {
            if (c.getP1() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f1.getValue()));
                assembly.add("  FCHS ");
                VarLocation res = (VarLocation) c.getP2();
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                assembly.add("  MOVL " + c.getP1().toString() + ", %eax");
                assembly.add("  NOT  %eax");
                VarLocation res = (VarLocation) c.getP2();
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        }
    }

    public void not(TACCommand c) { 
        if (c.getP1() instanceof VarLocation) {
            VarLocation loc = (VarLocation) c.getP1();
            if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
            assembly.add("  CMP %eax, $1");
            assembly.add("  JE SHORT isTrue");
            assembly.add("  MOVL $1, %eax");
            assembly.add("isTrue:");
            assembly.add("  MOVL $0, %eax");
            VarLocation res = (VarLocation) c.getP2();
            assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
        } else {
            assembly.add("  MOVL " + c.getP1().toString() + ", %eax");
            assembly.add("  CMP %eax, $1");
            assembly.add("  JE SHORT isTrue");
            assembly.add("  MOVL $1, %eax");
            assembly.add("isTrue:");
            assembly.add("  MOVL $0, %eax");
            VarLocation res = (VarLocation) c.getP2();
            assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
        }
    }

    public void label(TACCommand c) {
        assembly.add(c.getP1().toString() + ":");
    }

    public void mname(TACCommand c) {
        assembly.add("  .GLOBL " + c.getP1().toString());
        assembly.add("  TYPE " + c.getP1().toString() + ", @function");
        assembly.add(c.getP1().toString() + ":");
        assembly.add("  PUSHL %ebp");
        assembly.add("  MOVL %ebp, %esp");
        assembly.add("  SUBL $" + Descriptor.getOffsetCorriente() + "%ebp");
    }

    public void jmp(TACCommand c) {
        Expression e = c.getP2();
        if (e instanceof VarLocation) {
            VarLocation loc = (VarLocation) e;
            assembly.add("  MOVL "  + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
        } else {
            if (e instanceof Literal) {
                assembly.add("   MOVL $" + e.toString() + ", %eax");
            }

        }
        assembly.add("  CMP %eax, $1");
        assembly.add("  JE " + c.getP1().toString());
    }

    public void str(TACCommand c) {
        VarLocation res = (VarLocation) c.getP1();
        if ((c.getP2() instanceof VarLocation)) { //copiar alan en este if
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
            assembly.add("  MOVL %eax, " +  res.getDesc().getOffset() + "(%ebp)");
        } else {
            if (c.getP2() instanceof FloatLiteral) {
                assembly.add("  MOVL .LC" + codFloat++ + ", %eax");
                FloatLiteral f1 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat, f1.getValue()));
                if (isGlobal(res.getDesc())) {
                    assembly.add("  MOVL %eax, " + res.getDesc().getNombre());
                } else {
                    assembly.add("  MOVL %eax, " + res.getDesc().getOffset() + "(%ebp)");
                }
            } else {
                assembly.add("  MOVL $" + c.getP2().toString() + ", %eax");
                if (isGlobal(res.getDesc())) {
                    assembly.add("  MOVL %eax, " + res.getDesc().getNombre());
                } else {
                    assembly.add("  MOVL %eax, " + res.getDesc().getOffset() + "(%ebp)");
                }
            }
        }           
    }

    public void add(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP2() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FADDP %st, %st(1)");
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
                assembly.add("  ADDL $" + c.getP2().toString() + ", %eax");
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP1() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FADDP %st, %st(1)");
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
                assembly.add("  ADDL $" + c.getP1().toString() + ", %eax");
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)"); //guardo el resultado en el tercer parametro 
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FADDP %st, %st(1)");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                assembly.add("  MOVL $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
                assembly.add("  ADDL $" + c.getP1().toString() + ", %eax");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (loc.getDesc().getTipo().isFloat()) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                if (isGlobal(loc2.getDesc())) {
                    assembly.add("  FLDS " + loc2.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc2.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FADDP %st, %st(1)");               
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %eax"); //muevo el primer operando al registro eax
                } else {
                    assembly.add("  MOVL "+ loc.getDesc().getOffset() + "(%ebp)" + ", %eax"); //muevo el primer operando al registro eax
                }
                if (isGlobal(loc2.getDesc())) {
                    assembly.add("  MOVL " + loc2.getDesc().getNombre() + "(%ebp)" + ", %edx"); //muevo el segundo operando al registro edx
                } else {
                    assembly.add("  MOVL " + loc2.getDesc().getOffset() + "(%ebp)" + ", %edx"); //muevo el segundo operando al registro edx
                }
                assembly.add("  ADDL %edx, %eax"); //sumo los dos registros
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        }
    }

    public void sub(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP2() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FSUBP %st, %st(1)");
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
                assembly.add("  SUBL $" + c.getP2().toString() + ", %eax");
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP1() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FSUBP %st, %st(1)");
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
                assembly.add("  SUBL $" + c.getP1().toString() + ", %eax");
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)"); //guardo el resultado en el tercer parametro 
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FSUBP %st, %st(1)");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                assembly.add("  MOVL $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
                assembly.add("  SUBL $" + c.getP1().toString() + ", %eax");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)");
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (loc.getDesc().getTipo().isFloat()) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                if (isGlobal(loc2.getDesc())) {
                    assembly.add("  FLDS " + loc2.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc2.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FSUBP %st, %st(1)");               
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %eax"); //muevo el primer operando al registro eax
                } else {
                    assembly.add("  MOVL "+ loc.getDesc().getOffset() + "(%ebp)" + ", %eax"); //muevo el primer operando al registro eax
                }
                if (isGlobal(loc2.getDesc())) {
                    assembly.add("  MOVL " + loc2.getDesc().getNombre() + "(%ebp)" + ", %edx"); //muevo el segundo operando al registro edx
                } else {
                    assembly.add("  MOVL " + loc2.getDesc().getOffset() + "(%ebp)" + ", %edx"); //muevo el segundo operando al registro edx
                }
                assembly.add("  SUBL %edx, %eax"); //sumo los dos registros
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        }
    }

    public void mul(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP2() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FMULP %st, %st(1)");
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
                assembly.add("  IMUL $" + c.getP2().toString() + ", %eax");
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP1() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FMULP %st, %st(1)");
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + ", %eax");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
                }
                assembly.add("  IMUL $" + c.getP1().toString() + ", %eax");
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)"); //guardo el resultado en el tercer parametro 
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FMULP %st, %st(1)");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                assembly.add("  MOVL $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
                assembly.add("  IMUL $" + c.getP1().toString() + ", %eax");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)");
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (loc.getDesc().getTipo().isFloat()) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                if (isGlobal(loc2.getDesc())) {
                    assembly.add("  FLDS " + loc2.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc2.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FMULP %st, %st(1)");               
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %eax"); //muevo el primer operando al registro eax
                } else {
                    assembly.add("  MOVL "+ loc.getDesc().getOffset() + "(%ebp)" + ", %eax"); //muevo el primer operando al registro eax
                }
                if (isGlobal(loc2.getDesc())) {
                    assembly.add("  MOVL " + loc2.getDesc().getNombre() + "(%ebp)" + ", %edx"); //muevo el segundo operando al registro edx
                } else {
                    assembly.add("  MOVL " + loc2.getDesc().getOffset() + "(%ebp)" + ", %edx"); //muevo el segundo operando al registro edx
                }
                assembly.add("  IMUL %edx, %eax"); //sumo los dos registros
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        }
    }

    public void div(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP2() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre());
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }               
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FDIVP %st, %st(1)");
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %edx");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %edx");
                }
                assembly.add("  IDIV $" + c.getP2().toString()); //edx div divisor
                assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)"); //el cociente de la division queda en eax
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP1() instanceof FloatLiteral) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre() + "(%ebp)");
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }               
                assembly.add("  FLDS .LC" + codFloat++);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FDIVP %st, %st(1)");
                assembly.add("  FSTPS "  + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %ecx");
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %ecx");
                }  
                assembly.add("  MOVL $" + c.getP1().toString() + ", %edx");
                assembly.add("  IDIV %ecx");   //edx div ecx
                assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)");
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  FLDS .LC" + codFloat++);
                listaFloats.add(new Pair(codFloat, f2.getValue()));
                assembly.add("  FDIVP %st, %st(1)");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                assembly.add("  MOVL $" + c.getP1().toString() + ", %edx");
                assembly.add("  IDIV $" + c.getP2().toString());
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();            
            if (loc.getDesc().getTipo().isFloat()) {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc.getDesc().getNombre() + "(%ebp)");
                } else {
                    assembly.add("  FLDS " + loc.getDesc().getOffset() + "(%ebp)");
                }
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  FLDS " + loc2.getDesc().getNombre() + "(%ebp)");
                } else {
                    assembly.add("  FLDS " + loc2.getDesc().getOffset() + "(%ebp)");
                }
                assembly.add("  FDIVP %st, %st(1)");
                assembly.add("  FSTPS " + res.getDesc().getOffset() + "(%ebp)");
            } else {
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %edx"); //muevo el dividendo operando al registro edx
                } else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %edx"); //muevo el dividendo operando al registro edx
                }
                if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc2.getDesc().getNombre() + "(%ebp)" + ", %ecx"); //muevo el dividendo operando al registro edx
                } else {
                    assembly.add("  MOVL " + loc2.getDesc().getOffset() + "(%ebp)" + ", %ecx"); //muevo el dividendo operando al registro edx
                }
                assembly.add("  IDIV %ecx");
                assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)");
            }
        }
    }

    public void and(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %eax"); 
            } 
            else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
            }
            assembly.add("  AND $" + c.getP2().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)");
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %eax"); 
            } 
            else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
            }
            assembly.add("  AND $" + c.getP1().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)"); //guardo el resultado en el tercer parametro        
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("  MOVL $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
            assembly.add("  AND $" + c.getP1().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)");
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            if (isGlobal(loc1.getDesc())) {
                    assembly.add("  MOVL " + loc1.getDesc().getNombre() + "(%ebp)" + ", %eax"); 
            } 
            else {
                    assembly.add("  MOVL " + loc1.getDesc().getOffset() + "(%ebp)" + ", %eax");
            }
            if (isGlobal(loc2.getDesc())) {
                    assembly.add("  MOVL " + loc2.getDesc().getNombre() + "(%ebp)" + ", %edx"); 
            } 
            else {
                    assembly.add("  MOVL " + loc2.getDesc().getOffset() + "(%ebp)" + ", %edx");
            }
            assembly.add("  AND %edx, %eax"); //sumo los dos registros
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
        }
    }

    public void or(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
            assembly.add("  OR $" + c.getP2().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)");
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %eax");
            assembly.add("  OR $" + c.getP1().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)"); //guardo el resultado en el tercer parametro        
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("  MOVL $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
            assembly.add("  OR $" + c.getP1().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)");
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("  MOVL "  + loc1.getDesc().getOffset() + "(%ebp)" + ", %eax"); //muevo el primer operando al registro eax
            assembly.add("  MOVL " +  loc2.getDesc().getOffset() + "(%ebp)" + ", %edx"); //muevo el segundo operando al registro edx
            assembly.add("  OR %edx, %eax"); //sumo los dos registros
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %eax, "  + res.getDesc().getOffset() + "(%ebp)");
        }
    }

    public void mod(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %edx"); //muevo el dividendo operando al registro edx
            } 
            else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %edx"); //muevo el dividendo operando al registro edx
            }
            assembly.add("  IDIV $" + c.getP2().toString()); //edx div divisor
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %edx, "  + res.getDesc().getOffset() + "(%ebp)"); //el resto de la division queda en edx
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %ecx"); //muevo el dividendo operando al registro edx
            } 
            else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %ecx"); //muevo el dividendo operando al registro edx
            }
            assembly.add("  MOVL $" + c.getP1().toString() + ", %edx");
            assembly.add("  IDIV %ecx");   //edx div ecx
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %edx, "  + res.getDesc().getOffset() + "(%ebp)");
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("  MOVL $" + c.getP1().toString() + ", %edx");
            assembly.add("  IDIV $" + c.getP2().toString());
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %edx, "  + res.getDesc().getOffset() + "(%ebp)");
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            if (isGlobal(loc.getDesc())) {
                    assembly.add("  MOVL " + loc.getDesc().getNombre() + "(%ebp)" + ", %edx"); //muevo el dividendo operando al registro edx
            } 
            else {
                    assembly.add("  MOVL " + loc.getDesc().getOffset() + "(%ebp)" + ", %edx"); //muevo el dividendo operando al registro edx
            }
            if (isGlobal(loc2.getDesc())) {
                    assembly.add("  MOVL " + loc2.getDesc().getNombre() + "(%ebp)" + ", %ecx"); //muevo el dividendo operando al registro edx
            } 
            else {
                    assembly.add("  MOVL " + loc2.getDesc().getOffset() + "(%ebp)" + ", %ecx"); //muevo el dividendo operando al registro edx
            }
            assembly.add("  IDIV %ecx");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  MOVL " + " %edx, "  + res.getDesc().getOffset() + "(%ebp)");
        }
    }

    private boolean isGlobal(Descriptor desc) {
        return (desc.EsGlobal());
    }
}
