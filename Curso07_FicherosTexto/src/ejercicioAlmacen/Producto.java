package ejercicioAlmacen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Producto {
	
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
	
	public static Producto leerDisco(BufferedReader br) {		
		Producto p = null;
		
		String tipo;
		try {
			tipo = br.readLine();
			if (tipo != null) {
				String titulo = br.readLine();			
				if (tipo.equals("DVD")) {
					int dur = Integer.parseInt(br.readLine());
					p = new Dvd(titulo, dur);
					
				} else if (tipo.equals("PS2")){
					// Es un disco de PS2
					String form = br.readLine();
					p = new Ps2(titulo, form);
				} else {
					System.out.println("Formato de archivo de datos erróneo");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		
		return p;
	}

	public abstract void grabarDisco(PrintWriter pw);

}
