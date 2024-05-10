package filaCircular;

import dados.Item;
import pilha.PilhaContig;

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
	
	public Item desenfileirar() {
		Item item;
		
		if (this.eVazia()) {
			return null;
		}
		else {
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
	
	/*
	 * System.out.println("Selecione o procedimento a executar:");
		System.out.println("1. Enfileirar valor");
		System.out.println("2. Desenfileirar valor");
		System.out.println("3. Imprimir fila");
		System.out.println("4. Retirar valores negativos da fila");
		System.out.println("5. Somar os valores da fila");
		System.out.println("6. Transferir valores de uma pilha para uma fila");
		System.out.println("7. Imprimir documento em ordem decrescente");
		System.out.println("8. Separar pessoas de idade 70+ em fila preferencial");
		System.out.println("9. Inserir valor X acima das ocorrências do valor 10");
		System.out.println("10. Passar alunos desclassificados da fila para uma lista");
		System.out.println("11. Sair do programa");
	 */
	
	// LISTA DE EXERCÍCIOS 6 - QUESTÃO 1 - Retirar valores negativos da fila
	public void retiraNegativos() {
		FilaCircular aux = new FilaCircular(this.tamanho);
		Item atual = null;
		
		while (!this.eVazia()) {
			atual = this.desenfileirar();
			
			if (atual.getChave() >= 0) {
				aux.enfileirar(atual);
			}
		}
		
		this.enfileirar(aux.desenfileirar());
	}
	
	//  LISTA DE EXERCÍCIOS 6 - QUESTÃO 2 - Somar os valores da fila
	public int somaValores() {
		int resultado = 0;
		
		while (!this.eVazia()) {
			resultado += this.desenfileirar().getChave();
		}
		
		return resultado;
	}
	
	//  LISTA DE EXERCÍCIOS 6 - QUESTÃO 3 - Transferir valores de uma pilha para uma fila
	public FilaCircular pilhaParaFila(PilhaContig pilha) {
		FilaCircular fila = new FilaCircular(pilha.getTopo() - 1);
		PilhaContig aux = new PilhaContig(pilha.getTopo());
		
		while (!pilha.eVazia()) {
			aux.empilhar(pilha.desempilhar());
		}
		
		while (!aux.eVazia()) {
			fila.enfileirar(aux.desempilhar());
		}
		
		return fila;
	}
	
	//  LISTA DE EXERCÍCIOS 6 - QUESTÃO 4 - Imprimir documento em ordem decrescente
	
}
