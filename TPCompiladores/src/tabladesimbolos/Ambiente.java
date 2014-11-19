/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Ambiente: Representa un bloque del programa con sus variables, metodos, etc.
 */
package tabladesimbolos;

import java.util.HashMap;


public class Ambiente extends HashMap<String,Descriptor>{
   private int level;
   
   public Ambiente(int lvl){
       level = lvl;
   }

    public int getLevel() {
        return level;
    }
   
   
}
