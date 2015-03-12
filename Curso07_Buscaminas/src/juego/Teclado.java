package juego;

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

}
