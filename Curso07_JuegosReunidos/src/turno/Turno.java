package turno;

public class Turno {
	
	private int numMaxJugadores;
	private int turno = 0;
	
	public Turno(int numMaxJug) {
		this.numMaxJugadores = numMaxJug;
	}
	
	public int getTurno() {
		return this.turno;
	}
	
	public void cambiaTurno() {
		this.turno = (this.turno + 1) % this.numMaxJugadores;
	}
	
}
