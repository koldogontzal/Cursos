
public class Play extends Producto {

	private String formato;
	
	public Play() {
		super();
		this.formato = "";
	}
	
	public Play(String t, int numCopias, String f) {
		super(t, numCopias);
		this.formato = f;
	}
	
	public String toString() {
		return "Juego play " + super.toString() + "\nFormato: " + this.formato;
	}
	
}
