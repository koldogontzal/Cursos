package jigloo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.GregorianCalendar;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Ventana extends javax.swing.JFrame {
	private JLabel etiqNombre;
	private JLabel etiqApellidos;
	private JLabel atiqContrasegna;
	private JTextField textoApelidos;
	private JComboBox comboAgno;
	private JPasswordField textoContrasegnaRep;
	private JPasswordField textoContrasegna;
	private JTextField textoNombre;
	private JButton botRegistrar;
	private JLabel etiquContrasegnaRep;
	private JLabel etiqAgno;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Ventana inst = new Ventana();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Ventana() {
		super();
		initGUI();
	}
	
	public void registrarUsuario() {
		// Este es nuestro metodo
		String errores = "";
		if (this.textoNombre.getText().length() == 0) 
			errores += "El campo Nombre es obligatorio \n";
		if (this.textoApelidos.getText().length() == 0) 
			errores += "El campo Apellidos es obligatorio \n";
		if (this.textoContrasegna.getPassword().length < 6) 
			errores += "La contraseña es muy corta\n";
		else if (!this.clavesIguales()) {
				errores += "Las contraseñas no son iguales\n";
			}		
		if (errores.equals("")) {
			// No hay errores
			
			Component[] c = this.getContentPane().getComponents();
			for (int i = 0; i < c.length; i++) {
				c[i].setEnabled(false);
			}
			/*// Esta forma no mola, feeeeea
			 * 
			this.textoNombre.setEnabled(false);
			this.textoApelidos.setEnabled(false);
			this.textoContrasegna.setEnabled(false);
			this.textoContrasegnaRep.setEnabled(false);
			this.comboAgno.setEnabled(false);
			*/
			Persona per = new Persona();
			per.setNombre(this.textoNombre.getText());
			per.setApellidos(this.textoApelidos.getText());
			per.setAgnoNac(Integer.parseInt("" + this.comboAgno.getSelectedItem()));
			per.setPassword(this.textoContrasegna.getPassword());
			
			new VentanaConfirmacion(per);
			
		} else {
			JOptionPane.showMessageDialog(this, errores, "Mensajes de error", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	
	private boolean clavesIguales() {
		char[] clave1 = this.textoContrasegna.getPassword();
		char[] clave2 = this.textoContrasegnaRep.getPassword();
		int tamagno = clave1.length;
		if (tamagno != clave2.length) {
			return false;
		} else {
			for (int i = 0; i < tamagno; i++) {
				if (clave1[i] != clave2[i]) {
					return false;
				}
			}
		}
		return true;
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				etiqNombre = new JLabel();
				etiqNombre.setText("Nombre:");
			}
			{
				etiqApellidos = new JLabel();
				etiqApellidos.setText("Apellidos:");
			}
			{
				etiqAgno = new JLabel();
				etiqAgno.setText("Año nacimiento:");
			}
			{
				atiqContrasegna = new JLabel();
				atiqContrasegna.setText("Contraseña:");
			}
			{
				etiquContrasegnaRep = new JLabel();
				etiquContrasegnaRep.setText("Repetir contraseña:");
			}
			{
				botRegistrar = new JButton();
				botRegistrar.setText("Registrar");
				botRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						registrarUsuario();
					}
					
				});
			}
			{
				textoNombre = new JTextField();
			}
			{
				textoApelidos = new JTextField();
			}
			{
				textoContrasegna = new JPasswordField();
			}
			{
				textoContrasegnaRep = new JPasswordField();
			}
			{
				comboAgno = new JComboBox();
				int anio = (new GregorianCalendar()).get(GregorianCalendar.YEAR);
				for (int i = 1900; i < anio; i++) {
					comboAgno.addItem(Integer.valueOf(i));
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(23, 23)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(textoNombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(7)
				        .addComponent(etiqNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(textoApelidos, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(etiqApellidos, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(comboAgno, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				    .addComponent(etiqAgno, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(17)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(textoContrasegna, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(atiqContrasegna, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(textoContrasegnaRep, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(etiquContrasegnaRep, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(57)
				.addComponent(botRegistrar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(71, 71));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(25, 25)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiquContrasegnaRep, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(atiqContrasegna, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
				        .addGap(25))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(etiqAgno, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
				        .addGap(25))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(etiqApellidos, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
				        .addGap(25))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(etiqNombre, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
				        .addGap(25)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(textoContrasegnaRep, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
				    .addComponent(textoContrasegna, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(comboAgno, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
				        .addGap(61))
				    .addComponent(textoApelidos, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
				    .addComponent(textoNombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(botRegistrar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
				        .addGap(20)))
				.addContainerGap(216, 216));
			thisLayout.linkSize(SwingConstants.VERTICAL, new Component[] {etiqAgno, etiqNombre, etiqApellidos});
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {etiqAgno, etiqNombre, etiqApellidos});
			pack();
			this.setSize(500, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
