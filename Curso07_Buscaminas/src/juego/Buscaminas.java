package juego;

public class Buscaminas {

	/**
	 * @param args
	 */
	private Jugador jug;
	private Tablero tab;
	
	public Buscaminas() {
		this.jug = new Jugador();
		this.tab = new Tablero(10, 25, .1);
	}
	
	public static void main(String[] args) {
		Buscaminas b = new Buscaminas();
		b.jugar();

	}

	private void jugar() {
		this.jug.asociaTablero(this.tab);
		
		while (true) {
			this.tab.visualiza();
			this.jug.levanta();			
		}
		
	}

}
