package aplicacion;

import coordenada.Coordenada;
import ficha.Ficha;
import jugador.Jugador;
import tablero.TableroSolitario;
import teclado.Teclado;

public class Solitario extends Aplicacion {
	
	private TableroSolitario tablero;
	
	private Jugador jugador;

	public Solitario() {
		this.tablero = new TableroSolitario();
		this.jugador = new Jugador(24, 'O');
		
		// inicio las fichas en el tablero
		int numFichasPuestas = 0;
		for (int i = 0; i < this.tablero.getNumFilas(); i++) {
			for (int j = 0; j < this.tablero.getNumColumnas(); j++) {
				if ((i != 2) || (j != 2)) {
					Ficha f = this.jugador.dameFicha(numFichasPuestas);
					Coordenada c = new Coordenada(i, j);
					this.tablero.ponFicha(c, f);
					numFichasPuestas++;
				}
			}
		}
	}

	@Override
	public void comenzar() {
		int numFichasQuedan = 24;
		
		while (numFichasQuedan > 1) {
			// Pinta el tablero
			System.out.println(this.tablero);
			// Pide coordenada de la ficha
			System.out.println("Introduce la coordenada de origen:");
			Coordenada cOrigen = Teclado.leeCoordenada();
			
			// Pide coordenada de destino (tiene que estar vacia)
			System.out.println("Introduce la coordenada de destino:");
			Coordenada cDestino = Teclado.leeCoordenada();
			
			
			// Mueve ficha
			this.tablero.mueveFicha(cOrigen, cDestino);
			
			// Elimina ficha comida
			Coordenada cComida = cOrigen.mediaCon(cDestino);
			this.tablero.quitaFicha(cComida);
			numFichasQuedan--;
			
		}
		
	}

}
