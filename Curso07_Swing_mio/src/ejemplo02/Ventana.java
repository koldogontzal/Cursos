package ejemplo02;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame {

	public Ventana() {
		Oyente escritor = new Oyente();
		JButton boton = new JButton("FCUK EM!");
		boton.addActionListener(escritor);
		
		
		this.getContentPane().add(boton);
		this.setSize(200, 200);
		this.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Ventana();
			}
		});
	}

}
