package ejerciciosObjetos;

import java.io.Serializable;

public class Persona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1690648254260709972L;
	private Coche coche;
	private String Nombre;
	
	public Persona(String n) {
		this.Nombre = n;
		this.coche = null;
	}
	
	public void asociaCoche(Coche c) {
		this.coche = c;
	}
	
	@Override
	public String toString() {
		String str;
		if (this.coche == null) {
			str = "";
		} else {
			str = this.coche.toString();
		}
		return "NOMBRE: " + this.Nombre + "\n" + str;
	}

}
