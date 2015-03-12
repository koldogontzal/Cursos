package ejercicioMVC;

public class Texto extends Modelo {
	
	private String contenido = "";
	
	public Texto() {
		super();
	}

	public void clear() {
		this.contenido = "";
		// Siempre que cambia algo, tengo que actualizar las vistas
		this.actualizaVistas();
	}

	public void pon(char c) {
		this.contenido += c;
		// Siempre que cambia algo, tengo que actualizar las vistas
		this.actualizaVistas();
		
	}

	@Override
	public String getDatos() {
		return this.contenido;
	}

}
