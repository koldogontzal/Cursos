package ejercCalculadora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JLienzoCalculadora extends javax.swing.JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 596911130171650367L;
	private JTextField visor;
	private BotonNumero[] botonNumero;
	private BotonOperacion[] botonOperacion;
	
	private double valorMemoria;
	private int operacionPendiente;
	

	public JLienzoCalculadora() {
		this.valorMemoria = 0;
		this.operacionPendiente = BotonOperacion.NONE;
		
		//BorderLayout
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		// En el Norte, el display
		this.visor = new JTextField("0");
		this.visor.setHorizontalAlignment(JTextField.RIGHT);
		this.visor.setToolTipText("Visor de resultados y numeros");
		this.add(this.visor, BorderLayout.NORTH);
		
		// En el Centro, los botones de numeros
		JPanel panelCentro = new JPanel();
		GridLayout layoutCentro = new GridLayout(4, 3);
		layoutCentro.setVgap(10);
		layoutCentro.setHgap(10);
		panelCentro.setLayout(layoutCentro);
		this.botonNumero = new BotonNumero[11];
		for (int i = 0; i < 10; i++) {
			this.botonNumero[i] = new BotonNumero("" + (9 - i));
			
			if (i == 9) {
				panelCentro.add(new JLabel(""));
			}
			panelCentro.add(this.botonNumero[i]);
		}
		this.botonNumero[10] = new BotonNumero(".");
		panelCentro.add(this.botonNumero[10]);
		this.add(panelCentro, BorderLayout.CENTER);
		
		for (int i = 0; i < 11; i++) {
			this.botonNumero[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String text = visor.getText();
					if (text.equals("0")) {
						text = "";
					}
					text = text + ((BotonNumero)arg0.getSource()).getText();
					visor.setText(text);
				}				
			});
		}
		
		// En el Este, los botones de operaciones
		JPanel panelEste = new JPanel();
		BoxLayout layoutEste = new BoxLayout(panelEste, BoxLayout.PAGE_AXIS);		
		panelEste.setLayout(layoutEste);
		this.botonOperacion = new BotonOperacion[5];
		this.botonOperacion[0] = new BotonOperacion(BotonOperacion.SUMA);
		this.botonOperacion[1] = new BotonOperacion(BotonOperacion.RESTA);
		this.botonOperacion[2] = new BotonOperacion(BotonOperacion.MULTIPLICACION);
		this.botonOperacion[3] = new BotonOperacion(BotonOperacion.DIVISION);
		this.botonOperacion[4] = new BotonOperacion(BotonOperacion.IGUAL);
		
		for (int i = 0; i < 5; i++) {
			panelEste.add(this.botonOperacion[i]);
		}
		
		for (int i = 0; i < 4; i++) {
			// Botones de operaciones, con dos sumandos
			this.botonOperacion[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					valorMemoria = Double.parseDouble(visor.getText());
					BotonOperacion bot = (BotonOperacion)arg0.getSource();
					operacionPendiente = bot.getTipoOperacion();
					visor.setText("");					
				}
			});
		}
		// Botón de igual
		this.botonOperacion[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double valorVisor = Double.parseDouble(visor.getText());
				double resultado = BotonOperacion.calculaResultado(valorMemoria, valorVisor, operacionPendiente);
				visor.setText("" + resultado);					
			}
		});
		
		panelEste.add(new JLabel(new ImageIcon("imagenes/logo.jpg")));
		this.add(panelEste, BorderLayout.EAST);
				
	}
}
