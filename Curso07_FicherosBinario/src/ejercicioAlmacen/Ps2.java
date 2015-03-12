package ejercicioAlmacen;

public class Ps2 extends Producto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6260559959335277643L;
	private String formato;

	public Ps2(String nombre, String formato) {
		super(nombre);
		this.formato = formato;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Formato: " + this.formato;
	}
}
