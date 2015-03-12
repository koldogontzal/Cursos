package tablero;

import ficha.Ficha;

public class Casilla {
	
	Ficha f;
	
	public Casilla() {
		this.f = null;
	}
	
	public void asociaFicha(Ficha f) {
		this.f = f;
	}
	
	@Override
	public String toString() {
		if (this.vacia()) {
			return " ";
		} else {
			return "" + this.f;
		}
	}

	public boolean vacia() {
		return (this.f == null);
	}
	
	public Ficha getFicha() {
		return this.f;
	}

	public void quitaFicha() {
		this.f = null;
	}

}
