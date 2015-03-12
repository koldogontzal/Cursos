
public class VHS extends Producto {

	private int year;
	
	public VHS() {
		super();
		this.year = 0;
	}
	
	public VHS(String t, int year) {
		super(t);
		this.year = year;
	}
	
	public String toString() {
		return super.toString() + "\nAño: " + this.year;
	}
	
}
