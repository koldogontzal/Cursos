package j3r;

public class Turno {
	private int valor;
	
	public Turno() {
		this.valor = (Math.random() < 0.5 ? 0 : 1);
	}
	
	public int getTurno() {
		return this.valor;
	}
	
	public void cambia() {
		this.valor = (this.valor + 1) % 2;
	}
}