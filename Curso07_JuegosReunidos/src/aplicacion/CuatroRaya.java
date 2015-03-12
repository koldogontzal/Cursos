package aplicacion;

import coordenada.Coordenada;
import ficha.Ficha;
import jugador.Jugador;
import tablero.Tablero4R;
import teclado.Teclado;
import turno.Turno;

public class CuatroRaya extends Aplicacion {
	
	private Jugador[] jugadores;
	private Tablero4R tablero;
	
	public CuatroRaya() {
		this.tablero = new Tablero4R();
		this.jugadores = new Jugador[2];
		this.jugadores[0] = new Jugador(32, 'X');
		this.jugadores[1] = new Jugador(32, 'O');
	}

	@Override
	public void comenzar() {
		boolean hayGanador = false;
		Turno t = new Turno(2);
		int[] numFichJug = {0, 0};
		while (!hayGanador) {
			// Dibujo el tablero
			System.out.println(this.tablero);
			// pido columna
			System.out.println("Juega el jugador " + this.jugadores[t.getTurno()].getColor());
			System.out.print("¿En qué columna pones ficha? ");
			int col = Teclado.leeEntero();			
			// Pongo ficha
			Coordenada c = this.tablero.dameCoordenadaMasAltaDeColumna(col);
			int jugador = t.getTurno();
			Ficha f = this.jugadores[jugador].dameFicha(numFichJug[jugador]);
			this.tablero.ponFicha(c, f);
			numFichJug[jugador]++;			
			// compruebo si hay ganador
			if (this.buscarGanador(this.jugadores[jugador])) {
				hayGanador = true;
			} else {
				// cambio turno
				t.cambiaTurno();
			}
		}
		System.out.println(this.tablero);
		System.out.println("Ha ganado el jugador " + this.jugadores[t.getTurno()].getColor());
	}

	private boolean buscarGanador(Jugador j) {
		return this.tablero.buscaGanador(j.getColor());
	}

}
