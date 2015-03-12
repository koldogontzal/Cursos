package ejemplo03ServidorYCliente;

public class Aplicacion {
	
	public static final int PUERTO_SERVIDOR = 9004;
	
	
	public static void main(String[] args) {
		Servidor ser = new Servidor(PUERTO_SERVIDOR);
		ser.start();
		
		Cliente[] cli = new Cliente[15];
		for (int i = 0; i < cli.length; i++) {
			cli[i] = new Cliente("Número_" + i, PUERTO_SERVIDOR);
			cli[i].start();
		}
	}

}
