package ejemplo04ServidorYClienteUsandoSerialized_NoFunciona;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
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
			// Leo el objeto
			ObjectInputStream ois = new ObjectInputStream(this.soc.getInputStream());
			Objeto obj = (Objeto)ois.readObject();
			in.close();
			ois.close();
	
			
			// Le hago un retardo para simular la ejecución en el servidor
			Thread.sleep((int)(Math.random() * 2500));
			
			// Devuevlo mi respuesta
			PrintWriter out = new PrintWriter(new OutputStreamWriter(this.soc.getOutputStream()));
			out.println("Eres el cliente " + nombre + "\n");
			out.println("Tengo " + obj.getNumElementos() + " elementos y el primero es el " + obj.getElemento(0));
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
