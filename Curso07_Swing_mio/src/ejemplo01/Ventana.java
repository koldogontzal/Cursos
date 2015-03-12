package ejemplo01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6668890463107441797L;

	public Ventana() {
		//JLienzo lienzo = new JLienzo();
		//this.getContentPane().add(lienzo);
		
		/* 
		 //BorderLayout
		BorderLayout layout = new BorderLayout();
		JPanel panel = new JPanel();
		panel.setLayout(layout);
		
		panel.add(new JButton("¡BOTONACO!"));
		panel.add(new JLabel("¿Yesoqueés?: "), BorderLayout.EAST);
		// esto estira el elemento
		panel.add(new JTextField("Esto es un campo de texto chungo que SÍ se estira"), BorderLayout.NORTH);
		// Si no lo queremos estirar, entonces hacemos lo siguiten
		JPanel panelSur = new JPanel();
		panelSur.add(new JTextField("Esto es un campo de texto chungo que NO se estira"));
		panel.add(panelSur, BorderLayout.SOUTH);
		*/
		
		/* 
		 //GridLayout
		GridLayout layout = new GridLayout(4, 3);
		JPanel panel = new JPanel();
		layout.setVgap(10);
		layout.setHgap(10);
		panel.setLayout(layout);
		
		for (int i = 0; i < 10; i++) {
			panel.add(new JButton("Botón " + (i + 1)));
		}
		*/
		
		// BoxLayout
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		
		panel.setLayout(layout);
		
		for (int i = 0; i < 10; i++) {
			panel.add(new JButton("Botón " + (i + 1)));
		}
		
		this.getContentPane().add(panel);
		this.setTitle("Mameluko");
		this.setSize(500, 500);
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
