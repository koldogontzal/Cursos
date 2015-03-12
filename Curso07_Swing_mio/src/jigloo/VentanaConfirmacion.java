package jigloo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
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
public class VentanaConfirmacion extends javax.swing.JFrame {
	private JLabel textoConf;
	private JLabel etiqNombre;
	private JLabel etiqApellidos;
	private JLabel etiqPass;
	private JButton botonCerrar;
	private JLabel mostContrasegna;
	private JLabel mostAgno;
	private JLabel mostApellidos;
	private JLabel mostNombre;
	private JLabel etiqAgno;

	public VentanaConfirmacion(Persona per) {
		super();
		initGUI();
		
		this.mostNombre.setText(per.getNombre());

		this.mostApellidos.setText(per.getApellidos());

		this.mostAgno.setText("" + per.getAgnoNac());

		this.mostContrasegna.setText(String.copyValueOf(per.getPassword()));

	
		this.setSize(450,300);
		this.setVisible(true);
		

	}
	
	
	public VentanaConfirmacion() {
		super();
		initGUI();
	}
	
	private void cerrarVentana() {
		this.dispose();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				textoConf = new JLabel();
				textoConf.setText("Se ha creado con éxito al usuario:");
			}
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
				etiqPass = new JLabel();
				etiqPass.setText("Contraseña:");
			}
			{
				mostNombre = new JLabel();
			}
			{
				mostApellidos = new JLabel();
			}
			{
				mostAgno = new JLabel();
			}
			{
				mostContrasegna = new JLabel();
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
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(35, 35)
				.addComponent(textoConf, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(21)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiqNombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(mostNombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addGap(20)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiqApellidos, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(mostApellidos, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addGap(23)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiqAgno, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(mostAgno, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addGap(24)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(etiqPass, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(mostContrasegna, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
				.addGap(0, 31, Short.MAX_VALUE)
				.addComponent(botonCerrar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(textoConf, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(24)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(etiqPass, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				            .addComponent(etiqAgno, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				            .addComponent(etiqApellidos, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				            .addComponent(etiqNombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
				        .addGap(18)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(mostContrasegna, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(87))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(mostAgno, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(87))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(mostApellidos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(87))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(mostNombre, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				                .addGap(87))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(18)
				                .addComponent(botonCerrar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
				        .addGap(52)))
				.addContainerGap(122, 122));
			thisLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {etiqNombre, etiqApellidos, etiqAgno, etiqPass});
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
