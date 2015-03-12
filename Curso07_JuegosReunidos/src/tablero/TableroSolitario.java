package tablero;

import coordenada.Coordenada;
import ficha.Ficha;

public class TableroSolitario extends Tablero {

	public TableroSolitario() {
		super(5, 5);
	}

	public void mueveFicha(Coordenada origen, Coordenada destino) {
		Ficha f = super.getCasilla(origen).getFicha();
		
		super.ponFicha(destino, f);
		
		this.quitaFicha(origen);
		
		
	}

	public void quitaFicha(Coordenada comida) {
		super.getCasilla(comida).quitaFicha();
	}
	
	

}
