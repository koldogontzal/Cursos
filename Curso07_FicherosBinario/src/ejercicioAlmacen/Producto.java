package ejercicioAlmacen;

import java.io.Serializable;

public abstract class Producto implements Serializable {
	
	private String titulo;
	
	public Producto(String nombre) {
		this.titulo = nombre;
	}
	
	@Override
	public String toString() {
		return "Título: \"" + this.titulo + "\"";
	}
	
	public String getTitulo() {
		return this.titulo;
	}
}
