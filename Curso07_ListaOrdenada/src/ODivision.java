
public class ODivision extends Operador {
	
	public ODivision() {
		super('/');
	}

	@Override
	public Numero calcula() {
		return new Numero(super.getOperando1().getValor() / super.getOperando2().getValor());
	}

}
