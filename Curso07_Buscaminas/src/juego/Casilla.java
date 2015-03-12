package juego;

public class Casilla {

	private boolean levantada;
	private int numBombasAlrededor;
	private boolean bomba;
	
	public Casilla() {
		this.levantada = false;
		this.bomba = false;
		this.numBombasAlrededor = 0;
	}
	
	public void ponBomba() {
		this.bomba = true;
		
	}

	public boolean tienesBomba() {
		return this.bomba;
	}

	public void setNumBombas(int numBombas) {
		this.numBombasAlrededor = numBombas;
	}

	public void visualiza() {
		if (this.levantada) {
			if (this.bomba) {
				System.out.print('B');
			} else {
				if (this.numBombasAlrededor != 0) {
					System.out.print(this.numBombasAlrededor);
				} else {
					System.out.print(' ');
				}
			}
		} else {
			System.out.print('X');
/*										if (this.bomba) {
											System.out.print('B');
										} else {
											if (this.numBombasAlrededor != 0) {
												System.out.print(this.numBombasAlrededor);
											} else {
												System.out.print(' ');
											}
										}
*/
		}
	}

	public void levanta() {
		this.levantada = true;		
	}

	public boolean agua() {
		return ((this.numBombasAlrededor == 0) && (!this.bomba));
	}

	public boolean estaLevantada() {
		return this.levantada;
	}
}
