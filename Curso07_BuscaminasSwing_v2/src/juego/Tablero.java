package juego;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Tablero extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8307428182780207468L;
	private Casilla[][] casillas;
		
	public Tablero(int filas, int columnas, int numBombasTotal) {
		super();
		
		this.casillas = new Casilla[filas][columnas];
		
		// Crea las casillas
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.casillas[i][j] = new Casilla(this, new Coordenada(i,j));
				
			}
		}
		
		// Crea las bombas
		int bombasPuestas = 0;
		while (bombasPuestas < numBombasTotal) {
			int fil = (int)(Math.random() * filas);
			int col = (int)(Math.random() * columnas);
			
			if (!this.casillas[fil][col].tienesBomba()) {
				this.casillas[fil][col].ponBomba();
				bombasPuestas++;
			}
		}
		
		// Calcula el numero de bombas por casilla
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (!this.casillas[i][j].tienesBomba()){
					int numBombas = 0;
					for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, filas); k++) {
						for (int l = Math.max(j - 1, 0); l < Math.min(j + 2, columnas); l++) {
							if (this.casillas[k][l].tienesBomba())
								numBombas++;
						}
					}
					this.casillas[i][j].setNumBombas(numBombas);
				}
			}
		}
		
		// Crea el panel y asocia las casillas
		GridLayout layout = new GridLayout(filas, columnas);
		this.setLayout(layout);
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.add(this.casillas[i][j]);
			}
		}		
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		
		int filas = this.casillas.length;
		int columnas = this.casillas[0].length;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.casillas[i][j].setEnabled(enabled);
			}
		}	
		
	}
	
	public void visualiza() {
		int filas = this.casillas.length;
		int columnas = this.casillas[0].length;
		
		String borde = "";
		for (int i = 0; i < columnas + 2; i++) {
			borde = borde + "-";
		}
		System.out.println(borde);
		for (int i = 0; i < filas; i++) {
			System.out.print("|");
			for (int j = 0; j < columnas; j++) {
				this.casillas[i][j].visualiza();
			}
			System.out.println("|");
		}
		System.out.println(borde);
	}

	public void levanta(Coordenada c) {
		int i = c.getFila();
		int j = c.getColumna();
		int filas = this.casillas.length;
		int columnas = this.casillas[0].length;
		
		if (this.casillas[i][j].tienesBomba()) {
			this.terminaJuego();
		} else {			
			this.casillas[i][j].levanta();
			if (this.casillas[i][j].agua()) {
				for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, filas); k++) {
					for (int l = Math.max(j - 1, 0); l < Math.min(j + 2, columnas); l++) {
						if ((k == i) && (l == j)) {
							// no hace nada
						} else {
							if (!this.casillas[k][l].estaLevantada()) {
								Coordenada nc = new Coordenada(k, l);
								this.levanta(nc);
							}
						}
					}
				} 
			}		
		}
	}
	
	private void terminaJuego() {
		
		int filas = this.casillas.length;
		int columnas = this.casillas[0].length;
		
		// Mostrar bombas
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.casillas[i][j].muestraBomba();
				this.casillas[i][j].setEnabled(false);
			}
		}		
	}

}
