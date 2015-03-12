package ejemploTimer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.Timer;
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
	private JPanel panel;
	private JButton botonEmpezar;
	private Timer timer;
	

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
		this.panel = new JPanel();
		this.panel.setBounds(510,150,50,50);
		this.panel.setBackground(Color.black);
		this.getContentPane().add(this.panel);
		
		this.timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				moverCuadrado();
				
			}
			
		});
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				botonEmpezar = new JButton();
				botonEmpezar.setText("Empezar");
				botonEmpezar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						timer.start();
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(226, 226)
				.addComponent(botonEmpezar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(19, 19));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(126, 126)
				.addComponent(botonEmpezar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(115, 115));
			pack();
			this.setSize(1000, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void moverCuadrado() {
		int x = this.panel.getX();
		int y = this.panel.getY();
		x = x + (int)(Math.random() * 4 - 2);
		y = y + (int)(Math.random() * 4 - 2);
		this.panel.setLocation(x, y);
		
		// Repintar
		this.validate();
		this.repaint();
	}

}
