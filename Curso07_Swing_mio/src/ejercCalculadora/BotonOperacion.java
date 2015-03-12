package ejercCalculadora;

import java.awt.Dimension;

import javax.swing.JButton;

public class BotonOperacion extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2080938859202709750L;
	public static final int SUMA = 0;
	public static final int RESTA = 1;
	public static final int MULTIPLICACION = 2;
	public static final int DIVISION = 3;
	public static final int IGUAL = 4;
	public static final int NONE = -1;
	
		
	private int operacion;
	
	public BotonOperacion(int op) {
		super.setMaximumSize(new Dimension(200,100));
		this.operacion = op;
		switch (op) {
		case SUMA:
			super.setText("Sumar");
			super.setToolTipText("Botón para sumar");
			break;
		case RESTA:
			super.setText("Restar");
			super.setToolTipText("Botón para restar");
			break;
		case MULTIPLICACION:
			super.setText("Multiplicar");
			super.setToolTipText("Botón para multiplicar");
			break;
		case DIVISION:
			super.setText("Dividir");
			super.setToolTipText("Botón para dividir");
			break;
		case IGUAL:
			super.setText("Igual...");
			super.setToolTipText("Calcula el resultado");
			break;				
		}
	}
	
	public int getTipoOperacion() {
		return this.operacion;
	}
	
	public static double calculaResultado(double op1, double op2, int op) {
		switch (op) {
		case SUMA:
			return op1 + op2;
		case RESTA:
			return op1 - op2;
		case MULTIPLICACION:
			return op1 * op2;
		case DIVISION:
			return op1 / op2;
		default:
			System.out.println("Error en la secuencia de operandos");
			return 0;			 
		}
	}
}
