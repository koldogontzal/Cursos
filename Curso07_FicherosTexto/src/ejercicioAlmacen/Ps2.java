package ejercicioAlmacen;

import java.io.PrintWriter;

public class Ps2 extends Producto {
	
	private String formato;

	public Ps2(String nombre, String formato) {
		super(nombre);
		this.formato = formato;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Formato: " + this.formato;
	}

		
	@Override
	public void grabarDisco(PrintWriter pw) {
		pw.write("PS2\n" + super.getTitulo() + "\n" + this.formato  + "\n");
		
	}

}
