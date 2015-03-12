package jugador;

import ficha.Ficha;

public class Jugador {
	private char color;
	private Ficha[] fichas;
	
	public Jugador(int numFichas, char color) {
		this.color = color;
		
		this.fichas = new Ficha[numFichas];
		for (int i = 0; i < numFichas; i++) {
			this.fichas[i] = new Ficha(color);
		}
	}
	
	public char getColor() {
		return this.color;
	}
	
	public Ficha dameFicha(int num) {
		return this.fichas[num];
	}
}
