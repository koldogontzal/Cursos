package juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Casilla extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7568713555466206664L;
	
	private int numBombasAlrededor;
	private boolean bomba;
	private int estado;
	private JLabel etiqueta;
	private JButton boton;
	
	private Tablero tablero;
	private Coordenada coordenada;
	
	public static final int OCULTA = 0;
	public static final int BOMBA_MARCADA = 1;
	public static final int INTERROGANTE = 2;
	public static final int LEVANTADA = 3;
	
	public Casilla(Tablero tab, Coordenada c) {
		super();
		
		this.tablero = tab;
		this.coordenada = c;
		
		this.bomba = false;
		this.numBombasAlrededor = 0;
		this.estado = OCULTA;
		
		this.etiqueta = new JLabel("");
		this.etiqueta.setHorizontalAlignment(JLabel.CENTER);
		this.etiqueta.setBorder(BorderFactory.createLineBorder(Color.black));
		this.etiqueta.setBackground(new Color(50, 0, 50));
		
		this.boton = new JButton();
		
		// Casilla es un panel
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		this.add(new JLabel(""), BorderLayout.NORTH);
		this.add(new JLabel(""), BorderLayout.EAST);
		this.add(new JLabel(""), BorderLayout.WEST);
		this.add(new JLabel(""), BorderLayout.SOUTH);
		
		// this.add(this.etiqueta, BorderLayout.CENTER); // La a�ado al levantar
		this.add(this.boton, BorderLayout.CENTER);
		
		// Crea el listener del boton
		this.boton.addMouseListener(new MouseAdapter() {

			
			public void mouseClicked(MouseEvent evento) {
				int botonPulsado = evento.getButton();
				switch (botonPulsado) {
				case MouseEvent.BUTTON1:
					// boton = "bot�n izquierdo";
					destapaCasilla();
					break;
				case MouseEvent.BUTTON3:
					// boton = "bot�n derecho";
					cambiaEstado();
				}
				
				
			}
		});		
	}
	
	public void cambiaEstado() {
		this.estado = (this.estado + 1) % 3;
		switch (this.estado) {
		case OCULTA:
			this.boton.setIcon(new ImageIcon("imagenes/vacio.gif"));
			break;
		case BOMBA_MARCADA:
			this.boton.setIcon(new ImageIcon("imagenes/ok.gif"));
			break;
		case INTERROGANTE:
			this.boton.setIcon(new ImageIcon("imagenes/interrogante2.gif"));
			break;
		}
	}
	
	public void destapaCasilla() {
		this.tablero.levanta(this.coordenada);
	}
	
	public void ponBomba() {
		this.bomba = true;		
	}

	public boolean tienesBomba() {
		return this.bomba;
	}

	public void setNumBombas(int numBombas) {
		this.numBombasAlrededor = numBombas;
		if (numBombas != 0) {
			this.etiqueta.setText("" + this.numBombasAlrededor);
		}
	}

	public void visualiza() {
		if (this.estado == LEVANTADA) {
			if (this.bomba) {
				System.out.print('B');
			} else {
				if (this.numBombasAlrededor != 0) {
					System.out.print(this.numBombasAlrededor);
				} else {
					System.out.print(' ');
				}
			}
		} else {
			System.out.print('X');
		}
	}

	public void levanta() {
		this.estado = LEVANTADA;
		this.boton.setVisible(false);
		this.add(this.etiqueta);
	}

	public boolean agua() {
		return ((this.numBombasAlrededor == 0) && (!this.bomba));
	}

	public boolean estaLevantada() {
		return this.estado == LEVANTADA;
	}

	public void muestraBomba() {
		if (this.tienesBomba()) {
			this.boton.setIcon(new ImageIcon("imagenes/ico_buscaminas.gif"));
		}		
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		this.boton.setEnabled(enabled);
	}
}
