package ejemplo04Menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame {

	public Ventana() {
		
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edicion");
		JMenu ayuda = new JMenu("Ayuda");
		
		JMenuItem abrir = new JMenuItem("Abrir", new ImageIcon("imagenes/aceptar.gif"));
		JMenuItem unoCualquiera = new JMenuItem("otro");
		JMenuItem cerrar = new JMenuItem("Cerror");
		
		// Action listener
		abrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.showOpenDialog(null);
				
				
			}
			
		});
		
		archivo.add(abrir);
		archivo.add(unoCualquiera);
		archivo.add(cerrar);
		
		barraMenu.add(archivo);
		barraMenu.add(edicion);
		barraMenu.add(ayuda);
		
		this.setJMenuBar(barraMenu);
		
		
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
