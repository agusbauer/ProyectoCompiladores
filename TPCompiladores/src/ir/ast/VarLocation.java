package ir.ast;

import ir.ASTVisitor;
import tabladesimbolos.Descriptor;

public class VarLocation extends Location {
	private int blockId;
        private Descriptor desc;

	public VarLocation(String id, Descriptor d) {
		this.id = id;
                this.desc = d;
	}
        
        public VarLocation(String id, int bId) {
		this.id = id;
		this.blockId = bId;
	}

        public Descriptor getDesc() {
            return desc;
        }

        public void setDesc(Descriptor desc) {
            this.desc = desc;
        }
	
        
        
	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	
	@Override
	public String toString() {
		return id;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
