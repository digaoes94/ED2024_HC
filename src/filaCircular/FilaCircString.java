package filaCircular;

import dados.ItemChar;

public class FilaCircString {
	private ItemChar[] info;
	private int frente, tras, tamanho;

	public FilaCircString(int qtd) {
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;
		this.info = new ItemChar[qtd];
	}

	public ItemChar[] getInfo() {
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

	public boolean enfileirar(ItemChar item) {
		if (this.eCheia()) {
			return false;
		} else {
			this.info[this.tras] = item;
			this.tras = (++this.tras % this.info.length);
			this.tamanho++;
			return true;
		}
	}

	public ItemChar desenfileirar() {
		ItemChar item;

		if (this.eVazia()) {
			return null;
		} else {
			item = this.info[this.frente];
			this.frente = (++this.frente % this.info.length);
			this.tamanho--;
			return item;
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
