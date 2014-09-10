/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ast;

import ir.ASTVisitor;
import java.util.List;

/**
 *
 * @author luciano
 */
public class Extern extends Expression {
    private String string;
    private List<Expression> args;
    private List<String> args2;

    public Extern(String string,Type type, List<Expression> args, List<String> args2) {
        this.string = string;
        this.args = args;
        this.args2 = args2;
        this.type = type;
    }
       
    
    
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<Expression> getArgs() {
        return args;
    }

    public void setArgs(List<Expression> args) {
        this.args = args;
    }

    public List<String> getArgs2() {
        return args2;
    }

    public void setArgs2(List<String> args2) {
        this.args2 = args2;
    }
    
    
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
