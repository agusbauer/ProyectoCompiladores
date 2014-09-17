package ir.ast;

import ir.ASTVisitor;
import tabladesimbolos.Descriptor;

public class VarLocation extends Location {
	private Block block;
        private Descriptor desc;

	public VarLocation(String id, Descriptor d) {
		this.id = id;
                this.desc = d;
	}
        
        public VarLocation(String id, Block b, Descriptor d) {
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
}
