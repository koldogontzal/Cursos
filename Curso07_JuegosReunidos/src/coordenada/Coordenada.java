package coordenada;

public class Coordenada {
	private int fila;
	private int columna;
	
	public Coordenada() {
		this(0,0);
	}
	
	public Coordenada(int f, int c) {
		this.fila = f;
		this.columna = c;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public int getColumna() {
		return this.columna;
	}

	public void setFila(int i) {
		this.fila = i;
		
	}

	public Coordenada mediaCon(Coordenada destino) {
		int filaMedia = (this.fila + destino.getFila()) / 2;
		int colMedia = (this.columna + destino.getColumna()) / 2;
		return new Coordenada(filaMedia, colMedia);
	}

}
