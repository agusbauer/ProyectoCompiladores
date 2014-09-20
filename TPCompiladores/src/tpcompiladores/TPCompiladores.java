/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcompiladores;

import java.io.FileReader;

import java.io.*;
import parser.*;


/**
 *
 * @author luciano
 */
public class TPCompiladores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/tpcompiladores/" +args[0]));
        CTDSLexer lex = new CTDSLexer(br);
        parser p = new parser(lex);
        p.parse();       
    }
}
