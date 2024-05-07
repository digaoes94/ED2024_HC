package pilha;

import dados.Item;
import dados.ItemChar;
import duplamente.ListaDupla;
import duplamente.NoDupla;

public class PilhaContig {
	private Item[] info;
	private int topo;
	
	public PilhaContig(int qtd) {
		this.topo = 0;
		this.info = new Item[qtd];
	}

	//  get info
	public Item[] getInfo() {
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
	
	public boolean empilhar(Item item) {
		if (this.eCheia()) {
			return false;
		}
		else {
			this.info[this.topo] = item;
			this.topo++;
			return true;
		}
	}
	
	public Item desempilhar() {
		if (this.eVazia()) {
			return null;
		}
		else {
			this.topo--;
			return this.info[this.topo];
		}
	}
	
	/*
	 * System.out.println("Informe o procedimento a realizar:");
		System.out.println("1. Adicionar valor à pilha");
		System.out.println("2. Retirar valor da pilha");
		System.out.println("3. Inverter palavra ou frase");                                                                     Q1
		System.out.println("4. Retirar valores maiores do que 10 da pilha");                                                    Q2
		System.out.println("5. Comparar se pilhas são iguais");                                                                 Q3
		System.out.println("6. Checar se uma palavra é o inverso de outra");                                                    Q5
		System.out.println("7. Calcular fatorial de um número");                                                                Q7
		System.out.println("8. Converter número da base decimal para a base binária");                                          Q8
		System.out.println("9. Transferir valores de uma Pilha para uma Lista Duplamente Encadeada");                           Q9
		System.out.println("10. Retirar todas as ocorrências de um valor X da pilha");                                          Q10
		System.out.println("11. Transferir todas as ocorrências do valor X de uma Lista Duplamente Encadeada para uma Pilha");  Q11
		System.out.println("12. Verificar se a palavra é um palíndromo");                                                       Q12
		System.out.println("13. Calcular a potência da pilha");                                                                 Q13
		System.out.println("14. Adicionar duas pilhas a um único vetor");                                                       Q14
		System.out.println("15. Verificar se uma palavra é o inverso da outra, e se ambas só apresentam as letras A e B");      Q15
		System.out.println("16. Sair do programa");
	 */
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 1 - Inverter frase ou palavra
	public void inverterString(String original) {
		PilhaContigString aux = new PilhaContigString(original.length());
		
		for (int a = 0; a < original.length(); a++) {
			aux.empilharChar(new ItemChar(original.charAt(a)));
		}
		
		while (!aux.eVazia()) {
			System.out.print(aux.desempilharChar().getChave());
		}
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 2 - Retirar valores maiores do que 10 da pilha
	public boolean retiraMaiorQueDez() {
		int count = 0;
		PilhaContig aux = new PilhaContig(this.topo);
		Item item;
		
		while (!this.eVazia()) {
			item = this.desempilhar();
			
			if (item.getChave() > 10) {
				count++;
				aux.empilhar(item);
			}
		}
		
		while (!aux.eVazia()) {
			this.empilhar(aux.desempilhar());
		}
		
		if (count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 3 - Comparar se pilhas são iguais
	public int compararPilhas(PilhaContig pilha2) {
		PilhaContig aux1 = new PilhaContig(this.topo);
		PilhaContig aux2 = new PilhaContig(pilha2.topo);
		Item item1, item2;
		
		if (this.topo != pilha2.topo) {
			return 0;
		}
		else {
			while (!this.eVazia() && !pilha2.eVazia()) {
				item1 = this.desempilhar();
				aux1.empilhar(item1);
				
				item2 = pilha2.desempilhar();
				aux2.empilhar(item2);
				
				if (item1.getChave() != item2.getChave()) {
					return 0;
				}
			}
			
			return 1;
		}
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 5 - Comparar se uma string é o inverso de outra string
	public boolean compararStringInverso(String string1, String string2) {
		PilhaContigString aux1 = new PilhaContigString(string1.length());
		PilhaContigString aux2 = new PilhaContigString(string2.length());
		PilhaContigString aux3 = new PilhaContigString(string1.length());
		String compara1 = "";
		String compara2 = "";
		
		if (string1.length() != string2.length()) {
			return false;
		}
		else {
			for (int a = 0; a < string1.length(); a++) {
				aux1.empilharChar(new ItemChar(string1.charAt(a)));
				aux2.empilharChar(new ItemChar(string2.charAt(a)));
			}
		}
		
		while (!aux2.eVazia()) {
			aux3.empilharChar(aux2.desempilharChar());
		}
		
		while (!aux1.eVazia() && !aux3.eVazia()) {
			compara1 += aux1.desempilharChar().getChave();
			compara2 += aux3.desempilharChar().getChave();
		}
		
		if (compara1 == compara2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 7 - Calcular fatorial
	public long calculaFatorial(int base) {
		long resultado = 1L;
		PilhaContig fatorial = new PilhaContig(base);
		
		for (int a = base; a > 0; a--) {
			fatorial.empilhar(new Item(a));
		}
		
		while (!fatorial.eVazia()) {
			resultado *= fatorial.desempilhar().getChave();
		}
		
		return resultado;
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 8 - Calcular número binário a partir de número decimal
	public String converteDecimalBinario(int valor) {
		String binario = "";
		int resultado, resto;
		PilhaContig aux = new PilhaContig(valor);
		
		for (int a = valor; a > 2;) {
			resultado = a/2;
			resto = a%2;
			
			aux.empilhar(new Item(resto));
			a = resultado;
		}
		
		while (!aux.eVazia()) {
			binario += aux.desempilhar().getChave();
		}
		
		return binario;
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 9 - Transferir valores de uma pilha para uma lista duplamente encadeada
	public void pilhaParaListaDupla(ListaDupla lista) {
		PilhaContig aux = new PilhaContig(this.topo);
		
		while (!this.eVazia()) {
			aux.empilhar(this.desempilhar());
		}
		
		while(!aux.eVazia()) {
			lista.inserirUltimo(aux.desempilhar());
		}
		
		System.out.println(lista.toString());
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 10 - Retire todos os valores iguais a X
	public void retirarOcorrenciasValor(int valor) {
		PilhaContig aux = new PilhaContig(this.topo);
		Item item;
		
		while (!this.eVazia()) {
			item = this.desempilhar();
			
			if (item.getChave() != valor) {
				aux.empilhar(item);
			}
		}
		
		while (!aux.eVazia()) {
			this.empilhar(aux.desempilhar());
		}
	}
	
	//  LISTA DE EXERCICIOS 5 - QUESTÃO 11 - Retira uma valor da lista dupla e dpois passa tudo para pilha
	public PilhaContig listaRevisadaParaPilha(PilhaContig pilha, int valor) {
		ListaDupla lista = new ListaDupla();
		NoDupla atual = lista.getPrimeiro();
		
		if (lista.listaVazia()) {
			return pilha;
		}
		else {
			while (atual != null) {
				if (atual.getInfo().getChave() == valor) {
					lista.removerNo(valor);
				}
				else {
					pilha.empilhar(new Item(atual.getInfo().getChave()));
				}
				
				atual = atual.getProximo();
			}
		}
		
		return pilha;
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 12 - Verificar palíndromo
	public boolean verificarPalindromo(String original) {
		String inversa = "";
		PilhaContigString aux = new PilhaContigString(original.length());
		
		for (int a = 0; a < original.length(); a++) {
			aux.empilharChar(new ItemChar(original.charAt(a)));
		}
		
		while (!aux.eVazia()) {
			inversa += aux.desempilharChar().getChave();
		}
		
		if (original == inversa) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 13 - Calcular a potencia da pilha
	public long potenciaPilha() {
		long resultado = 1;
		PilhaContig aux = new PilhaContig(this.topo);
		Item item;
		
		while (!this.eVazia()) {
			item = this.desempilhar();
			aux.empilhar(item);
			resultado *= Math.pow(item.getChave(), this.topo);
		}
		
		while (!aux.eVazia()) {
			this.empilhar(aux.desempilhar());
		}
		
		return resultado;
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 14 - Adicionar duas pilhas em um único vetor
	public int[] duasPilhasUmVetor(PilhaContig pilha1, PilhaContig pilha2) {
		int[] vetor = new int[(pilha1.topo + pilha2.topo)];
		
		for (int a = 0; a < pilha1.topo; a++) {
			vetor[a] = pilha1.desempilhar().getChave();
		}
		
		for (int a = pilha2.topo; a > pilha2.topo; a--) {
			vetor[a] = pilha2.desempilhar().getChave();
		}
		
		return vetor;
	}
	
	//  LISTA DE EXERCÍCIOS 5 - QUESTÃO 15 - Palindromo e A ou B
	public boolean palindromoAB(String x, String y) {
		PilhaContigString pilha1 = new PilhaContigString(x.length());
		PilhaContigString pilha2 = new PilhaContigString(y.length());
		PilhaContigString aux1 = new PilhaContigString(x.length());
		PilhaContigString aux2 = new PilhaContigString(y.length());
		ItemChar item1, item2;
		
		if (x.length() != y.length()) {
			return false;
		}
		else {
			while (!pilha1.eVazia()) {
				item1 = pilha1.desempilharChar();
				item2 = pilha2.desempilharChar();
				
				if (item1.getChave() != 'A' && item1.getChave() != 'B') {
					return false;
				}
				if (item2.getChave() != 'A' && item2.getChave() != 'B') {
					return false;
				}
				
				aux1.empilharChar(item1);
				aux2.empilharChar(item2);
			}
		}
		
		while (!pilha1.eCheia()) {
			item1 = aux1.desempilharChar();
			item2 = aux2.desempilharChar();
			
			if (item1 != item2) {
				return false;
			}
			
			pilha1.empilharChar(item1);
			pilha2.empilharChar(item2);
		}
		
		return true;
	}
}
