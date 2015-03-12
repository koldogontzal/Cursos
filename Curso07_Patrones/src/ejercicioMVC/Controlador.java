package ejercicioMVC;

import java.awt.event.*;

public class Controlador implements ActionListener, KeyListener {
	
	/// Asociacion Modelo
	private Modelo modelo;
	public void asociaModelo(Modelo m) {
		this.modelo = m;
	}
	////////
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.modelo.clear();		
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		this.modelo.pon(e.getKeyChar());		
	}

}
