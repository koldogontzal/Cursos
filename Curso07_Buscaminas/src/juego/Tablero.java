package juego;

public class Tablero {
	
	private Casilla[][] casillas;
	
	public Tablero(int filas, int columnas) {
		
		this(filas, columnas, .2);
	}
	
	public Tablero(int filas, int columnas, double probBombas) {		
		this.casillas = new Casilla[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				this.casillas[i][j] = new Casilla();
				if (Math.random() < probBombas) {
					this.casillas[i][j].ponBomba();
				}
			}
		}
		
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
