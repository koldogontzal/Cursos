package j3r;

public class Casilla {
	private char contenido;
	
	public Casilla() {}
	
	public Casilla(char c) {
		this.contenido = c;
	}
	
	public void pinta() {
		System.out.print(this.contenido);
	}

	public void ponFicha(char color) {
		this.contenido = color;
	}
}