/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa la sentencia skip.
 */

package ir.ast;

import ir.ASTVisitor;

public class SkipStmt extends Statement {
    

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
