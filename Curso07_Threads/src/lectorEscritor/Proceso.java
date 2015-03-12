package lectorEscritor;

public abstract class Proceso implements Runnable {

	private Buffer recurso;
	
	public void asocia(Buffer b) {
		this.recurso = b;
	}
	
	public int leer() {
		return this.recurso.leer();
	}
	
	public void escribir(int val) {
		this.recurso.escribir(val);
	}

	public void pintaBuffer() {
		this.recurso.pintaBuffer();
	}

	// Como es abstracta, no necesito implementar el run() aquí.

}
