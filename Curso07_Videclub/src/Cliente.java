
public class Cliente {

	private String nombre;
	private String dni;
	
	private Producto[] productos;
	private int numProductos = 0;
	
	private static final int NUM_MAX_ALQUILERES = 5;
	
	public Cliente(String n, String d) {
		this.nombre = n;
		this.dni = d;
		
		this.productos = new Producto[NUM_MAX_ALQUILERES];
	}
	
	public void asociaProducto(Producto p) {
		if (this.numProductos < NUM_MAX_ALQUILERES) {
			this.productos[this.numProductos] = p;
			this.numProductos++;
		} else {
			System.out.println("ERROR: El cliente ha alcanzado el límite de alquileres");
		}
	}
	
	public String toString() {
		return "Nombre: " + this.nombre + "\nDNI: " + this.dni;
	}

	
}
