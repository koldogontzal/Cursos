package ejercicioAlmacen;



public class Aplicacion {
	
	private Almacen almacen;
	
	public Aplicacion() {
		this.almacen = new Almacen(100);		
	}
	
	public static void main(String[] args) {
		Aplicacion app = new Aplicacion();
		app.comienza();
	}
	
	public void comienza() {
		boolean salir = false;
		while (!salir) {
			// imprimir menu
			this.imprimeMenu();
			
			// leer opci�n
			System.out.print("�Opci�n? ");
			int op = Teclado.leeEntero();
			
			// ejecutar opci�n
			switch (op) {
			case 1: // Alta de producto
				Producto p = Teclado.leeProducto();
				this.almacen.agnadirProducto(p);
				break;
			case 2: // Borrar ultimo producto
				this.almacen.borrarUltimoProducto();
				break;
			case 3: // Listar productos
				System.out.println("\nListado de productos:\n" + this.almacen);
				break;
			case 4: // Grabar en fichero
				System.out.println("Dame el nombre del archivo (se sobreescribiran los datos): ");
				String ficheroStrGuardar = Teclado.leeString();
				this.almacen.grabarDisco(ficheroStrGuardar);
				break;
			case 5: // Leer en fichero
				System.out.println("Dame el nombre del archivo: ");
				String ficheroStrLectura = Teclado.leeString();
				this.almacen.leerDisco(ficheroStrLectura);
				break;
			case 6: // Salir
				salir = true;				
			}
		}
	}
	
	public void imprimeMenu() {
		System.out.println("\tMENU\n\t====\n\n");
		System.out.println("\t1.- Alta de producto");
		System.out.println("\t2.- Borrar ultimo producto");
		System.out.println("\t3.- Listar productos");
		System.out.println("\t4.- Grabar fichero");
		System.out.println("\t5.- Leer fichero");
		System.out.println("\t6.- Salir");
	}

}
