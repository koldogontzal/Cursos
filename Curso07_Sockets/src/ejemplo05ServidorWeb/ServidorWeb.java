package ejemplo05ServidorWeb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorWeb {
	
	public static final int PUERTO_ESCUCHA = 8080;
	
	private ServerSocket ss;
	
	public ServidorWeb(int port) {
		try {
			this.ss = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace(); 
		}		
	}
	
	public void arrancar() {
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

	public static void main(String[] args) {
		ServidorWeb servidor = new ServidorWeb(PUERTO_ESCUCHA);
		servidor.arrancar();
	}
}
