
public class DVD extends Producto {
	
	private int duracion;
	
	public DVD() {
		super();
		this.duracion = 0;
	}
	
	public DVD(String t, int numCopias, int d) {
		super(t, numCopias);
		this.duracion = d;
	}

	public String toString() {
		return "DVD " + super.toString() + "\nDuración: " + this.duracion;
	}
	
}
