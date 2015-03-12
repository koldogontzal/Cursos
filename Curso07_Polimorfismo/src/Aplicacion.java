
public class Aplicacion {

	private Almacen almacen;
	
	public Aplicacion() {
		this.almacen = new Almacen(20);
	}
	
	
	public static void main(String[] args) {
		Aplicacion app = new Aplicacion();
		app.start();
	}


	public void start() {
		this.almacen.inserta(new DVD("Los Otros", 290));
		this.almacen.inserta(new DVD("Superalgo", 100));
		this.almacen.inserta(new Play("Zelda", "PAL"));
		this.almacen.inserta(new VHS("Los intoclabes", 1980));
		
		
		this.almacen.visualiza();
		
	}

	
	
	
	
}
