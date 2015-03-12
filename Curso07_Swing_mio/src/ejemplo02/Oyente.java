package ejemplo02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Oyente implements ActionListener {

	private int cont;
	
	public Oyente() {
		this.cont = 0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		this.cont++;
		System.out.println("Has pulsado el botón " + boton.getText() + "\nEl contador vale " + this.cont);
	}

}
