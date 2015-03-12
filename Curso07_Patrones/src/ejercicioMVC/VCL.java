package ejercicioMVC;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VCL extends Vista {
	
	private static final long serialVersionUID = 2257464598294058360L;
	
	private int numVocales;
	private int numConsonantes;
	
	private JLabel etiquetaVocales;
	private JLabel etiquetaConsonantes;
	private JButton botonBorrar;
	
	public VCL() {
		super();
		
		this.numVocales = 0;
		this.numConsonantes = 0;
		
		this.etiquetaVocales = new JLabel("Nº vocales: 0");
		this.etiquetaConsonantes = new JLabel("Nº consonantes: 0");
		this.botonBorrar = new JButton("Borrar");
		
		BoxLayout layOut = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		this.getContentPane().setLayout(layOut);
			
		this.getContentPane().add(this.etiquetaVocales);
		this.getContentPane().add(this.etiquetaConsonantes);
		this.getContentPane().add(this.botonBorrar);
		
		super.setTitle("Nº Carateres");
		super.setSize(300, 150);
		super.setVisible(true);
	}
	
	
	@Override
	public void visualiza(Modelo m) {
		this.numVocales = this.cuentaVocales(m.getDatos());
		this.numConsonantes = m.getDatos().length() - this.cuentaVocales(m.getDatos());
		this.etiquetaVocales.setText("Nº vocales: " + this.numVocales);
		this.etiquetaConsonantes.setText("Nº consonantes: " + this.numConsonantes);
		
	}
	
	private int cuentaVocales(String datos) {
		int ret = 0;
		String textoMayusuclas = datos.toUpperCase();
		for (int i = 0; i < datos.length(); i++) {
			char letra = textoMayusuclas.charAt(i);
			if ((letra == 'A') || (letra == 'E') || (letra == 'I') || (letra == 'O') || (letra == 'U')) {
				ret++;
			}
		}
		return ret;
	}


	@Override
	public void asociaControlador(Controlador controlador) {
		this.botonBorrar.addActionListener(controlador);
	}
	

}
