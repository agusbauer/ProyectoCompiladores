/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcompiladores;

import ir.*;
import ir.ast.*;
import ir.semcheck.TypeCheckVisitor;
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
        /*System.out.println("nombre de archivo a compilar:");
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        String path = brr.readLine();*/
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" +args[0]));
        CTDSLexer lex = new CTDSLexer(br);
        parser p = new parser(lex);
      
        //ASTVisitor v = new TypeCheckVisitor();
        p.parse();
        
    }
}
