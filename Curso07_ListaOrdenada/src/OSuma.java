
public class OSuma extends Operador {
	
	public OSuma() {
		super('+');
	}

	@Override
	public Numero calcula() {
		return new Numero(super.getOperando1().getValor() + super.getOperando2().getValor());
	}

}
