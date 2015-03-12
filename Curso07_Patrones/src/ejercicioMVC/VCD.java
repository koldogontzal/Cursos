package ejercicioMVC;

import javax.swing.JComboBox;

public class VCD extends Vista {
	
	private static final long serialVersionUID = 5260902197982127003L;
	
	private JComboBox lista;
	
	public VCD() {
		super();
		
		this.lista = new JComboBox();
		super.getContentPane().add(this.lista);
		
		super.setTitle("Lista desplegable");
		super.setSize(300, 60);
		super.setVisible(true);
	}

	@Override
	public void asociaControlador(Controlador controlador) { }

	@Override
	public void visualiza(Modelo m) {
		String[] listadoPalabras = m.getDatos().split(" ");
		this.lista.removeAllItems();
		for (int i = 0; i < listadoPalabras.length; i++) {
			this.lista.addItem(listadoPalabras[i]);
		}
	}

}
