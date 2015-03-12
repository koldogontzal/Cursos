

import java.io.*;

public class Teclado {
	
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static int leeInt() {
		int valor = -1;
		
		while (valor == -1) {
			
				String cadena;
				try {
					cadena = in.readLine();
					valor = Integer.parseInt(cadena);

				} catch (IOException e) {
					System.out.println("Error de teclado. Vuelve a intentarlo");
				}
				
		}
		
		return valor;
	}

}
