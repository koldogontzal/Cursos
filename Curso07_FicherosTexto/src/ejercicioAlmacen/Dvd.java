package ejercicioAlmacen;

import java.io.PrintWriter;

public class Dvd extends Producto {
	
	private int duracion;

	public Dvd(String nombre, int dur) {
		super(nombre);
		this.duracion = dur;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Duración: " + this.duracion + "'";
	}

	
	@Override
	public void grabarDisco(PrintWriter pw) {
		pw.write("DVD\n" + super.getTitulo() + "\n" + this.duracion + "\n");
		
	}

}
