
public class Revista extends Producto {

	private boolean color;
	
	public Revista() {
		super();
		this.color  = false;
	}
	
	public Revista(String t, int numCopias, boolean color) {
		super(t, numCopias);
		this.color = color;
	}
	
	public String toString() {
		return "Revista " + super.toString() + "\n" + (this.color ? "Color" : "B/N");
	}
	
}
