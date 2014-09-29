/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcompiladores;

import ir.*;
import ir.ast.*;
import ir.gencodint.TACGenerator;
import ir.semcheck.TypeCheckVisitor;
import java.io.FileReader;

import java.io.*;
import java.util.LinkedList;
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
    
    private static void genCodInt(parser p, String nombre) throws IOException{
       TACGenerator visitor = new TACGenerator(); 
       for (Block b : p.getASTs()){
           visitor.visit(b);
       }
       LinkedList<String> code = visitor.getCode();
       PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/" +nombre+".tac")));
       for (String comm : code){
           out.write(comm);
           out.write("\n");
       }
       out.close();
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
        genCodInt(p,args[0]);
        
        }
        catch (RuntimeException e) {
            System.err.print(e.toString());
        }
        
        
    }
}
