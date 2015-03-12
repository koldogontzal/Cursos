package gui;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelMessenger extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7541142986073805867L;

	private Aplicacion app;
	
	private JTextArea visor;
	private JTextField campoTexto;
	private JButton botonEnviar;
	
	public PanelMessenger(Aplicacion app) {
		super();
		this.app = app;
		this.initGUI();
	}

	private void initGUI() {
		this.visor = new JTextArea();
		this.visor.setEditable(false);
		
		Oyente oyente = new Oyente(this);
		this.campoTexto = new JTextField();
		this.campoTexto.addActionListener(oyente);
		this.botonEnviar = new JButton("Enviar");
		this.botonEnviar.addActionListener(oyente);
		
		BorderLayout layOut = new BorderLayout();
		this.setLayout(layOut);		
		this.add(this.visor, BorderLayout.CENTER);
		
		JPanel panelSur = new JPanel();
		BoxLayout layout = new BoxLayout(panelSur, BoxLayout.X_AXIS);
		panelSur.setLayout(layout);
		panelSur.add(this.campoTexto);
		panelSur.add(this.botonEnviar);
		this.add(panelSur, BorderLayout.SOUTH);		
	}
	
	public void agnadirLineaAlVisor(String linea) {
		String textoVentana = this.visor.getText();
		textoVentana = textoVentana + linea + "\n";
		this.visor.setText(textoVentana);
	}

	public void mandarMensaje() {
		String mensaje = this.campoTexto.getText();
		this.campoTexto.setText("");
		this.app.mandarMensaje(mensaje);
	}

}
