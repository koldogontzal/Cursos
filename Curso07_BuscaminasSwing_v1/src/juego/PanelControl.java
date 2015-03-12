package juego;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class PanelControl extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3352480371173765288L;

	private Buscaminas juego;
	
	private JLabel etiqNumFilas;
	private JTextField numFilas;
	private JLabel etiqNumColumnas;
	private JTextField numColumnas;
	private JLabel etiqNumBombas;
	private JTextField numBombas;
	private JLabel labelTiempoTranscurrido;
	private int tiempo = 0;
	private Timer timer;
	
	private JButton botonReiniciar;
	
	public PanelControl(int fil, int col, int bomb, Buscaminas j) {
		super();

		this.juego = j;
		
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		this.etiqNumFilas = new JLabel("Filas:");
		this.numFilas = new JTextField("" + fil);
		this.numFilas.setMaximumSize(new Dimension(100,25));
		
		this.etiqNumColumnas = new JLabel("Columnas:");
		this.numColumnas = new JTextField("" + col);
		this.numColumnas.setMaximumSize(new Dimension(100,25));
		
		this.etiqNumBombas = new JLabel("Numero de bombas:");
		this.numBombas = new JTextField("" + bomb);
		this.numBombas.setMaximumSize(new Dimension(100,25));
		
		this.botonReiniciar = new JButton("Reiniciar");
		
		this.labelTiempoTranscurrido = new JLabel("Tiempo transcurrido: 0");
		this.labelTiempoTranscurrido.setPreferredSize(new Dimension(150,25));
		
		this.add(this.etiqNumFilas);
		this.add(this.numFilas);
		this.add(new JLabel(" "));
		this.add(this.etiqNumColumnas);
		this.add(this.numColumnas);
		this.add(new JLabel(" "));
		this.add(this.etiqNumBombas);
		this.add(this.numBombas);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(this.botonReiniciar);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(this.labelTiempoTranscurrido);
		
		this.botonReiniciar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int filas = Integer.parseInt(numFilas.getText());
				int columnas = Integer.parseInt(numColumnas.getText());
				int bombas = Integer.parseInt(numBombas.getText());
				
				juego.reset(filas, columnas, bombas);
				tiempo = 0;
				timer.start();
				
			}
		});
		
		this.timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tiempo++;
				labelTiempoTranscurrido.setText("Tiempo transcurrido: " + tiempo);
			}
			
		});
		this.timer.start();
	}

	public void pararTimer() {
		this.timer.stop();
	}



}
