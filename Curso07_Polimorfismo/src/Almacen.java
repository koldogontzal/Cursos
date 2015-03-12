
public class Almacen {
/*
  	// Sin polimorfismo
  	 
  	  
	private DVD[] dvd;
	private int numDvd = 0;
	private Play[] play;
	private int numPlay = 0;
	
	public Almacen(int i) {
		this.dvd = new DVD[i];
		this.play = new Play[i];
	}
	
	public void insertaDVD(DVD d) {
		this.dvd[this.numDvd] = d;
		this.numDvd++;
	}
	
	public void insertaPlay(Play d) {
		this.play[this.numPlay] = d;
		this.numPlay++;
	}
	
	public void visualiza() {
		System.out.println("DVD");
		for (int i=0; i<this.numDvd; i++) {
			System.out.println(this.dvd[i]);
		}
		System.out.println("----------");
		System.out.println("Juegos de Play");
		for (int i=0; i<this.numPlay; i++) {
			System.out.println(this.play[i]);
		}
	}
*/
	// Con Polimorfismo
	
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
			System.out.println(this.productos[i]);
		}
	}
}
