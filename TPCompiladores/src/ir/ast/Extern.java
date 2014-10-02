/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una expresion de invocacion externa .
 */
package ir.ast;

import ir.ASTVisitor;
import java.util.List;


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
    public String toString() {
        return string;
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
