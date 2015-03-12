import java.io.IOException;

// Crear mi propia excepcion (no tiene que hacerse en el mismo fichero, ojo, solo es para juntarlo todo)

public class Ejemplo3 {
	
	public static void main(String[] args) throws MiException, IOException {
		int a=2, b=0;
		
		try {
			System.out.println(a/b);
		} catch (ArithmeticException e) {
			throw new MiException();
		}
	}
}

class MiException extends Exception {

	private static final long serialVersionUID = -3189943510936913381L;

	public MiException() {
		super("Se te fue el pincel: Dividiste por ZERO");
	}
}