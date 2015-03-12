package ejercicioMVC;

public class Aplicacion {

	private Vista[] vistas;
	
	private Modelo modelo;
	
	private Controlador controlador;
	
	public Aplicacion() {
		// Vistas
		this.vistas = new Vista[4];
		this.vistas[0] = new VCT();
		this.vistas[1] = new VCL();
		this.vistas[2] = new CVL();
		this.vistas[3] = new VCD();
		
		// Modelo (Datos)
		this.modelo = new Texto();
		
		// Asociar los datos a las 3 vistas
		for (int i = 0; i < 4; i++) {
			this.vistas[i].asociaModelo(this.modelo);
		}
				
		// Asociar cada vista al dato
		for (int i = 0; i < 4; i++) {
			this.modelo.asocia(this.vistas[i]);
		}
		
		// Controlador
		this.controlador = new Controlador();
		
		/// Asocia el modelo al controlador
		this.controlador.asociaModelo(this.modelo);
		
		/// Asocia el controlador a las vistas
		for (int i = 0; i < 4; i++) {
			this.vistas[i].asociaControlador(this.controlador);
		}
		
	}
	
	public static void main(String[] args) {
		new Aplicacion();
	}

}
