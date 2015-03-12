package datagramas;

import gui.PanelMessenger;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteEnvia {
	
	private ListadoNombres listado;
	
	private PanelMessenger pan;
	
	public ClienteEnvia(PanelMessenger p) {
		this.listado = new ListadoNombres();
		this.pan = p;
	}

	public void enviarMensaje(String linea) {
		// Saco la direccion IP (Primera Palabra) y el texto (Resto)
		String[] info = linea.split(" ", 2);
		
		try {
			// Crea el socket
			DatagramSocket ds = new DatagramSocket();
			// Crea la direccion

			//InetAddress dir = InetAddress.getByName(info[0]);
			InetAddress dir = this.listado.get(info[0]);
			if (dir == null) {
				System.out.println("Cliente no v�lido");
				this.pan.agnadirLineaAlVisor("ERROR: Cliente no v�lido");
			} else {
				// Crea el DatagramPacket
				String texto = info[1];
				DatagramPacket dp = new DatagramPacket(texto.getBytes(), texto.length(), dir, ServidorEscucha.PUERTO);
				// Lo manda
				ds.send(dp);
			}
			// Cierra el socket
			ds.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
