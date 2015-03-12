package tablero;

import coordenada.Coordenada;
import ficha.Ficha;

public class Tablero {
	
	private Casilla[][] casillas;
	
	private int numFilas;
	private int numColumnas;
	
	public Tablero(int fil, int col) {
		this.casillas = new Casilla[fil][col];
		this.numFilas = fil;
		this.numColumnas = col;
		
		for (int i = 0; i < fil; i++) {
			for (int j = 0; j < col; j++) {
				this.casillas[i][j] = new Casilla();
			}
		}		
	}
	
	public void ponFicha(Coordenada c, Ficha f) {
		this.casillas[c.getFila()][c.getColumna()].asociaFicha(f);		
	}
	
	public String toString() {
		String separador = "";
		for (int i = 0; i < (this.numColumnas * 2 + 1); i++) {
			separador = separador + "-";
		}
		separador = separador + "\n";
		
		String res = "   COLUMNA\n  ";
		for (int i = 0; i < this.getNumColumnas(); i++) {
			res = res + " " + i;
		}
		res = res + "\n  " + separador;

		for (int i = 0; i < this.numFilas; i++) {
			res = res + i + " ";
			for (int j = 0; j < this.numColumnas; j++) {				
				res = res + "|" + this.casillas[i][j];
			}
			res = res + "|\n";
			res = res + "  " +separador;
		}
		
		return res;
	}

	public int getNumColumnas() {
		return this.numColumnas;
	}

	public int getNumFilas() {
		return this.numFilas;
	}

	public Casilla getCasilla(Coordenada c) {
		return this.casillas[c.getFila()][c.getColumna()];
	}
}
