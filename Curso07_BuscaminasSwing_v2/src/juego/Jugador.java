package juego;

public class Jugador {

	private Tablero tablero;
	
	public void levanta() {
		Coordenada c = new Coordenada();
		c.leeCoordenada();
		this.tablero.levanta(c);
	}

	public void asociaTablero(Tablero tab) {
		this.tablero = tab;
	}
	
	
}
