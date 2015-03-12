package ejercicioAlmacen;

import java.io.*;

public class Teclado {
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static int leeEntero() {
		int valor = -1;
		
		while (valor == -1) {
			try {
				String cadena = in.readLine();
				valor = Integer.parseInt(cadena);
			} catch (IOException e) {
				System.out.println("Error al leer del teclado");
				e.printStackTrace();
			}
		}
		
		return valor;
	}
	
	public static String leeString() {
		String valor = "";
		
			try {
				valor = in.readLine();
			} catch (IOException e) {
				System.out.println("Error al leer del teclado");
				e.printStackTrace();
			}
				
		return valor;
	}
	
	public static Producto leeProducto() {
		Producto p = null;
		System.out.print("¿Qué tipo de producto quiere introducir?\n\t[1]DVD\n\t[2]PS2\nElija opción: ");
		int op = Teclado.leeEntero();
		System.out.print("¿Título? ");
		String tit = Teclado.leeString();
		switch (op) {
		case 1: // Es un DVD
			System.out.print("¿Duración en minutos? ");
			int dur = Teclado.leeEntero();
			p = new Dvd(tit, dur);
			break;
		case 2: // Es un juego PS2
			System.out.print("¿Tipo de formato? ");
			String form = Teclado.leeString();
			p = new Ps2(tit, form);
			break;			
		}
		
		return p;
	}

}
