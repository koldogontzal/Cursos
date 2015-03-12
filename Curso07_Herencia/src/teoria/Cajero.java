package teoria;

public class Cajero extends Empleado {

	private int horas_extras;
	
	public void abreCaja() {}
	
	
	public void acceso() {
		
		// Acceso a atributos publicos:		
		antiguedad = 17; // Estas tres formas
		this.antiguedad = 15; // Son equivalentes
		super.antiguedad = 10; // Pero con "super" es más correcto
		
		// Aceso a atributos protegidos:
		super.departmento = "kkk";
		// (También es válido acceder con "this" o sin nada...)
		this.departmento = "lll";
		departmento = "olikju";
		
		
		// NUNCA podemos acceder a lo privado, a pesar de sí tenerlo por haberlo heredado...
		// super.categoria = "junior";
		// ( Da error siempre)
		
		
		// Con los métodos ocurre igual si es publico, protected o private
		
		
		// Con los atributos y métodos propios, el funcionamiento es como siempre:
		this.horas_extras = 14;
		this.abreCaja();
		
		
		}
		
		// Se puede redefinir métodos
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
