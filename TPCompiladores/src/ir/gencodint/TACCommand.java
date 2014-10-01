/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * 
 */
package ir.gencodint;

import ir.ast.Expression;

public class TACCommand {
    private TACOpType op;
    private Expression p1;
    private Expression p2;
    private Expression p3;

    public TACCommand(TACOpType op, Expression p1, Expression p2, Expression p3) {
        this.op = op;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
        public TACOpType getOp() {
        return op;
    }

    public Expression getP1() {
        return p1;
    }

    public Expression getP2() {
        return p2;
    }

    public Expression getP3() {
        return p3;
    }

    @Override
    public String toString() {
        if(p2!=null && p3!=null)
            return op +" "+ p1.toString() +" "+ p2.toString() +" "+ p3.toString();
        else
            if(p2!=null)
                return op +" "+ p1.toString() +" " + p2.toString();
            else
                return op +" "+ p1.toString();
    }
    
    
}
