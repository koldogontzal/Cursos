package ficha;

public class Ficha {

	private char f;
	
	public Ficha(char c) {
		this.f = c;
	}
	
	public boolean esDeTipo(char c) {
		return (this.f == c);
	}
	
	@Override
	public String toString() {
		return "" + this.f;
	}
}
