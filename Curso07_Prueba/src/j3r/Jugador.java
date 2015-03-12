package j3r;

public class Jugador {
	private Tablero tab;
	private char color;
	
	public Jugador() {}
	
	public Jugador(char color) {
		this.color = color;
	}	
	
	// Asociación
	public void juegasConTablero(Tablero t) {
		this.tab = t;
	}
	
	public void pon() {
		System.out.println("Turno del jugador " + this.color + ":");
		
		Coordenada origen = new Coordenada();		
		origen.leeCoordenada();
		
		this.tab.ponFicha(origen, this.color);
		
		
	}
	
}