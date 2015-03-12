
public class Arreglo extends Lista {
	
	public Arreglo() {
		super();
	}
	
	public void push(Dato d, int pos) {
		// Esto tendría que ser distinto, pero como la lista es ordenada, lo dejo así
		super.insert(d);
		// TODO aquí falta hacer todo
	}
	
	public Dato pop(int pos) {
		if (super.vacia()) {
			return null;
		} else {
			// En un array hay que devolver el elemento que marca "pos"
			Nodo n = super.getCabeza();
			n = n.getPos(pos);
			Dato d;
			if (n != null) {
				d = n.getDato();
				super.borrar(d);
			} else {
				d= null;
			}
			return d;
		}
	}
}
