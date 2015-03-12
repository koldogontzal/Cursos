
public class Producto {
	
	private String titulo;
	private int numCopias = 1;
	
	private Cliente[] clientes;
	private int numClientes = 0;
	
	public Producto() {
		this.titulo = "";
	}
	
	public Producto(String titulo, int numCopias) {
		this.titulo = titulo;
		this.numCopias = numCopias;
		
		this.clientes = new Cliente[numCopias];
	}
	
	public void asociaCliente(Cliente c) {
		if (numCopias > 0) {
			this.clientes[this.numClientes] = c;
			this.numClientes++;
			this.numCopias--;
		} else {
			System.out.println("ERROR: No hay productos disponibles, están todos alquilados");
		}

	}
	
	public String toString() {
		return "Título: " + this.titulo + " (hay " + this.numCopias + "copia(s))";
	}

}
