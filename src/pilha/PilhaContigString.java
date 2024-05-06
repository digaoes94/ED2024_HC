package pilha;

import dados.Item;
import dados.ItemChar;

public class PilhaContigString {
	private ItemChar[] info;
	private int topo;
	
	public PilhaContigString(int qtd) {
		this.info = new ItemChar[qtd];
		this.topo = 0;
	}
	
	//  get info
	public ItemChar[] getInfo() {
		return info;
	}

	//  get topo
	public int getTopo() {
		return topo;
	}
	
	public boolean eVazia() {
		return (this.topo == 0);
	}
	
	public boolean eCheia() {
		return (this.topo == this.info.length);
	}
	
	public boolean empilharChar(ItemChar item) {
		if (this.eCheia()) {
			return false;
		}
		else {
			this.info[this.topo] = item;
			this.topo++;
			return true;
		}
	}
	
	public ItemChar desempilharChar() {
		if (this.eVazia()) {
			return null;
		}
		else {
			this.topo--;
			return this.info[this.topo];
		}
	}
}
