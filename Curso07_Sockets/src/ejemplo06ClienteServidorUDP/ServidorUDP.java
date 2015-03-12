package ejemplo06ClienteServidorUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP extends Thread {

	private int puerto;
	
	public ServidorUDP(int puerto) {
		this.puerto = puerto;
	}
	
	@Override
	public void run() {
		try {
			/////// Lee lo que manda el cliente			
			// Crea el socket
			DatagramSocket ds = new DatagramSocket(this.puerto, InetAddress.getLocalHost());
			// Crea el DatagramPacket (buffer de lectura)
			byte[] buffer = new byte[1000];
			DatagramPacket dp = new DatagramPacket(buffer, 1000);
			// Espera a ver qué lee
			ds.receive(dp);
			// Escribe lo leído
			byte[] bufferYaEscrito = dp.getData();
			int longitud = dp.getLength();			
			String texto = new String(bufferYaEscrito, 0, longitud);
			System.out.println("[SERVIDOR] Recibido: " + texto);
			// Cierra
			ds.close();
			
			/*
			//////// Contesta al cliente (y en consecuencia el servidor pasa a ser un cliente)
			Thread.sleep(100);
			// Crea el socket
			DatagramSocket ds2 = new DatagramSocket();
			// Crea el DatagramPacket
			texto = "Cliente de pakotilla, soy tu servidor";
			DatagramPacket dp2 = new DatagramPacket(texto.getBytes(), texto.length(), dp.getAddress(), dp.getPort());
			// Lo manda
			ds2.send(dp2);
			// Cierra
			ds2.close();
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
