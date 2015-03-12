
public class Videoclub {
	
	private Almacen almacen;
	private CarteraClientes cartera;
	
	public Videoclub() {
		this.almacen = new Almacen(100);
		this.cartera = new CarteraClientes(100);
	}

	public static void main(String[] args) {
		Videoclub vc = new Videoclub();
		vc.inicializaDatosFijos();
		vc.start();
	}
	
	

	private void inicializaDatosFijos() {
		this.cartera.inserta(new Socio("Luis", "3344Z", "1897-2346"));
		this.cartera.inserta(new Socio("Pepe", "4693W", "1897-2346"));
		this.cartera.inserta(new NoSocio("Montse", "1234Z"));
		this.cartera.inserta(new NoSocio("Alfred", "2215B"));
		
		this.almacen.inserta(new DVD("Saturno contro", 3, 105));
		this.almacen.inserta(new DVD("The bubble", 1, 85));
		this.almacen.inserta(new Play("Resident evil 4", 2, "PAL"));
		this.almacen.inserta(new Revista("ZERO", 10, true));
		this.almacen.inserta(new Revista("MENSual", 10, false));
		
	}

	public void start() {
		int opcion = 0;
		do {
			Menu.menuPpal();
			System.out.print("\nDime una opción: ");
			opcion = Teclado.leeInt();
			this.procesaOpcion(opcion);
		} while (opcion != 0);
	}

	private void procesaOpcion(int opcion) {
		switch(opcion) {
			case 0:
				break;
			case 1: // Listado
				this.listarClientes();
				break;
			case 2: //
				this.listarProductos();
				break;
			case 3: //
				this.alquiler();
				break;
			case 4: //
				this.listarProductosAlquilados();
				break;
			case 5: //
				break;
			case 6: //
				break;
			case 7: //
				break;
			case 8: //
				break;
			default:
				System.out.println("Opcion no válida");
		
		}
		
	}

	private void listarProductosAlquilados() {
		this.almacen.listarProductosAlquilados();
		
	}

	private void alquiler() {
		System.out.println("Proceso de alquiler:");
		System.out.print("Dime el número de cliente: ");
		int numCliente = Teclado.leeInt();
		System.out.print("Dime el número de producto: ");
		int numProducto = Teclado.leeInt();
				
		Cliente c = this.cartera.dameCliente(numCliente);
		Producto p = this.almacen.dameProducto(numProducto);
		
		this.cartera.alquila(numCliente, p);
		this.almacen.alquila(numProducto, c);
		
	}

	private void listarProductos() {
		this.almacen.visualiza();
		
	}

	private void listarClientes() {
		this.cartera.visualiza();
		
	}

}
