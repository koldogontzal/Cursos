
public class Lista extends Dato {
	private Nodo cabeza;
	
	public Lista() {
		this.cabeza = null;
	}
	
	public boolean vacia() {
		return (this.cabeza == null);
	}
	

	public void insert(Dato v) {
		if (this.vacia()) {
			this.cabeza = new Nodo(v);
		} else { 
			this.cabeza.insert(v);
			
		}
	}


	public boolean buscar(Dato v) {
		if (this.vacia()) {
			return false;
		} else {
			return this.cabeza.buscar(v);
		}
	}


	public void borrar(Dato v) {
		if (this.vacia()) {
			
		} else {
			Nodo ant = null;
			Nodo n = this.cabeza;
			while ((n != null) && !v.equals(n.getDato())) {
				ant = n;
				n = n.getNext();
			}
			if (ant == null) {
				// Es el primero de la lista
				this.cabeza = this.cabeza.getNext();
			} else if (n != null) {
				// Está en medio de la lista
				ant.enlazar(n.getNext());				
			} else {
				// No está en la lista
			}
		}
	}

	public String toString() {
		String msg = "";
		msg = msg + "[";
		if (this.vacia()) {
			msg = msg + "VACÍA";
		} else {
			// Él mete esto en el toString del Nodo, como si Nodo tuviera que recorrer toda la lista
			Nodo n = this.cabeza;
			while (n != null) {
				msg = msg + n + "\n";
				n = n.getNext();
			}
		}
		msg = msg + "]";
		
		return msg;
	}

	@Override
	public int compareTo(Object o) {
		Integer este = new Integer(this.numElementos());
		Integer otro = new Integer(((Lista)o).numElementos());
		
		return este.compareTo(otro);
	}

	@Override
	public boolean equals(Object obj) {
		Lista l = (Lista)obj;
		if (this.numElementos() != l.numElementos()) {
			return false;
		} else {
			if (this.vacia()) {
				return true;
			} else {
				return this.cabeza.comparaNodos(l.getCabeza());
			}
		}
	}
	
	public Nodo getCabeza() {
		return this.cabeza;
	}

	protected int numElementos() {
		int num = 0;
		if (!this.vacia()) {
			num = this.cabeza.numElementos();
		}
		return num;
	}

	public void setCabeza(Nodo nuevo) {
		this.cabeza = nuevo;
		
	}

}
