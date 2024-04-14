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
}