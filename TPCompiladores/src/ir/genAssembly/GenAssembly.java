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
import ir.ast.IntLiteral;
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
import tabladesimbolos.DescriptorSimple;

public class GenAssembly {

    private LinkedList<TACCommand> TACCode;
    LinkedList<String> assembly;
    parser p;
    private boolean eaxLibre = true; //no se si usar esto todavia, es fuerte
    private static int codFloat = 0; // esto es para los labels que vamos creando para cada valor float
    private LinkedList<Pair<Integer, Float>> listaFloats; //al final del programa declaramos todas las etiquetas con sus valores
    private int cantMetodos;

    public GenAssembly(LinkedList l, parser par, int cantMetodos) {
        TACCode = l;
        assembly = new LinkedList();
        p = par;
        listaFloats = new LinkedList();
        this.cantMetodos = cantMetodos;
    }

    
    public LinkedList<String> genAssembly() {
        //Agrega al assembler las variables globales
        Ambiente a = p.getTds().getFirst();
        Iterator<Descriptor> it = a.values().iterator();
        while (it.hasNext()) {
            Descriptor d = it.next();
            if (d.getClase().equals("descriptorSimple")) {
                assembly.add("  .comm " + d.getNombre() + ", 4, 4");
            }
            if (d.getClase().equals("descriptorArreglo")) {
                DescriptorArreglo ar = (DescriptorArreglo) d;
                assembly.add("  .comm " + ar.getNombre() + ", " + ar.getLongitud() * 4 + ", 4");
            }
        }
        // fin de variables globales
        assembly.add("");
        assembly.add("  .text");
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
                    assembly.add("  jmp " + c.getP1().toString());
                    break;
                case JG:
                    assembly.add("  jg " + c.getP1().toString());
                    break;
                case JL:
                    assembly.add("  jl " + c.getP1().toString());
                    break;
                case JGE:
                    assembly.add("  jge " + c.getP1().toString());
                    break;
                case JLE:
                    assembly.add("  jle " + c.getP1().toString());
                    break;
                case JE:
                    assembly.add("  je " + c.getP1().toString());
                    break;
                case JNE:
                    assembly.add("  jne " + c.getP1().toString());
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
        assembly.add("  leave");//HAY QYE VER COSITAS
        assembly.add("  ret");
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
        assembly.add("  call " + e.getString());
        if (c.getP2() != null) {
            VarLocation res = (VarLocation) c.getP2();
            assembly.add("  movl " + " %eax, " + offset(res));
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
                    assembly.add("  movl " + param.getDesc().getNombre() + ", %eax");
                    assembly.add("  movl %eax, " + i + "(%esp)");
                } else {
                    assembly.add("  movl -" + param.getDesc().getOffset() + "(%ebp), %eax");
                    assembly.add("  movl %eax, " + i + "(%esp)");

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
            assembly.add("  movl " + " %eax, " +offset(res));
        }
    }

    public void ret(TACCommand c) {
        if(c.getP1() != null){
            if(c.getP1() instanceof VarLocation){
                VarLocation v = (VarLocation) c.getP1();
                assembly.add("  movl " + offset(v) + ", %eax");
            }else{
                assembly.add("  movl " + c.getP1().toString() + ", %eax");
            }
            
        }
        assembly.add("  leave");
        assembly.add("  ret");
        assembly.add("");
    }

