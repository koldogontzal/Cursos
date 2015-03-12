package tablero;

import coordenada.Coordenada;

public class Tablero4R extends Tablero {

	public Tablero4R() {
		super(9, 7);
	}
	

	
	public Coordenada dameCoordenadaMasAltaDeColumna(int col) {
		int fila = super.getNumFilas() - 1;
		Coordenada c = new Coordenada(fila, col);
		while (!super.getCasilla(c).vacia()) {
			c.setFila(c.getFila() - 1);
		}
		return c;	
	}

	public boolean buscaGanador(char color) {

		boolean hayGanador = false;
		// Busca lineas horizontales
		int numFichasSeguidas = 0;
		for (int i = 0; i < super.getNumFilas(); i++) {
			for (int j = 0; j < super.getNumColumnas(); j++) {
				Casilla cas = super.getCasilla(new Coordenada(i, j));
				if (cas.vacia()) {
					numFichasSeguidas = 0;
				} else {
					if (cas.getFicha().esDeTipo(color)) {
						numFichasSeguidas++;
					} else {
						numFichasSeguidas = 0;
					}
				}				
				if (numFichasSeguidas == 4) {
					hayGanador = true;
				}
			}
		}
		
		// Busca lineas verticales
		 numFichasSeguidas = 0;
		for (int j = 0; j < super.getNumColumnas(); j++) {
			for (int i = 0; i < super.getNumFilas(); i++) {
				Casilla cas = super.getCasilla(new Coordenada(i, j));
				if (cas.vacia()) {
					numFichasSeguidas = 0;
				} else {
					if (cas.getFicha().esDeTipo(color)) {
						numFichasSeguidas++;
					} else {
						numFichasSeguidas = 0;
					}
				}				
				if (numFichasSeguidas == 4) {
					hayGanador = true;
				}
			}
		}
		// Busca lineas diagonales tipo /
		// TODO Falta hacer esto
		
		// Busca lineas diagonales tipo \		
		// TODO Falta hacer esto
		
		return hayGanador;
	}

}
