
public class Almacen {
	private Producto[] productos;
	private int numProductos = 0;
	
	public Almacen(int i) {
		this.productos = new Producto[i];		
	}
	
	public void inserta(Producto p) {
		this.productos[this.numProductos] = p;
		this.numProductos++;
	}
	
	public void visualiza() {
		System.out.println("Productos");
		for (int i = 0; i < this.numProductos; i++) {
			System.out.println("[" + i + "]" + this.productos[i] + "\n");
		}
	}

	public Producto dameProducto(int numProducto) {
		return this.productos[numProducto];
	}

	public void alquila(int numProducto, Cliente c) {
		this.productos[numProducto].asociaCliente(c);
	}

	public void listarProductosAlquilados() {
		for (int i = 0; i < this.numProductos; i++) {
			// TODO
		}
		
	}

}
