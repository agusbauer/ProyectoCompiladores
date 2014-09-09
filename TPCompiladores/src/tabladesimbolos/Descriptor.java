/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcompiladores;

/**
 *
 * @author luciano
 */
public abstract class Descriptor {
    
    protected String nombre;
    protected String tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
