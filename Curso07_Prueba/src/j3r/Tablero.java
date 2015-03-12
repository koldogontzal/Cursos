package j3r;

public class Tablero {
	private Casilla[][] casillas;
	
	public Tablero() {
		this(3,3);
	}
	
	public Tablero(int f, int c) {
		this.casillas = new Casilla[f][c];
		for (int i = 0; i < f; i++)
			for (int j = 0; j < c; j++)
				this.casillas[i][j] = new Casilla(' ');
	}
	
	public void pinta() {
		
		System.out.println("\n");
		String lineaGuiones = "";
		for (int i = 0; i < (2 * this.casillas[0].length + 1); i++)
			lineaGuiones = lineaGuiones + "-";
		
		for (int i = 0; i < this.casillas.length; i++) {
			System.out.println(lineaGuiones);
			for (int j = 0; j < this.casillas[i].length; j++) {
				System.out.print("|");
				this.casillas[i][j].pinta();
			}
			System.out.println("|");
		}
		System.out.println(lineaGuiones);
	}

	public void ponFicha(Coordenada c, char color) {
		int fila = c.getFila();
		int columna = c.getColumna();

		this.casillas[fila][columna].ponFicha(color);
	}
}