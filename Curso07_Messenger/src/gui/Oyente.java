package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oyente implements ActionListener {
	
	private PanelMessenger pan;
	
	public Oyente(PanelMessenger pan) {
		this.pan = pan;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.pan.mandarMensaje();
	}

}
