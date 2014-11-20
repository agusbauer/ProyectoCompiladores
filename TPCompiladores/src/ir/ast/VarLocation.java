/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa una variable simple, arreglo o metodo
 */
package ir.ast;

import ir.ASTVisitor;
import tabladesimbolos.Descriptor;
import tabladesimbolos.DescriptorArreglo;
import tabladesimbolos.DescriptorSimple;

public class VarLocation extends Location {

    private Block block;
    private Descriptor desc; 
    private boolean soyGlobal;

    public VarLocation(String id, Descriptor d) {
        if (d.getClase().equals("descriptorSimple")) {
            DescriptorSimple.setOffsetCorriente(DescriptorSimple.getOffsetCorriente() - 4);
            d.setOffset(DescriptorSimple.getOffsetCorriente());
        }
        if (d.getClase().equals("descriptorArreglo")) {
            DescriptorArreglo da = (DescriptorArreglo) d;
            DescriptorArreglo.setOffsetCorriente(DescriptorArreglo.getOffsetCorriente() - 4 * da.getLongitud());
            d.setOffset(DescriptorArreglo.getOffsetCorriente());
        }
        this.id = id;
        this.desc = d;
    }

    public VarLocation(String id, Descriptor d, int line, int col, boolean isdecl, boolean isGlobal) {
        if (isdecl && !isGlobal){ //para diferenciar el caso de la declaracion del caso de  la asignacion
            if (d.getClase().equals("descriptorSimple")) {
                //System.out.println("VOY A IMPRIMIR DATA"+DescriptorSimple.getOffsetCorriente());
                DescriptorSimple.setOffsetCorriente(DescriptorSimple.getOffsetCorriente() - 4);
                //System.out.println("VOY A IMPRIMIR DATAA"+DescriptorSimple.getOffsetCorriente());
                d.setOffset(DescriptorSimple.getOffsetCorriente());
            }
            if (d.getClase().equals("descriptorArreglo")) {
                DescriptorArreglo da = (DescriptorArreglo) d;
                DescriptorArreglo.setOffsetCorriente(DescriptorArreglo.getOffsetCorriente() - 4 * da.getLongitud());
                d.setOffset(DescriptorArreglo.getOffsetCorriente());
            }
        }    
        soyGlobal = isGlobal;
        this.setLineNumber(line);
        this.setColumnNumber(col);
        this.id = id;
        this.desc = d;
    }

    public boolean isSoyGlobal() {
        return soyGlobal;
    }
    
    

    public VarLocation(String id, Block b, Descriptor d, int line, int col) {
        this.setLineNumber(line);
        this.setColumnNumber(col);
        this.id = id;
        this.block = b;
        this.desc = d;
    }

    public Descriptor getDesc() {
        return desc;
    }

    public void setDesc(Descriptor desc) {
        this.desc = desc;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }

    @Override
    public String getClase() {
        return "loc";
    }
}
