package ejemplo06ClienteServidorUDP;

public class Aplicacion {

	private static final int PUERTO = 5000;

	public static void main(String[] args) {
		ServidorUDP serv = new ServidorUDP(PUERTO);
		serv.start();
		
		try {
			// Para que se arranque antes el servidor le hago esperar
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		ClienteUDP clie = new ClienteUDP(PUERTO);
		clie.start();
	}

}
