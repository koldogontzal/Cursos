
public class Cola extends Lista {
	
	public Cola() {
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
			// En una cola hay que devolver el primer elemento
			Nodo n = super.getCabeza();
						
			Dato d = n.getDato();
			super.borrar(d);
			
			return d;
		}
	}
}
