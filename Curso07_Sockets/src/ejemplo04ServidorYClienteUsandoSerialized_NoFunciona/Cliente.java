package ejemplo04ServidorYClienteUsandoSerialized_NoFunciona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente extends Thread {
	
	private String nombre;
	private Socket soc;
	
	public Cliente(String nombre, int port) {
		this.nombre = nombre;
		try {
			this.soc = new Socket("localhost", port);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	@Override
	public void run() {
		super.run();		
		// Manda datos
		this.mandarDatos();
		// Leer datos
		this.leerRespuesta();
		// Cierra el socket
		try {
			this.soc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void leerRespuesta() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(this.soc.getInputStream()));
			String resultado = in.readLine();
			System.out.println(resultado);
			String numElementos = in.readLine();
			System.out.println(numElementos);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void mandarDatos() {
		try {
			// Escribo un nombre
			PrintWriter out = new PrintWriter(new OutputStreamWriter(this.soc.getOutputStream()));
			out.println("" + this.nombre + "\n");
			out.flush();
			// Escribo un objeto
			ObjectOutputStream oos = new ObjectOutputStream(this.soc.getOutputStream());
			oos.writeObject(new Objeto());			
			oos.flush();
			out.close();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
