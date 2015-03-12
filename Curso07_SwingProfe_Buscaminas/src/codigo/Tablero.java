package codigo;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JPanel {
	
	private Celda[][] tablero;
	private int tamanio;
	private int numMinas;
	private static double probabilidad = 0.40;
	
	public Tablero(int tam, int dificultad){
		super();
		GridLayout layout = new GridLayout(tam,tam);
		this.setLayout(layout);
		this.tamanio = tam;
		this.numMinas = dificultad;
		this.tablero = new Celda[tam][tam];		
		
		for (int i=0; i<tam; i++)
			for (int j=0; j<tam; j++){
				this.tablero[i][j] = new Celda(i*this.tamanio+j,Celda.VACIO);
				this.tablero[i][j].addMouseListener(new MouseAdapter(){
					
					public void mouseClicked(MouseEvent evento){
						Celda celda = (Celda)evento.getSource();
						if (evento.getButton() == MouseEvent.BUTTON1)
							/** boton izquierdo pulsado */
							botonIzquierdoPulsado(celda);
						else
							if (evento.getButton() == MouseEvent.BUTTON3)
								/** boton derecho pulsado */
								botonDerechoPulsado(celda);						
					}
					
				});
				this.add(this.tablero[i][j]);				
			}	
		this.repartirMinas(tam*tam);
		this.setMinimumSize(new Dimension(50*this.tamanio,50*this.tamanio));
	}
	
	private void repartirMinas(int longitud){
		LinkedList lista = new LinkedList();
		Random r = new Random();
		int numAleatorio = 0;
		int x;
		int y;
		for (int i=0; i<longitud; i++)
			lista.add(""+i);
		
		for (int i=this.numMinas; i>0; i--){		
			numAleatorio = r.nextInt(lista.size());
			lista.remove(numAleatorio);
			x = numAleatorio / this.tamanio;
			y = numAleatorio % this.tamanio;
			this.tablero[x][y].setContenido(Celda.MINA);			
		}
		
	}
	
	private int calcularMinas(int x, int y){
		int result = 0;
		for (int i=-1; i<2; i++)
			for (int j=-1; j<2; j++)
				if ((i!=0) || (j!=0)) //La propia celda no cuenta
					if (x+i>=0 && x+i<this.tamanio && y+j>=0 && y+j<this.tamanio) //Si no me salgo de los limites del tablero
						result += this.tablero[x+i][y+j].esMina()?1:0;
		
		return result;		
	}
	
	public void botonIzquierdoPulsado(Celda celda){		
		int x = celda.getX(this.tamanio);
		int y = celda.getY(this.tamanio);		
		int numMinas = calcularMinas(x,y);
		double prob = this.probabilidad; /** Probabilidad de abrir hueco*/
		if (celda.esMina())
			this.mostrarMinas();
		else{						
			JLabel etiq = celda.pulsar(numMinas);			
			this.abrirHueco(x,y,prob);
			if (etiq != null){
				int id = celda.getId();
				this.remove(id);
				this.add(etiq,id);
				this.validate();
				this.repaint();
			}
		}
	}
	
	private void abrirHueco(int x, int y, double prob){
		int posX;
		int posY;
		for (int i=-1; i<2; i++)
			for (int j=-1; j<2; j++){
				posX = x+i;
				posY = y+j;
				if ((i!=0 || j!=0) && (posX >= 0 && posX < this.tamanio && posY>=0 && posY < this.tamanio))
					if (!this.tablero[posX][posY].esMina() && this.tablero[posX][posY].getEstado() != Celda.PULSADO){
						Random r = new Random();
						double numAleatorio = r.nextInt(100) / 100.0;						
						if (numAleatorio < prob){
							int numMinas = this.calcularMinas(posX, posY);
							JLabel etiq = this.tablero[posX][posY].pulsar(numMinas);
							if (etiq != null){
								int id = this.tablero[posX][posY].getId();
								this.remove(id);
								this.add(etiq,id);
								this.validate();
								this.repaint();
							}							
							this.abrirHueco(posX, posY, prob/3.0);
						}
					}
			}
					
		
	}
	
	private void mostrarMinas(){
		JLabel etiq;
		for (int i=0; i<this.tamanio; i++)
			for (int j=0; j<this.tamanio; j++){
				if (this.tablero[i][j].esMina()){
					etiq = this.tablero[i][j].pulsar(0);
					if (etiq != null){
						int id = tablero[i][j].getId();
						this.remove(id);
						this.add(etiq,id);
						this.validate();
						this.repaint();
					}					
				}
				this.tablero[i][j].desactivar();
			}
	}
	
	public void botonDerechoPulsado(Celda celda){
		celda.marcar();		
	}
	
}
