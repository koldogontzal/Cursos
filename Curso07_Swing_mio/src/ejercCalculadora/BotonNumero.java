package ejercCalculadora;

import javax.swing.JButton;

public class BotonNumero extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1716756155024910652L;
	private String valor;
	
	public BotonNumero(String valor) {
		super(valor);
		this.valor = valor;
		super.setToolTipText("Botón '" + valor + "'");
	}
}
