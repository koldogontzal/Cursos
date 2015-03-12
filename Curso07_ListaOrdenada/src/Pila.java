
public class Pila extends Lista {
	
	public Pila() {
		super();
	}
	
	public void push(Dato d) {
		// Esto tendr�a que ser distinto, pero como la lista es ordenada, lo dejo as�
		super.insert(d);
	}
	
	public Dato pop() {
		if (super.vacia()) {
			return null;
		} else {
			// En una pila hay que devolver el �ltimo elemento
			Nodo n = super.getCabeza();
			n = n.getUltimo();
			
			Dato d = n.getDato();
			super.borrar(d);
			
			return d;
		}
	}

}
