package lectorEscritor;

public class Buffer {
	
	private int[] array;
	private int posLectura = 0;
	private int posEscritura = 0;
	
	public Buffer(int n){
		this.array = new int[n];
	}
	
	synchronized public int leer() {
		if (this.vacio()) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Cuando alguien me despierta, es porque ya hay datos y puedo leer
		int valor = this.array[this.posLectura];
		this.posLectura = this.siguienteElemento(this.posLectura);
		
		// Al quitar un dato, tengo que despertar a quien esté dormido esperando hueco
		super.notify();
		
		return valor;
		
	}
	
	synchronized public void escribir(int val) {
		if (this.lleno()) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Si llego aquí es que ya hay hueco para escribir
		this.array[this.posEscritura] = val;
		this.posEscritura = this.siguienteElemento(this.posEscritura);
		
		// Si escribo un dato, tengo que despertar a quien pueda que este esperando a leer
		super.notify();
	}
	
	public boolean vacio() {
		return (this.posLectura == this.posEscritura);
	}
	
	public boolean lleno() {
		return (this.siguienteElemento(this.posEscritura) == this.posLectura);
	}
	
	private int siguienteElemento(int pos) {
		return ((pos + 1) % this.array.length);
	}

	public void pintaBuffer() {
		String salida = "\nBUFFER:\n | ";
		
		for (int i = 0; i < this.array.length; i++) {
			if (this.estaOcupado(i)) {
				salida = salida + this.array[i] + " | ";
			} else {
				salida = salida + " | ";
			}				
		}
		
		Pantalla.println(salida + "\n");
		
	}

	private boolean estaOcupado(int i) {
		int posInic = this.posLectura;
		int posFinl = this.posEscritura;
		if (this.posEscritura < this.posLectura) {
			posFinl = posFinl + this.array.length;
			i = i + this.array.length;
		}
		return ((i >= posInic) && (i < posFinl));
	}
	
	

}
