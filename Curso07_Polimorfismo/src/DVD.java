
public class DVD extends Producto {
	
	private int duracion;
	
	public DVD() {
		super();
		this.duracion = 0;
	}
	
	public DVD(String t, int d) {
		super(t);
		this.duracion = d;
	}

	public String toString() {
		return super.toString() + "\nDuración: " + this.duracion;
	}
	
}
