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
    
    private List<Object > args;

    public Extern(String string,Type type, List<Object> args,int line, int col) {
        this.setLineNumber(line);
        this.setColumnNumber(col);
        this.string = string;
        this.args = args;      
        this.type = type;
    }
       
    
    
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<Object> getArgs() {
        return args;
    }

    public void setArgs(List<Object> args) {
        this.args = args;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