    public void cmp(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            if (c.getP2() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fucompp");
                assembly.add("  fnstsw %ax");
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  cmp $" + c.getP2().toString() + ", %eax");
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            if (c.getP1() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fucompp");
                assembly.add("  fnstsw %ax");
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  cmp $" + c.getP1().toString() + ", %eax");
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fucompp");
                assembly.add("  fnstsw %ax");
            } else {
                assembly.add("  movl $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
                assembly.add("  cmp $" + c.getP1().toString() + ", %eax");
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            if (loc.getDesc().getTipo().isFloat()) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds " + offset(loc2));
                assembly.add("  fucompp");
                assembly.add("  fnstsw %ax");
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  movl " + offset(loc2) + ", %ebx");
                //muevo el primer operando al registro eax
                assembly.add("  cmp  %ebx, %eax"); //sumo los dos registros
            }
        }
        VarLocation res = (VarLocation) c.getP3();
        switch (res.getDesc().getOp()) {
            case NOTEQ: {
                if (res.getDesc().getTipo().isFloat()){
                    assembly.add("  andb $68,%ah");
                    assembly.add("  xorb $64,%ah");
                }
                assembly.add("  jne short ok");
            }
            break;
            case EQEQ: {
                if (res.getDesc().getTipo().isFloat()){
                    assembly.add("  andb $69,%ah");
                    assembly.add("  cmpb $64,%ah");
                }
                assembly.add("  je short ok");
            }
            break;
            case GTEQ: {
                if (res.getDesc().getTipo().isFloat()){
                    assembly.add("  andb $5,%ah");
                }
                assembly.add("  jge short ok");
            }
            break;
            case LTEQ: {
                if (res.getDesc().getTipo().isFloat()){
                    assembly.add("  andb $69,%ah");
                    assembly.add("  cmpb $64,%ah");
                }
                assembly.add("  jle short ok");
            }
            break;
            case GT: {
                if (res.getDesc().getTipo().isFloat()){
                    assembly.add("  andb $69,%ah");
                }
                assembly.add("  jg short ok");
            }
            break;
            case LT: {
                if (res.getDesc().getTipo().isFloat()){
                    assembly.add("  andb $69,%ah");
                    assembly.add("  cmpb $1,%ah");
                }
                assembly.add("  jl short ok");
            }
            break;
        }
        assembly.add("  movl $0, %eax");
        assembly.add("ok:");
        assembly.add("  movl $1, %eax");
        assembly.add("  movl " + " %eax, " + res.getDesc().getOffset() + "(%ebp)");
    }

    public void opp(TACCommand c) {
        if (c.getP1() instanceof VarLocation) {
            VarLocation loc = (VarLocation) c.getP1();
            if (loc.getDesc().getTipo().isFloat()) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  fchs ");
                VarLocation res = (VarLocation) c.getP2();
                assembly.add("  fstps "  + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  not  %eax");
                VarLocation res = (VarLocation) c.getP2();
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        } else {
            if (c.getP1() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f1.getValue()));
                assembly.add("  fchs ");
                VarLocation res = (VarLocation) c.getP2();
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + c.getP1().toString() + ", %eax");
                assembly.add("  not  %eax");
                VarLocation res = (VarLocation) c.getP2();
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
    }

    public void not(TACCommand c) { 
        if (c.getP1() instanceof VarLocation) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("  movl " + offset(loc) + ", %eax");
        } else {
            assembly.add("  movl " + c.getP1().toString() + ", %eax");
        }
        assembly.add("  cmp %eax, $1");
        assembly.add("  je short isTrue");
        assembly.add("  movl $1, %eax");
        assembly.add("isTrue:");
        assembly.add("  movl $0, %eax");
        VarLocation res = (VarLocation) c.getP2();
        assembly.add("  movl " + " %eax, " + offset(res));
    }

    public void label(TACCommand c) {
        assembly.add(c.getP1().toString() + ":");
    }

    public void mname(TACCommand c) {
        IntLiteral i = (IntLiteral) c.getP1();
        assembly.add("  .globl " + c.getP1().toString());
        assembly.add("  .type " + c.getP1().toString() + ", @function");
        assembly.add(c.getP1().toString() + ":");
        assembly.add("  pushl %ebp");
        assembly.add("  movl %esp, %ebp");
        if (cantMetodos>1)
            assembly.add("  subl $" + -i.getAuxValue()+ ",%esp");
        else
            assembly.add("  subl $" + -Descriptor.getOffsetCorriente()+ ",%esp");
    }

    public void jmp(TACCommand c) {
        Expression e = c.getP2();
        if (e instanceof VarLocation) {
            VarLocation loc = (VarLocation) e;
            assembly.add("  movl "  + offset(loc) + ", %eax");
        } else {
            if (e instanceof Literal) {
                assembly.add("   movl $" + e.toString() + ", %eax");
            }

        }
        assembly.add("  cmp %eax, $1");
        assembly.add("  je " + c.getP1().toString());
    }

