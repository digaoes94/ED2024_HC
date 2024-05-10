package filaCircular;

import dados.Item;
import dados.ItemChar;
import pilha.PilhaContig;
import pilha.PilhaContigString;
import filaCircular.FilaCircString;

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
	public FilaCircString imprimeDecrescente(FilaCircString docOriginal) {
		FilaCircString docInverso = new FilaCircString(docOriginal.getTamanho());
		PilhaContigString pilha = new PilhaContigString(docOriginal.getTamanho());
		
		while (!docOriginal.eVazia()) {
			pilha.empilharChar(docOriginal.desenfileirar());
		}
		
		while (!pilha.eVazia()) {
			docInverso.enfileirar(pilha.desempilharChar());
		}
		
		return docInverso;
	}
	
	//  LISTA DE EXERCÍCIOS 6 - QUESTÃO 5 - Separar pessoas 70+ em fila preferencial
	public FilaCircular filaPreferencial(FilaCircular original) {
		FilaCircular aux = new FilaCircular(original.tamanho);
		FilaCircular preferencial = new FilaCircular(100);
		int idade = 70;
		Item item;
		
		while (!original.eVazia()) {
			item = original.desenfileirar();
			
			if (item.getChave() >= idade) {
				preferencial.enfileirar(item);
			}
			else {
				aux.enfileirar(item);
			}
		}
		
		while (!aux.eVazia()) {
			original.enfileirar(aux.desenfileirar());
		}
		
		return preferencial;
	}
	
	//  LISTA DE EXERCÍCIOS 6 - QUESTÃO 6 - Inserir X acima de 10
	//  OBS: bem provável que aconteça StackOverflow se ficar desse jeito
	public boolean enfilerar10(int x) {
		FilaCircular aux = new FilaCircular(this.tamanho);
		Item item;
		
		while (!this.eVazia()) {
			aux.enfileirar(this.desenfileirar());
		}
		
		while (!aux.eVazia()) {
			item = aux.desenfileirar();
			
			if (item.getChave() == 10) {
				this.enfileirar(item);
				this.enfileirar(new Item(x));
			}
			else {
				this.enfileirar(item);
			}
		}
		
		return (this.eCheia());
	}
	
	//  LISTA DE EXERCÍCIOS 6 - QUESTÃO 7 - Passar alunos desqualificados de uma fila para uma lista
	//  OBS: o código ficará comentado pois a Fila e a Lista precisam guardar valores booleanos, o que implica criar duas novas classes
	//  OBS2: considere que o Item da FilaCircString também guarde um valor boolean
	
	/*
	 * public ListaDuplaString alunosDesqualificados(FilaCircString original) {
	 * 		FilaCircString aux = new FilaCircString(this.tamanho);
	 * 		ListaDuplaString alunosDesqualificados = new ListaDuplaString();
	 * 		ItemString item;
	 * 
	 * 		while (!original.eVazia()) {
	 * 			item = original.desenfileirar();
	 * 			
	 * 			if (item.getBool() == true) {
	 * 				alunosDequalificados.inserirUltimo(item.getNome());
	 * 			}
	 * 			else {
	 * 				aux.enfileirar(item);
	 * 			}
	 * 		}
	 * 
	 * 		while (!aux.eVazia()) {
	 * 			item = original.desenfileirar();
	 * 			
	 * 			original.enfileirar(aux.desenfileirar());
	 * 		}
	 * 
	 * 		return alunosDesqualificados;
	 * }
	 */
}
