package simplesmente;

import dados.Item;
import dados.No;

public class ListaSimples {
	private No primeiro;
	private No ultimo;
	private int qtdNos;
	
	public ListaSimples() {
		this.primeiro = null;
		this.ultimo = null;
		this.qtdNos = 0;
	}

	public No getPrimeiro() {
		return primeiro;
	}
	public void setPrimeiro(No primeiro) {
		this.primeiro = primeiro;
	}

	public No getUltimo() {
		return ultimo;
	}
	public void setUltimo(No ultimo) {
		this.ultimo = ultimo;
	}

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
		No novoNo = new No(info);
		
		if (this.listaVazia()) {
			this.primeiro = novoNo;
		}
		else {
			this.ultimo.setProximo(novoNo);
		}
		
		this.ultimo = novoNo;
		this.qtdNos++;
	}
	
	public No pesquisarNo(int chave) {
		No atual = this.primeiro;
		
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProximo();
		}
		
		return atual;
	}
	
	public boolean removerNo(int chave) {
		No atual = this.primeiro;
		No anterior = null;
		
		if (this.listaVazia()) {
			return false;
		}
		else {
			while ((atual != null) && (atual.getInfo().getChave() != chave)) {
				anterior = atual;
				atual = atual.getProximo();
			}
			
			if (atual == null) {
				return false;
			}
			else {
				if (atual == this.primeiro) {
					if (this.primeiro == this.ultimo) {
						this.ultimo = null;
					}
					
					this.primeiro = this.primeiro.getProximo();
				}
				else {
					if (atual == this.ultimo) {
						this.ultimo = anterior;
					}
					
					anterior.setProximo(atual.getProximo());
				}
				
				this.qtdNos--;
				return true;
			}
		}
	}
	
	//  LISTA DE EXERCÍCIOS 2 - QUESTÃO 7 (função de somar valores)
	public int somaValores() {
		int soma = 0;
		No aux = this.getPrimeiro();
		
		if (this.listaVazia()) {
			soma = 0;
		}
		else {
			while (aux != null) {
				soma += aux.getInfo().getChave();
				aux = aux.getProximo();
			}
		}
		
		return soma;
	}
	
	//  LISTA DE EXERCÍCIOS 2 - QUESTÃO 8 (média dos valores da lista)
	public double mediaValores() {
		if (this.listaVazia()) {
			return 0.0;
		}
		else {
			return (double) this.somaValores()/this.getQtdNos();
		}
	}
	
	//  LISTA DE EXERCÍCIOS 2 - QUESTÃO 9 (mostrar valores PAR)
	public String valoresPar() {
		if (this.listaVazia()) {
			return "A lista está vazia.";
		}
		else {
			String pares = "";
			No aux = this.getPrimeiro();
			
			while (this.getPrimeiro() != null) {
				if (aux.getInfo().getChave() % 2 == 0) {
					pares += aux.getInfo().getChave() + "\n";
				}
				
				aux = aux.getProximo();
			}
			
			return pares;
		}
	}
	
	//  LISTA DE EXERCÍCIOS 2 - QUESTÃO 10 (VERDADEIRO se duas listas forem iguais)
	public boolean compararListas (ListaSimples L1, ListaSimples L2) {
		boolean status = false;
		No aux1 = L1.getPrimeiro();
		No aux2 = L2.getPrimeiro();
		
		if (aux1 != aux2) {
			status = false;
		}
		else {
			while ((aux1 != null) && (aux2 != null)) {
				if (aux1 == aux2) {
					status = true;
					aux1 = aux1.getProximo();
					aux2 = aux2.getProximo();
				}
				else {
					status = false;
					break;
				}
			}
		}
		
		return status;
	}
	
	//  LISTA DE EXERCÍCIOS 2 - QUESTÃO 11 (trocar para 50)
	public String trocar50(int chave) {
		No atual = this.getPrimeiro();
		
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProximo();
		}
		
		if (atual == null) {
			return "Valor não encontrado.";
		}
		else {
			atual.getInfo().setChave(50);
			return "Valor alterado para 50.";
		}
	}
	
	//  LISTA DE EXERCÍCIOS 2 - QUESTÃO 12 (retorna ocorrencias ou adiciona à lista)
	public int encontraOuAdiciona (int chave) {
		No aux = this.getPrimeiro();
		int count = 0;
		
		if (this.listaVazia()) {
			this.inserirUltimo(new Item(chave));
			return count;
		}
		else {
			while (aux != null) {
				if (aux.getInfo().getChave() == chave) {
					count++;
					aux = aux.getProximo();
				}
				else {
					aux = aux.getProximo();
				}
			}
			
			if ((aux == null) && (count == 0)) {
				this.inserirUltimo(new Item(chave));
			}
			
			return count;
		}
	}
	
	public String toString() {
		String msg = "";
		No atual = this.getPrimeiro();
		
		while (atual != null) {
			msg += atual.getInfo().getChave() + "\n";
			atual = atual.getProximo();
		}
		
		return msg;
	}
}