    public void str(TACCommand c) {
        VarLocation res = (VarLocation) c.getP1();
        String off = offset(res);
        if ((c.getP2() instanceof VarLocation)) { //copiar alan en este if
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("  movl "+ offset(loc)+", %eax");                      
            assembly.add("  movl %eax, " + off);            
        } else {
            if (c.getP2() instanceof FloatLiteral) {
                assembly.add("  movl .LC" + (codFloat) + ", %eax");
                FloatLiteral f1 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat++, f1.getValue()));
                assembly.add("  movl %eax, " + off);
            } else {
                assembly.add("  movl $" + c.getP2().toString() + ","+off);
            }
        }           
    }

    public void add(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP2() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  faddp %st, %st(1)");
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  addl $" + c.getP2().toString() + ", %eax");
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP1() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  faddp %st, %st(1)");
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  addl $" + c.getP1().toString() + ", %eax");
                assembly.add("  movl " + " %eax, " + offset(res)); //guardo el resultado en el tercer parametro 
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  faddp %st, %st(1)");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
                assembly.add("  addl $" + c.getP1().toString() + ", %eax");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (loc.getDesc().getTipo().isFloat()) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds " + offset(loc2));
                assembly.add("  faddp %st, %st(1)");               
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax"); //muevo el primer operando al registro eax            
                assembly.add("  movl " + offset(loc2) + ", %edx"); //muevo el segundo operando al registro edx              
                assembly.add("  addl %edx, %eax"); //sumo los dos registros
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
    }

    public void sub(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP2() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fsubp %st, %st(1)");
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  subl $" + c.getP2().toString() + ", %eax");
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP1() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fsubp %st, %st(1)");
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  subl $" + c.getP1().toString() + ", %eax");
                assembly.add("  movl " + " %eax, " + offset(res)); //guardo el resultado en el tercer parametro 
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fsubp %st, %st(1)");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
                assembly.add("  subl $" + c.getP1().toString() + ", %eax");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (loc.getDesc().getTipo().isFloat()) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds " + offset(loc2));
                assembly.add("  fsubp %st, %st(1)");               
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax"); //muevo el primer operando al registro eax            
                assembly.add("  movl " + offset(loc2) + ", %edx"); //muevo el segundo operando al registro edx              
                assembly.add("  subl %edx, %eax"); //sumo los dos registros
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
    }

    public void mul(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP2() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fmulp %st, %st(1)");
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  imul $" + c.getP2().toString() + ", %eax");
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP1() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fmulp %st, %st(1)");
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax");
                assembly.add("  imul $" + c.getP1().toString() + ", %eax");
                assembly.add("  movl " + " %eax, " + offset(res)); //guardo el resultado en el tercer parametro 
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fmulp %st, %st(1)");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
                assembly.add("  imul $" + c.getP1().toString() + ", %eax");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (loc.getDesc().getTipo().isFloat()) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds " + offset(loc2));
                assembly.add("  fmulp %st, %st(1)");               
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %eax"); //muevo el primer operando al registro eax            
                assembly.add("  movl " + offset(loc2) + ", %edx"); //muevo el segundo operando al registro edx              
                assembly.add("  imul %edx, %eax"); //sumo los dos registros
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
    }

    public void div(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP2() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));              
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fdivp %st, %st(1)");
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %edx");
                assembly.add("  idiv $" + c.getP2().toString()); //edx div divisor
                assembly.add("  movl " + " %eax, "  + offset(res)); //el cociente de la division queda en eax
            }
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();
            if (c.getP1() instanceof FloatLiteral) {
                assembly.add("  flds " + offset(loc));              
                assembly.add("  flds .LC" + codFloat);
                FloatLiteral f2 = (FloatLiteral) c.getP1();
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fdivp %st, %st(1)");
                assembly.add("  fstps "  + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %ecx");
                assembly.add("  movl $" + c.getP1().toString() + ", %edx");
                assembly.add("  idiv %ecx");   //edx div ecx
                assembly.add("  movl " + " %eax, "  + offset(res));
            }
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            if (c.getP2() instanceof FloatLiteral) {
                FloatLiteral f1 = (FloatLiteral) c.getP1();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f1.getValue()));
                FloatLiteral f2 = (FloatLiteral) c.getP2();
                assembly.add("  flds .LC" + codFloat);
                listaFloats.add(new Pair(codFloat++, f2.getValue()));
                assembly.add("  fdivp %st, %st(1)");
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl $" + c.getP1().toString() + ", %edx");
                assembly.add("  idiv $" + c.getP2().toString());
                VarLocation res = (VarLocation) c.getP3();
                assembly.add("  movl " + " %eax, " + offset(res));
            }
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            VarLocation res = (VarLocation) c.getP3();            
            if (loc.getDesc().getTipo().isFloat()) {
                assembly.add("  flds " + offset(loc));
                assembly.add("  flds " + offset(loc2));
                assembly.add("  fdivp %st, %st(1)");
                assembly.add("  fstps " + offset(res));
            } else {
                assembly.add("  movl " + offset(loc) + ", %edx"); //muevo el dividendo operando al registro edx
                assembly.add("  movl " + offset(loc2) + ", %ecx"); //muevo el dividendo operando al registro edx
                assembly.add("  idiv %ecx");
                assembly.add("  movl " + " %eax, "  + offset(res));
            }
        }
    }

    public void and(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("  movl " + offset(loc) + ", %eax"); 
            assembly.add("  and $" + c.getP2().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %eax, "  + offset(res));
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("  movl " + offset(loc) + ", %eax"); 
            assembly.add("  and $" + c.getP1().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %eax, "  + offset(res)); //guardo el resultado en el tercer parametro        
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("  movl $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
            assembly.add("  and $" + c.getP1().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %eax, "  + offset(res));
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("  movl " + offset(loc1) + ", %eax"); 
            assembly.add("  movl " + offset(loc2) + ", %edx"); 
            assembly.add("  and %edx, %eax"); //sumo los dos registros
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %eax, " + offset(res));
        }
    }

    public void or(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("  movl " + offset(loc) + ", %eax");
            assembly.add("  or $" + c.getP2().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %eax, "  + offset(res));
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("  movl " + offset(loc) + ", %eax");
            assembly.add("  or $" + c.getP1().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %eax, "  + offset(res)); //guardo el resultado en el tercer parametro        
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("  movl $" + c.getP2().toString() + ", %eax"); //muevo un literal a un registro
            assembly.add("  or $" + c.getP1().toString() + ", %eax");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %eax, "  + offset(res));
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc1 = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("  movl "  + offset(loc1) + ", %eax"); //muevo el primer operando al registro eax
            assembly.add("  movl " +  offset(loc2) + ", %edx"); //muevo el segundo operando al registro edx
            assembly.add("  or %edx, %eax"); //sumo los dos registros
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %eax, "  + offset(res));
        }
    }

    public void mod(TACCommand c) {
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP1();
            assembly.add("  movl " + offset(loc) + ", %edx"); //muevo el dividendo operando al registro edx
            assembly.add("  idiv $" + c.getP2().toString()); //edx div divisor
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %edx, "  + offset(res)); //el resto de la division queda en edx
        }
        if ((c.getP2() instanceof VarLocation) && (c.getP1() instanceof Literal)) {
            VarLocation loc = (VarLocation) c.getP2();
            assembly.add("  movl " + offset(loc) + ", %ecx"); //muevo el dividendo operando al registro edx
            assembly.add("  movl $" + c.getP1().toString() + ", %edx");
            assembly.add("  idiv %ecx");   //edx div ecx
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %edx, "  + offset(res));
        }
        if ((c.getP1() instanceof Literal) && (c.getP2() instanceof Literal)) {
            assembly.add("  movl $" + c.getP1().toString() + ", %edx");
            assembly.add("  idiv $" + c.getP2().toString());
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %edx, "  + offset(res));
        }
        if ((c.getP1() instanceof VarLocation) && (c.getP2() instanceof VarLocation)) {
            VarLocation loc = (VarLocation) c.getP1();
            VarLocation loc2 = (VarLocation) c.getP2();
            assembly.add("  movl " + offset(loc) + ", %edx"); //muevo el dividendo operando al registro edx
            assembly.add("  movl " + offset(loc2) + ", %ecx"); //muevo el dividendo operando al registro edx
            assembly.add("  idiv %ecx");
            VarLocation res = (VarLocation) c.getP3();
            assembly.add("  movl " + " %edx, "  + offset(res));
        }
    }

    private boolean isGlobal(Descriptor desc) {
        return desc.isGlob();
    }
    private String offset (VarLocation v){     
        if (v.getDesc() instanceof DescriptorSimple){
            DescriptorSimple d = (DescriptorSimple)v.getDesc();
            if (isGlobal(d)){
                return d.getNombre();
            }
            else{
                return d.getOffset()+"(%ebp)";
            }           
        }
        if (v.getDesc() instanceof DescriptorArreglo){
            DescriptorArreglo d = (DescriptorArreglo)v.getDesc();
            Expression index = v.getIndice();            
            if (index instanceof IntLiteral){
                IntLiteral i = (IntLiteral)index;
                assembly.add("  movl "  + i.getValue() + ", %edx");
            }
            else{
                VarLocation i = (VarLocation)index;
                assembly.add("  movl "  + i.getDesc().getOffset() + "(%ebp), %edx");
            }
            if (isGlobal(d))
                return d.getNombre()+"(,%edx,4)";
            else
                return d.getOffset()+"(%ebp,%edx,4)";     
        }
        return "";
    }
    
    private String registro(){
        if (eaxLibre){
            eaxLibre=false;
            return "%eax";
        }
        else{
            eaxLibre=true;
            return "%edx";
        }
    }
   /* private boolean isGlobal(VarLocation v) {
        return v.isSoyGlobal();
    }*/
}
