package ejercicioMVC;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VCT extends Vista {
	
	private static final long serialVersionUID = -530995351597028763L;
	
	private JTextArea texto;
	
	public VCT () {
		super();
		this.initGUI();
	}

	private void initGUI() {
		this.texto = new JTextArea(10,40);
		JScrollPane panel = new JScrollPane(this.texto);
		
		super.getContentPane().add(panel);
		
		super.setTitle("Texto");
		super.pack();
		super.setVisible(true);
		
	}

	@Override
	public void visualiza(Modelo m) {
		this.texto.setText(m.getDatos());
	}

	@Override
	public void asociaControlador(Controlador controlador) {
		this.texto.addKeyListener(controlador);
		
	}
	

}
