package teclado;

import java.io.*;

import coordenada.Coordenada;

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
	
	public static Coordenada leeCoordenada() {
		System.out.print("  Introduce la fila: ");
		int fila = Teclado.leeEntero();
		System.out.print("  Introduce la columna: ");
		int columna = Teclado.leeEntero();
		return new Coordenada(fila, columna);
		
	}

}
