package ejemploThreads;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Ventana extends javax.swing.JFrame {
	private JButton botonSaludo;
	private JButton botonLeer;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Ventana inst = new Ventana();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Ventana() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				botonSaludo = new JButton();
				botonSaludo.setText("Saludar");
				botonSaludo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						// Tarea corta
						//System.out.println("Hola!");
						//System.out.println(javax.swing.SwingUtilities.isEventDispatchThread());
						saludar();
					}
				});
			}
			{
				botonLeer = new JButton();
				botonLeer.setText("Leer Archivo");
				botonLeer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						leerArchivo();
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(86, 86)
				.addComponent(botonSaludo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(40)
				.addComponent(botonLeer, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(98, 98));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(61, 61)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(botonSaludo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
				    .addComponent(botonLeer, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(201, 201));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leerArchivo() {
		// Tarea larga
		// Usamos un SwingWorker, para no bloquear la interfaz
		
		Trabajador t = new Trabajador();
		t.execute();
		
	}
	
	public void saludar() {
		// tarea corta
		JOptionPane.showMessageDialog(this, "hola", "saludo", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
