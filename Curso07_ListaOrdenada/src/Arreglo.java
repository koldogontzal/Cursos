
public class Arreglo extends Lista {
	
	public Arreglo() {
		super();
	}
	
	public void push(Dato d, int pos) {
		// Esto tendr�a que ser distinto, pero como la lista es ordenada, lo dejo as�
		super.insert(d);
		// TODO aqu� falta hacer todo
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
