package ejercicioMVC;

import javax.swing.JFrame;

public abstract class Vista extends JFrame {
	
	// Asociación
	private Modelo mod;
	public void asociaModelo(Modelo m) {
		this.mod = m;
	}
	////////////////
	
	public Vista() {
		super();
	}

	public void actualiza() {
		this.visualiza(this.mod);
	}
	
	public abstract void visualiza(Modelo m);

	//// Asociacion con Controlador
	public abstract void asociaControlador(Controlador controlador);	

}
