package filaCircular;

import dados.Item;

public class FilaCircular {
	private Item[] info;
	private int frente, tras, tamanho;
	
	public FilaCircular(int qtd) {
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;
		this.info = new Item[qtd];
	}

	public Item[] getInfo() {
		return info;
	}

	public int getFrente() {
		return frente;
	}

	public int getTras() {
		return tras;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public boolean eVazia() {
		return (this.tamanho == 0);
	}
	
	public boolean eCheia() {
		return (this.tamanho == this.info.length);
	}
	
	public boolean enfileirar(Item item) {
		if (this.eCheia()) {
			return false;
		}
		else {
			this.info[this.tras] = item;
			this.tras = (++this.tras % this.info.length);
			this.tamanho++;
			return true;
		}
	}
	
	public boolean desenfileirar() {
		Item item;
		
		if (this.eVazia()) {
			return false;
		}
		else {
			item = this.info[this.frente];
			this.frente = (++this.frente % this.info.length);
			this.tamanho--;
			return true;
		}
	}
	
	public String toString() {
		String msg = "";
		int aux = this.frente;
		
		for (int i = 1; i <= this.tamanho; i++) {
			msg += this.info[aux].getChave() + " ";
			aux = (++aux % this.info.length);
		}
		
		return msg;
	}
}
