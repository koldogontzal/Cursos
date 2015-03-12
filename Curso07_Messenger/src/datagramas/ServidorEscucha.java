package datagramas;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import gui.PanelMessenger;

public class ServidorEscucha extends Thread {
	
	private PanelMessenger pan;
	private ListadoNombres listado;
	
	public static final int PUERTO = 9000; 
	
	public ServidorEscucha(PanelMessenger p) {
		this.pan = p;
		this.listado = new ListadoNombres();
	}

	@Override
	public void run() {
		super.run();
		while (true) {			
			try {
				
				// Crea el socket
				DatagramSocket ds = new DatagramSocket(PUERTO);
				// Crea el DatagramPacket (buffer de lectura)
				byte[] buffer = new byte[1000];
				DatagramPacket dp = new DatagramPacket(buffer, 1000);
				// Espera a ver qu� lee
				ds.receive(dp);
				// Saca la direccion de origen
				String dir = this.listado.getInverso(dp.getAddress());
				// Escribe lo le�do
				byte[] bufferYaEscrito = dp.getData();
				int longitud = dp.getLength();			
				String texto = new String(bufferYaEscrito, 0, longitud);
				this.pan.agnadirLineaAlVisor(dir + " dice: " + texto);
				// Cierra
				ds.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
}
