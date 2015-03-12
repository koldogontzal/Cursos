package ejemplo01;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JLienzo extends JPanel {
	public JLienzo() {
		super();
		this.setBackground(Color.gray);
		
		JButton boton2 = new JButton("Pinchar");
		JButton boton = new JButton("aceptar");
		boton.setToolTipText("Este es el texto que te da ayuda, mam�n");
		boton.setEnabled(false);
	
		boton.setIcon(new ImageIcon("imagenes/aceptar.gif"));
		
		
		JLabel etiqueta1 = new JLabel("Nombre: ");
		JTextField campoNombre = new JTextField("Geben sie hier Text ein");
		//campoNombre.setEditable(false);
		campoNombre.setText("Ein anderes Text");
		campoNombre.setColumns(15);
		
		JPasswordField password = new JPasswordField(2);
		
		
		JLabel etiqueta2 = new JLabel();
		etiqueta2.setText("Petad: ");
		JLabel etiqueta3 = new JLabel(new ImageIcon("imagenes/aceptar.gif"));
		
		JComboBox combo = new JComboBox();
		for (int i = 1900; i < 2000; i++ ) {
			combo.addItem(i);
		}
		
		Object [] agnos = new Object[100];
		for (int i = 0; i < 100; i++) {
			agnos[i] = i + 1900;
		}
		JComboBox combo2 = new JComboBox(agnos);
		
		JCheckBox javaCheck1 = new JCheckBox("Java", true);
		javaCheck1.setBackground(Color.gray);
		javaCheck1.setForeground(Color.cyan);
		JCheckBox javaCheck2 = new JCheckBox("Picha", false);
		JCheckBox javaCheck3 = new JCheckBox("Brave", new ImageIcon("imagenes/aceptar.gif"));

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.lightGray);
		panel.add(new JLabel("Controles de encencido"));
		panel.add(new JButton("on"));
		panel.add(new JButton("off"));
		
		
		this.add(javaCheck1);
		this.add(javaCheck2);
		this.add(javaCheck3);
		
		this.add(combo2);
		this.add(combo);
		this.add(etiqueta3);
		this.add(boton);
		this.add(boton2);

		this.add(etiqueta1);
		this.add(campoNombre);
		this.add(etiqueta2);
		this.add(password);
		
		this.add(panel);
		
		boton.setEnabled(true);
		//boton2.setVisible(false);
		
	}

}
