package ejemplo04ServidorYClienteUsandoSerialized_NoFunciona;

import java.io.Serializable;

public class Objeto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -171876352807030935L;
	
	private int[] vector;
	private int numElementos;
	
	public Objeto() {
		this.vector = new int[10000];
		this.numElementos = (int)(Math.random() * 10000);
		for (int i = 0; i < this.numElementos; i++) {
			this.vector[i] = (int)(Math.random() * 256);
		}
	}
	
	public int getNumElementos() {
		return this.numElementos;
	}
	
	public int getElemento(int i) {
		return this.vector[i];
	}

}
