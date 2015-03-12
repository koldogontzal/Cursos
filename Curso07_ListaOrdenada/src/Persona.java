
public class Persona extends Dato {

	private int edad;
	private String nombre;
	
	public Persona(int e, String n) {
		this.edad = e;
		this.nombre = n;
	}
	
	public int getEdad() {return this.edad;}
	
	@Override
	public int compareTo(Object arg0) {
		// Como estamos en la clase Persona, hago el casting a Persona y está bien
		
		// Comparar la edad
		//Integer e = new Integer(this.edad);
		//Integer cc = new Integer(((Persona)arg0).getEdad());
		//return e.compareTo(cc);
		
		// Comparar el nombre
		return this.nombre.compareTo(((Persona)arg0).nombre);
	}
	
	@Override
	public String toString() {
		return "NOMBRE: " + this.nombre + ", EDAD: " + this.edad;
	}

	@Override
	public boolean equals(Object arg0) {
		Persona p = (Persona)arg0;
				
		return ((this.edad == p.getEdad()) && (this.nombre.equals(p.nombre)));
	}
}
