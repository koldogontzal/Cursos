
public class CarteraClientes {
	
	private Cliente[] cartera;
	private int numClientes = 0;
	
	public CarteraClientes(int n) {
		this.cartera = new Cliente[n];
	}
	
	public void inserta(Cliente c) {
		this.cartera[this.numClientes] = c;
		this.numClientes++;
	}
	
	public void visualiza() {
		System.out.println("Clientes");
		for (int i = 0; i < this.numClientes; i++) {
			System.out.println("[" + i + "]" + this.cartera[i] + "\n");
		}
	}

	public Cliente dameCliente(int numCliente) {
		return this.cartera[numCliente];
	}

	public void alquila(int numCliente, Producto p) {
		this.cartera[numCliente].asociaProducto(p);
	}
	

}
