package juego;

public class Coordenada {
	private int fila;
	private int columna;
	
	public Coordenada() {}
	
	public Coordenada(int i, int j) {
		this.fila = i;
		this.columna = j;
	}

	public void leeCoordenada() {
	
		System.out.print("Introduce la fila (empiezan por 0 arriba): ");
		this.fila = Teclado.leeEntero();
		System.out.print("Introduce la columna (empiezan por 0 a la izquierda): ");
		this.columna = Teclado.leeEntero();
		
	}

	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
		return this.columna;
	}
	
	
}
