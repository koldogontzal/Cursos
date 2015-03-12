package codigo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JLabel etiqPassword2;
	private JTextField nombre;
	private JPasswordField password2;
	private JPasswordField password;
	private JComboBox anioNacimiento;
	private JTextField apellidos;
	private JButton botonRegistrar;
	private JLabel etiqPassword;
	private JLabel etiqAnio;

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
				etiqApellidos.setText("Apellidos");
			}
			{
				etiqAnio = new JLabel();
				etiqAnio.setText("Año Nacimiento");
			}
			{
				etiqPassword = new JLabel();
				etiqPassword.setText("Contraseña");
			}
			{
				etiqPassword2 = new JLabel();
				etiqPassword2.setText("Repetir Contraseña");
			}
			{
				botonRegistrar = new JButton();
				botonRegistrar.setText("Registrar");
				botonRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						registrarUsuario();
					}
				});
			}
			{
				nombre = new JTextField();
			}
			{
				apellidos = new JTextField();
			}
			{
				
				anioNacimiento = new JComboBox();
				GregorianCalendar cal = new GregorianCalendar();
				int anio = cal.get(GregorianCalendar.YEAR);
				for (int i=1900; i<=anio; i++)
					anioNacimiento.addItem(Integer.valueOf(i));
			}
			{
				password = new JPasswordField();
			}
			{
				password2 = new JPasswordField();
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(35, 35)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(nombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(etiqNombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(apellidos, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(etiqApellidos, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(anioNacimiento, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(etiqAnio, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(17)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(password, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(etiqPassword, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(16)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(password2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(etiqPassword2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(0, 20, Short.MAX_VALUE)
				.addComponent(botonRegistrar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(18, 18)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiqPassword2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(etiqPassword, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
				        .addGap(30))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(etiqAnio, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				        .addGap(18))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(etiqApellidos, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
				        .addGap(30))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(etiqNombre, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
				        .addGap(30)))
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(password2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
				        .addGap(26))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(password, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
				        .addGap(26))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(anioNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(17)
				        .addComponent(botonRegistrar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
				        .addGap(7))
				    .addComponent(apellidos, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
				    .addComponent(nombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(136, 136));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void registrarUsuario(){
		String errores = "";
		if (this.nombre.getText().length() == 0)
			errores += "El campo nombre es obligatorio \n";
		if (this.apellidos.getText().length() == 0)
			errores += "El campo apellidos es obligatorio \n";
		if (this.password.getPassword().length < 6)
			errores += "La contraseña es muy corta \n";
		else 
			if (this.passwordDistintos())
				errores += "Las contraseñas no son iguales";
		
		if (errores.equals("")){
			/** forma elegante*/
			Component[] c = this.getContentPane().getComponents();
			for (int i=0; i<c.length; i++)
				c[i].setEnabled(false);
			
			/** forma poco elegante
			this.nombre.setEnabled(false);
			this.apellidos.setEnabled(false);
			this.anioNacimiento.setEnabled(false);
			this.password.setEnabled(false);
			this.password2.setEnabled(false);
			this.botonRegistrar.setEnabled(false);
			*/
			Persona p = new Persona();
			p.setNombre(this.nombre.getText());
			p.setApellidos(this.apellidos.getText());
			int anioNac = Integer.parseInt(""+this.anioNacimiento.getSelectedItem());
			p.setAnioNac(anioNac);
			p.setPassword(this.password.getPassword());
			
			new VentanaConfirmacion(p);
		}else{
			JOptionPane.showMessageDialog(this, errores, "Mensaje de error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean passwordDistintos(){
		boolean result = false;
		int i=0;
		char[] pas1 = this.password.getPassword();
		char[] pas2 = this.password2.getPassword();
		
		if (pas1.length != pas2.length)
			result = true;
		else {
			while ((i<pas1.length) && (pas1[i] == pas2[i]))
				i++;
			result = !(i==pas1.length);				
		}
		
		return result;
	}

}
