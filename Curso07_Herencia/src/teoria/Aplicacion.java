package teoria;

public class Aplicacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cajero c = new Cajero();
		c.metodoPublico(); // Sin problemas
		c.metodoProtegido(); /* En este caso puedo acceder a lo protegido, porque estoy DENTRO
		 						del mismo paquete. Si no fuese así, no dejaria y petaría también
		 					*/
		//c.metodoPrivado(); // No deja NUNCA acceder a esto
	}

}
