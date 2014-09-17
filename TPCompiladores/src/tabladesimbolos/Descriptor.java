/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladesimbolos;

import ir.ast.Type;

/**
 *
 * @author luciano
 */
public abstract class Descriptor {
    
    protected String nombre;
    protected Type tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }
    
    public String getClase(){
        return "descriptor";
    }
    
}
