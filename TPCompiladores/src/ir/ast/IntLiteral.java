/*
 * Autores: Agustin Bauer, Alan Gonzalez, Luciano Putruele.
 * Proyecto: TPCompiladores
 * Nodo del ast que representa un numero entero.
 */

package ir.ast;

import ir.ASTVisitor;

public class IntLiteral extends Literal {
	private Integer value;
        private Integer auxValue; //offsetmax
	
	/*
	 * Constructor for int literal that takes a string as an input
	 * @param: String integer
	 */
	public IntLiteral(Integer val,int line, int col){
                this.setLineNumber(line);
                this.setColumnNumber(col);
		value = val; // Will convert to int value in semantic check
                type = Type.INT;
	}
        
        public IntLiteral(Number val,int line, int col){
                this.setLineNumber(line);
                this.setColumnNumber(col);
		value = val.intValue(); // Will convert to int value in semantic check
                type = Type.INT;
	}
        
        public IntLiteral(Integer value, String lbl){
            this.value = value;
            this.label = lbl;
        }

        public Integer getAuxValue() {
            return auxValue;
        }

        public void setAuxValue(Integer auxValue) {
            this.auxValue = auxValue;
        }


	@Override
	public Type getType() {
		return type;
	}


	public Integer getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

	@Override
	public String toString() {
                if(label==null)
                    return value.toString();
                else{
                    if (value!=null)
                        return label + value.toString();
                    else
                        return label;
                }    
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

    @Override
    public String getClase() {
        return "int";
    }
}
