
public class Pila extends Lista {
	
	public Pila() {
		super();
	}
	
	public void push(Dato d) {
		// Esto tendría que ser distinto, pero como la lista es ordenada, lo dejo así
		super.insert(d);
	}
	
	public Dato pop() {
		if (super.vacia()) {
			return null;
		} else {
			// En una pila hay que devolver el último elemento
			Nodo n = super.getCabeza();
			n = n.getUltimo();
			
			Dato d = n.getDato();
			super.borrar(d);
			
			return d;
		}
	}

}
