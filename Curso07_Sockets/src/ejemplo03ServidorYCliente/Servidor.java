package ejemplo03ServidorYCliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {
	
	private ServerSocket ss;
	
	public Servidor(int port) {
		try {
			this.ss = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace(); 
		}		
	}

	@Override
	public void run() {
		super.run();
		try {
			while (true) {
				Socket s = this.ss.accept();
				// Cada petición la ejecuto en un hilo distinto
				ServidorThread st = new ServidorThread(s);
				st.start();
				
			}
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
}
