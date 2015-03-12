package codigo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	private Tablero tablero;
	private PanelConfiguracion configuracion;
	
	public Ventana(){
		int tamanio = 10;/** Tamaño por defecto */
		int numMinas = 10; /** Numero minas por defecto */
		/** new Tablero(tamaño,numero de minas)*/
		this.tablero = new Tablero(tamanio,numMinas);
		this.configuracion = new PanelConfiguracion(this);				
		this.getContentPane().add(this.tablero, BorderLayout.CENTER);
		this.getContentPane().add(this.configuracion, BorderLayout.EAST);
		this.setTitle("Buscaminas UPM");
		/** ((tamanio de la mina) * (numero de minas)) + (tamanio panel de config) */
		this.setSize(50*tamanio+200,50*tamanio);		
		/**Se configura el tamaño de la ventana en funcion del tamañno del tablero
		 * como los iconos son de 50x50 se multiplica 50 X numero de celdas */
		this.setMinimumSize(new Dimension(50*tamanio+200,50*tamanio));
		this.setVisible(true);		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Ventana();
			}
		});
	}
	
	public void actualizarTablero(int numMinas, int tamanio){
		this.getContentPane().remove(this.tablero);
		this.tablero = new Tablero(tamanio,numMinas);
		this.getContentPane().add(this.tablero, 0);
		this.validate();
		this.repaint();
	}
	
	public void jugar(int numMinas, int tamanio){
		this.setSize(50*tamanio+200, 50*tamanio);
		this.remove(this.tablero);
		this.tablero = new Tablero(tamanio, numMinas);
		this.getContentPane().add(this.tablero, BorderLayout.CENTER);
		this.validate();
		this.repaint();
	}

}
