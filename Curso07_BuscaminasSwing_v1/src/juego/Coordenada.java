package juego;

public class Coordenada {
	private int fila;
	private int columna;
	
	public Coordenada() {}
	
	public Coordenada(int i, int j) {
		this.fila = i;
		this.columna = j;
	}

	
	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
		return this.columna;
	}
	
	
}
