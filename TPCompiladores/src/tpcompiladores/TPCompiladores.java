/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcompiladores;

import java.io.FileReader;

import java.io.*;


/**
 *
 * @author luciano
 */
public class TPCompiladores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        System.out.println("Nombre de archivo para compilar:");
        BufferedReader r = new BufferedReader( new InputStreamReader(System.in));
        String path = r.readLine();
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/tpcompiladores/" +path));
        CTDSLexer lex = new CTDSLexer(br);
        parser p = new parser(lex);
        p.parse();
            
       
        
    }
}
