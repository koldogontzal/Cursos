package ejemplo06ClienteServidorUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP extends Thread {
	
	private int puerto;
	
	public ClienteUDP(int puerto) {
		this.puerto = puerto;
		
	}
	
	@Override
	public void run() {
		try {
			
			// EL Cliente primero manda su paquete
			// Crea el socket
			DatagramSocket ds = new DatagramSocket();
			// Crea el DatagramPacket
			String texto = "Hola Mamelukoserver, soy tu cliente";
			DatagramPacket dp = new DatagramPacket(texto.getBytes(), texto.length(),InetAddress.getLocalHost(),this.puerto);
			// Lo manda
			ds.send(dp);			
			// Cierra el socket
			ds.close();
			
			/*
			// Y luego se queda a la espera de la contestación del servidor. Es decir, el cliente pasa a actuar como un servidor...
			// Crea el socket
			DatagramSocket ds2 = new DatagramSocket(this.puerto, InetAddress.getLocalHost());
			// Crea el DatagramPacket (buffer de lectura)
			byte[] buffer = new byte[1000];
			DatagramPacket dp2 = new DatagramPacket(buffer, 1000);
			// Espera a ver qué lee
			ds2.receive(dp2);
			// Escribe lo leído
			byte[] bufferYaEscrito = dp2.getData();
			int longitud = dp2.getLength();			
			texto = new String(bufferYaEscrito, 0, longitud);
			System.out.println("[CLIENTE] Recibido: " + texto);
			// Lo cierra
			ds2.close();
			
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
