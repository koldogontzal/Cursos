package ejemplo01Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Aplicacion {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("www.google.com", 80);
		
		// Hace petición al servidor
		PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		out.println("GET /index.html HTTP/1.1\n\n");
		out.flush();
		
		//Lee
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String resultado;
		while ((resultado = in.readLine()) != null) {
			System.out.println(resultado);
		}
		
		System.out.println("Mameluko");
		s.close();
	}

}
