package ejemplo03ServidorYCliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorThread extends Thread {
	
	private Socket soc;
	
	public ServidorThread(Socket s) {
		this.soc = s;
	}
	
	@Override
	public void run() {
		super.run();
		
		BufferedReader in;
		try {
			// Leo el texto que me manda el cliente (su nombre)
			in = new BufferedReader(new InputStreamReader(this.soc.getInputStream()));
			String nombre = in.readLine();
			
			// Le hago un retardo para simular la ejecución en el servidor
			Thread.sleep((int)(Math.random() * 2500));
			
			// Devuevlo mi respuesta
			PrintWriter out = new PrintWriter(new OutputStreamWriter(this.soc.getOutputStream()));
			out.println("Eres el cliente " + nombre + "\n");
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
