package gui;

import javax.swing.JFrame;

import datagramas.ClienteEnvia;
import datagramas.ServidorEscucha;

public class Aplicacion extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4866255354564498797L;

	private PanelMessenger p;
	
	private ServidorEscucha ser;
	private ClienteEnvia cli;
	
	public Aplicacion() {
		super();
		this.p = new PanelMessenger(this);
		this.ser = new ServidorEscucha(this.p);
		this.ser.start();
		this.cli = new ClienteEnvia(this.p);
	}

	public static void main(String[] args) {
		Aplicacion app = new Aplicacion();
		app.comenzar();
	}

	private void comenzar() {		
		this.getContentPane().add(this.p);
		this.setTitle("Mésenjer");
		this.setSize(800, 800);
		this.setVisible(true);
	}

	public void mandarMensaje(String texto) {
		this.cli.enviarMensaje(texto);
	}

	
}
