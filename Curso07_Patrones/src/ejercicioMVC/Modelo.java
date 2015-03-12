package ejercicioMVC;

public abstract class Modelo {
	
	/// Asociacion
	private Vista[] vistas = new Vista[4];
	private int n = 0;
	public void asocia(Vista v) {
		this.vistas[this.n] = v;
		this.n++;
	}
	/////////////
	
	public Modelo() {
		
	}
	
	public void actualizaVistas() {
		// Tengo que recorrer tdas las vistas y acctualizarlas
		for (int i = 0; i < 4; i++) {
			this.vistas[i].actualiza();
		}
	}
	
	public abstract void pon(char c);
	
	public abstract void clear();

	public abstract String getDatos();

}
