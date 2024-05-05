package pilha;

import dados.Item;

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
		System.out.println("3. Inverter palavra ou frase");
		System.out.println("4. Retirar valores maiores do que 10 da pilha");
		System.out.println("5. Comparar se pilhas são iguais");
		System.out.println("6. Checar se uma palavra é o inverso de outra");
		System.out.println("7. Calcular fatorial de um número");
		System.out.println("8. Converter número da base decimal para a base binária");
		System.out.println("9. Transferir valores de uma Pilha para uma Lista Duplamente Encadeada");
		System.out.println("10. Retirar todas as ocorrências de um valor X da pilha");
		System.out.println("11. Transferir todas as ocorrências do valor X de uma Lista Duplamente Encadeada para uma Pilha");
		System.out.println("12. Verificar se a palavra é um palíndromo");
		System.out.println("13. Calcular a potência da pilha");
		System.out.println("14. Adicionar duas pilhas a um único vetor");
		System.out.println("15. Verificar se uma palavra é o inverso da outra, e se ambas só apresentam as letras A e B");
		System.out.println("16. Sair do programa");
	 */
}
