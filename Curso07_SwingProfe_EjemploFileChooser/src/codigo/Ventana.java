package codigo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	public Ventana(){
		super();
		this.setLayout(new FlowLayout());
		
		JButton boton = new JButton("Abrir archivo");
		
		boton.addActionListener(new ActionListener(){
						
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mostrarSelector();
			}
			
		});
		
		this.getContentPane().add(boton);
		
		this.setVisible(true);
		this.setSize(200, 200);
	}
	
	public void mostrarSelector(){
		JFileChooser jfc = new JFileChooser();
		int opcion = jfc.showOpenDialog(this);
		if (opcion == JFileChooser.APPROVE_OPTION){
			File fichero = jfc.getSelectedFile();
			System.out.println(fichero.getName());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Ventana();
				
			}						
			
		});

	}

}
