// Ejemplo de como se usa el bloque try / catch

public class Ejemplo1 {

	public static void main(String[] args) {
		int a = 2;
		int[] b = {1, 0};
		try {
			System.out.println(a/b[8]);	
			System.out.println("Yo ya no salgo, porque b vale 0");
		} catch (ArithmeticException e) {
			System.out.println("Error");
		} catch (Exception e2) {
			System.out.println("Sólo se trata UNA excepción, por aquí no entraría nunca");
			System.out.println("Por eso hay que ponerlas en orden de la mas especifica a la mas general");
		} finally {
			// Se ejecuta SIEMPRE, ocurra o no la excepcion
			System.out.println("Finally: Siempre, siempre, siempre se ejecuta esto");
			
		}
		
		System.out.println("Esto es el FIN, que sí se ejecuta");
		System.out.println("Aunque no sería así si en algún catch genero otra excepción");
	}
	
}
