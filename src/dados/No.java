package dados;

public class No {
	private Item info;
	private No proximo;
	
	public No(Item info) {
		this.info = info;
		this.proximo = null;
	}

	public Item getInfo() {
		return info;
	}
	public void setInfo(Item info) {
		this.info = info;
	}

	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
}