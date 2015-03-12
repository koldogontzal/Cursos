package codigo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

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
public class PanelConfiguracion extends javax.swing.JPanel {
	private JButton botonJugar;
	private JTextField tiempo;
	private JLabel etiqTamanio;
	private JLabel etiqMinas;
	private JLabel etiqTiempo;
	private JTextField tamanio;
	private JTextField minas;
	private Ventana padre;

	public PanelConfiguracion(Ventana padre) {
		super();
		this.setBackground(java.awt.Color.yellow);
		initGUI();
		this.setMaximumSize(new Dimension(200,600));
		this.padre = padre;
		this.tiempo.setText("100");
		this.minas.setText("10");
		this.tamanio.setText("10");
		
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)this);
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(177, 300));
			{
				botonJugar = new JButton();
				botonJugar.setText("Jugar");
				botonJugar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						botonJugarActionPerformed(evt);
					}
				});
			}
			{
				tiempo = new JTextField();
			}
			{
				minas = new JTextField();
			}
			{
				tamanio = new JTextField();
			}
			{
				etiqTiempo = new JLabel();
				etiqTiempo.setText("Tiempo");
			}
			{
				etiqMinas = new JLabel();
				etiqMinas.setText("Minas");
			}
			{
				etiqTamanio = new JLabel();
				etiqTamanio.setText("Tamaño");
			}
				thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
					.addContainerGap(39, 39)
					.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(tiempo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(etiqTiempo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(minas, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(etiqMinas, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(tamanio, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(etiqTamanio, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addComponent(botonJugar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, 78));
				thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
					.addContainerGap(23, 23)
					.addGroup(thisLayout.createParallelGroup()
					    .addComponent(etiqTiempo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					    .addComponent(etiqMinas, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					    .addComponent(etiqTamanio, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGroup(thisLayout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
					        .addComponent(botonJugar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(44))
					    .addGroup(thisLayout.createSequentialGroup()
					        .addGap(24)
					        .addGroup(thisLayout.createParallelGroup()
					            .addComponent(tiempo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					            .addComponent(minas, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					            .addComponent(tamanio, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(22, 22));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void botonJugarActionPerformed(ActionEvent evt) {
		int numMinas = Integer.parseInt(this.minas.getText());
		int tamanio = Integer.parseInt(this.tamanio.getText());
		this.padre.jugar(numMinas,tamanio);
		
	}

}
