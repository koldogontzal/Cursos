package j3r;

public class J3R {

	private Jugador[] jugadores = new Jugador[2];
	private Tablero tablero;
	private Turno turno;
	
	public J3R() {
		this.jugadores[0] = new Jugador('O');
		this.jugadores[1] = new Jugador('X');
		this.tablero = new Tablero(3, 3);
		this.turno = new Turno();
	}

	public static void main(String[] args) {
		J3R juego = new J3R();
		juego.jugar();
	}
	
	public void jugar() {
		
		this.jugadores[0].juegasConTablero(this.tablero);
		this.jugadores[1].juegasConTablero(this.tablero);
	
		System.out.println("Comienza el juego!\n");
		
		// Fase de colocar las 6 fichas 
		for (int i = 0; i < 6; i++) {
			this.tablero.pinta();
			this.jugadores[this.turno.getTurno()].pon();
			this.turno.cambia();		
		}
		
		// Fase de mover fichas
		/*
		boolean terminado = false;
		while (!terminado) {
			this.tablero.pinta();
			this.jugadores[this.turno.getTurno()].pon();
			this.turno.cambia();
			
		}
		*/
		
		System.out.println("\nJuego terminado");

	}

}