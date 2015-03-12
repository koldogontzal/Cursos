
public class Play extends Producto {

	private String formato;
	
	public Play() {
		super();
		this.formato = "";
	}
	
	public Play(String t, String f) {
		super(t);
		this.formato = f;
	}
	
	public String toString() {
		return super.toString() + "\nFormato: " + this.formato;
	}
	
}
