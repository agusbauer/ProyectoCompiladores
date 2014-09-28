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
    
    private CTDSLexer lex;
    private  parser p;

    private static void semCheck(parser p){
       TypeCheckVisitor visitor = new TypeCheckVisitor(); 
       for (Block b : p.getASTs()){
           visitor.visit(b);
       }
       visitor.showErrors();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception, RuntimeException {
        /*System.out.println("nombre de archivo a compilar:");
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        String path = brr.readLine();*/
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" +args[0]));
        try{
        CTDSLexer lex = new CTDSLexer(br);
        parser p = new parser(lex);
        p.parse();
        semCheck(p);
        
        }
        catch (RuntimeException e) {
            System.err.print(e.toString());
        }
        
        
    }
}
