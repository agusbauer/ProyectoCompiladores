/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.gencodint;

import ir.ast.Expression;

/**
 *
 * @author luciano
 */
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
}
