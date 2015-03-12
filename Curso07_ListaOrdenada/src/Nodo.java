
public class Nodo {
	private Dato dato;
	private Nodo next;
	
	public void enlazar(Nodo n) {
		this.next = n;
	}
	
	public Nodo(Dato n) {
		this.dato = n;
		this.next = null;
	}

	public Dato getDato() {
		return this.dato;
	}

	public Nodo getNext() {
		return this.next;
	}
	
	@Override
	public String toString() {
		return "" + this.dato;
	}

	public boolean buscar(Dato v) {
		if (this.dato.equals(v)) {
			return true;
		}
		if (this.next != null) {
			return this.next.buscar(v);
		}		
		return false;
	}

	public Nodo borrar(Dato v) {
		if (!this.dato.equals(v)) {
			Nodo sig = this.getNext();
			if (sig != null) {
				sig.borrar(v);
			}
			return this;
		} else {
			return this.getNext();
		}
	}

	public int numElementos() {
		if (this.getNext() == null) {
			return 1;
		} else {
			return 1 + this.getNext().numElementos();
		}
	}

	public boolean comparaNodos(Nodo nodo) {
		if (this.getDato().equals(nodo.getDato())) {
			if ((this.getNext() != null) && (nodo.getNext() != null)) {
				return this.getNext().comparaNodos(nodo.getNext());
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public Nodo getUltimo() {
		if (this.getNext() != null) {
			return this.getNext().getUltimo();
		}
		return this;
	}

	public Nodo getPos(int pos) {
		if (pos == 0) {
			return this;
		} else {
			if (this.getNext() != null) {
				return this.getNext().getPos(pos - 1);
			} else {
				return null;
			}
		}
	}

	public void insert(Dato v) {
		if (this.next == null) {
			Nodo n = new Nodo(v);
			this.next = n;
		} else {
			this.next.insert(v);
		}
		
	}
}
