package juego;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buscaminas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8815474763261505229L;
	private Tablero tab;
	private PanelControl pan;

	private JPanel panel;
	
	public Buscaminas() {
		super();
		
		this.tab = new Tablero(this, 15, 15, 30);
		this.pan = new PanelControl(15, 15, 30, this);
		
		BorderLayout layOut = new BorderLayout();
		this.panel = new JPanel();
		this.panel.setLayout(layOut);
		
		this.panel.add(this.pan, BorderLayout.EAST);
		this.panel.add(this.tab, BorderLayout.CENTER);
		
		this.getContentPane().add(panel);
		this.setTitle("Buscaminas");
		this.setSize(800, 800);
		this.setVisible(true);			
	}
	
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Buscaminas();
			}
		});
	}

	public void reset(int filas, int columnas, int bombas) {
		
		this.tab.setEnabled(true);
		this.panel.remove(this.tab);
		
		this.tab = new Tablero(this, filas, columnas, bombas);
		this.panel.add(this.tab, BorderLayout.CENTER);
		
		this.validate();
		this.repaint();
		
	}

	public void pararTimer() {
		this.pan.pararTimer();
	}
}
