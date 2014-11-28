/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Clase main del proyecto.
 */
package tpcompiladores;

import ir.*;
import ir.ast.*;
import ir.genAssembly.GenAssembly;
import ir.gencodint.TACCommand;
import ir.gencodint.TACGenerator;
import ir.semcheck.TypeCheckVisitor;
import java.io.FileReader;

import java.io.*;
import java.util.LinkedList;
import parser.*;
import tabladesimbolos.TablaDeSimbolos;



public class TPCompiladores {
    

    private static void semCheck(parser p){
       TypeCheckVisitor visitor = new TypeCheckVisitor(); 
       for (Block b : p.getASTs()){
           visitor.visit(b);
       }
       visitor.showErrors();
    }
    

    
    private static void genAssembly(parser p, String nombre) throws IOException{
       TACGenerator visitor = new TACGenerator(); 
       for (Block b : p.getASTs()){
           visitor.visit(b);
       }
       GenAssembly gen = new GenAssembly(visitor.getCode(),p,visitor.getCantMetodos());
       LinkedList<String> assembly = gen.genAssembly();
       assembly.addFirst("  .file  "+"\""+nombre.replace(".ctds", ".asm")+"\"");
             
       PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/" +nombre.replace(".ctds", ".asm"))));
       for (String comm : assembly){
           System.out.println(comm);
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
        genAssembly(p, args[0]);
        }
        catch (RuntimeException e) {
            System.err.print(e.toString());
        }        
    }
}
