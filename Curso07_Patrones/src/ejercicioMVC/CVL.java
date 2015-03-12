package ejercicioMVC;

import javax.swing.JLabel;

public class CVL extends Vista {
	
	private static final long serialVersionUID = -4538425446051699644L;

	private int numLetras;
	
	private JLabel etiqueta;
	
	public CVL() {
		super();
		
		this.numLetras = 0;
		this.etiqueta = new JLabel("Nº letras: 0");
		
		this.getContentPane().add(this.etiqueta);
		
		super.setTitle("Nº letras");
		super.setSize(300, 100);
		super.setVisible(true);
	}

	@Override
	public void visualiza(Modelo m) {
		this.numLetras = m.getDatos().length();
		this.etiqueta.setText("Nº letras: " + this.numLetras);
		
	}

	@Override
	public void asociaControlador(Controlador controlador) {
		// NO hace nada en esta vista	
	}
	
	

}
