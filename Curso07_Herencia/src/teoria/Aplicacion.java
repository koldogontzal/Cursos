package teoria;

public class Aplicacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cajero c = new Cajero();
		c.metodoPublico(); // Sin problemas
		c.metodoProtegido(); /* En este caso puedo acceder a lo protegido, porque estoy DENTRO
		 						del mismo paquete. Si no fuese as�, no dejaria y petar�a tambi�n
		 					*/
		//c.metodoPrivado(); // No deja NUNCA acceder a esto
	}

}
