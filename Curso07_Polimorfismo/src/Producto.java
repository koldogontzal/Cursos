
public class Producto {
	
	private String titulo;
	
	public Producto() {
		this.titulo = "";
	}
	
	public Producto(String titulo) {
		this.titulo = titulo;
	}
	
	public String toString() {
		return "Título: " + this.titulo;
	}

}
