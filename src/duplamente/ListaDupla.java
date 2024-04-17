package duplamente;

import dados.Item;

public class ListaDupla {
	private NoDupla primeiro;
	private NoDupla ultimo;
	private int qtdNos;
	
	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNos = 0;
	}

	//  get set primeiro
	public NoDupla getPrimeiro() {
		return primeiro;
	}
	public void setPrimeiro(NoDupla primeiro) {
		this.primeiro = primeiro;
	}

	//  get set ultimo
	public NoDupla getUltimo() {
		return ultimo;
	}
	public void setUltimo(NoDupla ultimo) {
		this.ultimo = ultimo;
	}

	//  get set qtdNos
	public int getQtdNos() {
		return qtdNos;
	}
	public void setQtdNos(int qtdNos) {
		this.qtdNos = qtdNos;
	}
	
	public boolean listaVazia() {
		return (this.primeiro == null);
	}
	
	public void inserirUltimo(Item info) {
		NoDupla novoNo = new NoDupla(info);
		
		if (this.listaVazia()) {
			this.primeiro = novoNo;
		}
		else {
			novoNo.setAnterior(this.ultimo);
			this.ultimo.setProximo(novoNo);
		}
		
		this.ultimo = novoNo;
		this.qtdNos++;
	}
	
	public NoDupla pesquisarNo(int chave) {
		NoDupla atual = this.primeiro;
		
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProximo();
		}
		return atual;
	}
	
	public boolean removerNo(int chave) {
		NoDupla atual = this.primeiro;
		
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProximo();
		}
		
		if (atual == null) {
			return false;
		}
		else {
			if (atual == this.primeiro) {
				this.primeiro = primeiro.getProximo();
				
				if (this.primeiro == null) {
					this.ultimo = null;
				}
				else {
					this.primeiro.setAnterior(null);
				}
			}
			else {
				if (atual == this.ultimo) {
					this.ultimo = this.ultimo.getAnterior();
					this.ultimo.setProximo(null);
				}
				else {
					atual.getProximo().setAnterior(atual.getAnterior());
					atual.getAnterior().setProximo(atual.getProximo());
				}
			}
		}
		
		this.qtdNos--;
		return true;
	}
	
	public String toString() {
		String msg = "";
		NoDupla atual = this.primeiro;
		
		while (atual != null) {
			msg += atual.getInfo().getChave() + "\n";
			atual = atual.getProximo();
		}
		
		return msg;
	}
	
	/*
	 * MÉTODOS A IMPLEMENTAR
	 * System.out.println("Informar número do procedimento pretendido:");
		System.out.println("1. Inserir valor");
		System.out.println("2. Pesquisar valor");
		System.out.println("3. Remover valor");
		System.out.println("4. Concatenar listas");                                     questão 6
		System.out.println("5. Pegar primeira metade da lista");                        questão 7
		System.out.println("6. Ver maior valor da lista");                              questão 8
		System.out.println("7. Média dos valores da lista");                            questão 9
		System.out.println("8. Retirar o número 0 da lista");                           questão 10
		System.out.println("9. Retirar números repetidos da lista");                    questão 11 
		System.out.println("10. Mostrar jogadores acima de 2 metros de altura");        questão 12
		System.out.println("11. Criar lista com produtos enlatados");                   questão 13
		System.out.println("12. Verificar palíndromo");                                 questão 14
		System.out.println("13. Ordenar e/ou aumentar lista ordenada");                 questão 15
		System.out.println("14. Sair");
	 */
	
	//  LISTA 04 - QUESTÃO 6 - Implemente método que concatene as listas L1 (this) e L2 (recebida por parâmetro)
	public ListaDupla concatenarListas(ListaDupla L2) {
		this.qtdNos += L2.qtdNos;
		this.ultimo.setProximo(L2.primeiro);
		L2.primeiro.setAnterior(this.ultimo);
		this.ultimo = L2.ultimo;
		L2.primeiro = null;
		L2.ultimo = null;
		L2.qtdNos = 0;
		return this;
	}
	
	//  LISTA 04 - QUESTÃO 7 - Retornar primeira metade da lista L1
	public ListaDupla primeiraMetade() {
		int qtdRetornada = this.qtdNos/2;
		ListaDupla listaRetornada = new ListaDupla();
		
		if (this.qtdNos == 1) {
			listaRetornada = this;
		}
		else {
			int count = 0;
			NoDupla atual = this.primeiro;
			
			while (count < qtdRetornada) {
				listaRetornada.inserirUltimo(new Item(atual.getInfo().getChave()));
				atual = atual.getProximo();
			}
		}
		
		return listaRetornada;
	}
	
	//  LISTA 04 - QUESTÃO 8 - Mostrar maior valor da lista
	public int maiorValor() {
		int maiorValor = 0;
		NoDupla atual = this.primeiro;
		
		if (this.listaVazia()) {
			return -1;
		}
		else {
			while(atual != null) {
				if (atual.getInfo().getChave() > maiorValor) {
					maiorValor = atual.getInfo().getChave();
				}
				atual = atual.getProximo();
			}
		}
		
		return maiorValor;
	}
	
	//  LISTA 04 - QUESTÃO 9 - Calcular média aritmética
	public double mediaAritmetica() {
		double media = 0;
		int total = 0;
		NoDupla atual = this.primeiro;
		
		if (this.listaVazia()) {
			return -1.0;
		}
		else {
			while (atual != null) {
				total += atual.getInfo().getChave();
				atual = atual.getProximo();
			}
			
			media = total/this.qtdNos;
		}
		
		return media;
	}
	
	//  LISTA 04 - QUESTÃO 10 - Retirar os zeros da lista
	public String retiraZero() {
		int count = 0;
		NoDupla atual = this.primeiro;
		
		while (atual != null) {
			if (atual.getInfo().getChave() == 0) {
				count++;
			}
		}
		
		if (count == 0) {
			return "Não existe 0 na lista.";
		}
		else {
			for (int i = 0; i < count; i++) {
				this.removerNo(0);
			}
			
			return "Todos os zeros foram removidos.";
		}
	}
	
	//  LISTA 04 - QUESTÃO 11 - Retirar valores repetidos
}