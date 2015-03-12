package teoria;

public class Cajero extends Empleado {

	private int horas_extras;
	
	public void abreCaja() {}
	
	
	public void acceso() {
		
		// Acceso a atributos publicos:		
		antiguedad = 17; // Estas tres formas
		this.antiguedad = 15; // Son equivalentes
		super.antiguedad = 10; // Pero con "super" es m�s correcto
		
		// Aceso a atributos protegidos:
		super.departmento = "kkk";
		// (Tambi�n es v�lido acceder con "this" o sin nada...)
		this.departmento = "lll";
		departmento = "olikju";
		
		
		// NUNCA podemos acceder a lo privado, a pesar de s� tenerlo por haberlo heredado...
		// super.categoria = "junior";
		// ( Da error siempre)
		
		
		// Con los m�todos ocurre igual si es publico, protected o private
		
		
		// Con los atributos y m�todos propios, el funcionamiento es como siempre:
		this.horas_extras = 14;
		this.abreCaja();
		
		
		}
		
		// Se puede redefinir m�todos
		public void metodoPublico() {
			System.out.println("Cajero" + this.horas_extras);
			
		}
		
		// Constructor
		public Cajero () {
			super(); // Primero -si quiero- llamo al constructor del padre. 
			// NUNCA hay que hacer algo del estilo "super.antiguedad = 5"
			this.horas_extras = 5;
			
		}
		
		public Cajero(int a, String str) {
			super(a);
			this.departmento = str;
		}

	
	
}
