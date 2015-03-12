package codigo;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Celda extends JButton {
	public static int MINA = 0;
	public static int VACIO = 1;
	public static int SIN_PULSAR = 0;
	public static int PULSADO = 1;
	public static int MARCADO = 2;
	
	private int id;
	private int contenido;
	private int estado;
	private String imagenMina;
	private String imagenCheck;
	
	public Celda(int id, int contenido){
		super();
		this.id = id;
		this.imagenMina = "imagenes/mina.jpg";
		this.imagenCheck = "imagenes/check.jpg";	
		this.estado = Celda.SIN_PULSAR;
		this.contenido = contenido;
	}
	
	public void marcar(){
		if (this.estado == Celda.SIN_PULSAR){
			this.setIcon(new ImageIcon(this.imagenCheck));
			this.estado = Celda.MARCADO;
		} else 
			if (this.estado == Celda.MARCADO){
				this.setIcon(null);
				this.estado = Celda.SIN_PULSAR;
			}
		
	}
	
	public JLabel pulsar(int numMinas){
		this.estado = Celda.PULSADO;
		JLabel etiq = null;
		
		if (this.contenido == Celda.MINA)
			etiq = new JLabel(new ImageIcon(this.imagenMina));
		else
			if (this.contenido == Celda.VACIO)
				if (numMinas != 0)
					etiq = new JLabel(""+numMinas, javax.swing.SwingConstants.CENTER);
				else
					etiq = new JLabel();
		
		if (etiq != null)
			etiq.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
		return etiq;
	}
	
	public int getX(int tam){		
		return this.id/tam;
	}
	
	public int getY(int tam){		
		return this.id % tam;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getContenido(){
		return this.contenido;
	}
	
	public boolean esMina(){
		return (this.contenido == Celda.MINA);
	}
	
	public void setContenido(int contenido){
		this.contenido = contenido;
	}
	
	public void setEstado(int estado){
		this.estado = estado;
	}
	
	public void desactivar(){
		MouseListener[] lista = this.getMouseListeners();
		for (int i=0; i<lista.length; i++)
			this.removeMouseListener(lista[i]);		
	}
	
	public int getEstado(){
		return this.estado;
	}

}
