package ejercCalculadora;

public class Aplicacion extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1994175540230118834L;
	private JLienzoCalculadora lienzo;
	
	public Aplicacion() {
		this.lienzo = new JLienzoCalculadora();
		this.getContentPane().add(this.lienzo);

		this.setTitle("Calculator");
		this.setSize(500, 500);
		this.setVisible(true);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Aplicacion();
			}
		});
	}

}
