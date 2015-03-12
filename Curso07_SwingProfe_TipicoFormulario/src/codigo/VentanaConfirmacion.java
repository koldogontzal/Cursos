package codigo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
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
public class VentanaConfirmacion extends javax.swing.JFrame {
	private JLabel etiqCabecera;
	private JLabel etiqApellidos;
	private JLabel nombre;
	private JLabel password;
	private JLabel anioNac;
	private JLabel apellidos;
	private JButton botonCerrar;
	private JLabel etiqPassword;
	private JLabel etiqAnio;
	private JLabel etiqNombre;
	
	public VentanaConfirmacion(Persona p) {
		super();
		initGUI();
		this.nombre.setText(p.getNombre());
		this.apellidos.setText(p.getApellidos());
		this.anioNac.setText(String.valueOf(p.getAnioNac()));
		this.password.setText(String.copyValueOf(p.getPassword()));
		
		this.setSize(380, 275);
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				etiqCabecera = new JLabel();
				etiqCabecera.setText("Se ha registrado con exito al usuario:");
			}
			{
				etiqNombre = new JLabel();
				etiqNombre.setText("Nombre");
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
				botonCerrar = new JButton();
				botonCerrar.setText("Cerrar");
				botonCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cerrarVentana();
					}
				});
			}
			{
				nombre = new JLabel();
			}
			{
				apellidos = new JLabel();
			}
			{
				anioNac = new JLabel();
			}
			{
				password = new JLabel();
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(etiqCabecera, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiqNombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(nombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiqApellidos, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(apellidos, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addGap(21)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiqAnio, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(anioNac, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addGap(26)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiqPassword, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(password, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addGap(29)
				.addComponent(botonCerrar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(16, 16)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(etiqAnio, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(etiqPassword, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				                .addGap(7))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(etiqApellidos, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				                .addGap(39))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(etiqNombre, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				                .addGap(7)))
				        .addGap(21)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(password, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
				            .addComponent(anioNac, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
				            .addComponent(apellidos, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
				            .addComponent(nombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(43)
				                .addComponent(botonCerrar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				                .addGap(74))))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(etiqCabecera, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
				        .addGap(64)))
				.addContainerGap(121, 121));
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarVentana(){
		this.dispose();
	}


}
