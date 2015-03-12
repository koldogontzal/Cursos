package ejemplo03;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class OyenteRaton extends MouseAdapter {
	
	public void mouseClicked(MouseEvent evento) {
		int botonPulsado = evento.getButton();
		String boton = null;
		switch (botonPulsado) {
		case MouseEvent.BUTTON1:
			boton = "bot�n izquierdo";
			break;
		case MouseEvent.BUTTON2:
			boton = "bot�n central";
			break;
		case MouseEvent.BUTTON3:
			boton = "bot�n derecho";
		}
		
		Point puntoPulsdo = evento.getPoint();
		int x = puntoPulsdo.x;
		int y = puntoPulsdo.y;
		
		JOptionPane.showMessageDialog(null, "Se puls� el " + boton + " en el punto ("+x+","+y , "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
