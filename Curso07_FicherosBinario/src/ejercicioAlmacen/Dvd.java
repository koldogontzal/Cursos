package ejercicioAlmacen;

public class Dvd extends Producto {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2849937704805284848L;
	private int duracion;

	public Dvd(String nombre, int dur) {
		super(nombre);
		this.duracion = dur;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Duración: " + this.duracion + "'";
	}

}
