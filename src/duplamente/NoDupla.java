package duplamente;

import dados.Item;

public class NoDupla {
	private Item info;
	private NoDupla anterior;
	private NoDupla proximo;
	
	public NoDupla(Item info) {
		this.info = info;
		this.anterior = null;
		this.proximo = null;
	}

	//  get set info
	public Item getInfo() {
		return info;
	}
	public void setInfo(Item info) {
		this.info = info;
	}

	//  get set anterior
	public NoDupla getAnterior() {
		return anterior;
	}
	public void setAnterior(NoDupla anterior) {
		this.anterior = anterior;
	}

	//  get set proximo
	public NoDupla getProximo() {
		return proximo;
	}
	public void setProximo(NoDupla proximo) {
		this.proximo = proximo;
	}
}