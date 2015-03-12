
public class ListaOrdenada extends Lista {
	
	public void insert(Dato v) {
		if (super.vacia()) {
			super.insert(v);
		} else {
			Nodo ant = null;
			Nodo n = super.getCabeza();
			while ((n != null) && (v.compareTo(n.getDato()) > 0)) {
				ant = n;
				n = n.getNext();
			}
			if (ant == null) {
				// Es el primero de la lista
				Nodo nuevo = new Nodo(v);
				nuevo.enlazar(super.getCabeza());
				super.setCabeza(nuevo);
			} else {
				// Está en medio de la lista
				Nodo nuevo = new Nodo(v);
				nuevo.enlazar(n);
				ant.enlazar(nuevo);				
			}
		}
	}

}
