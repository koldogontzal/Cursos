// Pasar excepciones para arriba

public class Ejemplo2 {

	public static void main(String[] args) {
		try {
			Ejemplo2.print();
		} catch (ArithmeticException e) {
			System.out.println("Division por cero");
		}
	}

	private static void print() throws ArithmeticException {
		Ejemplo2.lista();
	}
	
	private static void lista() throws ArithmeticException {
		int a=2, b=0;
		System.out.println(a/b);
	}
	
	
}
