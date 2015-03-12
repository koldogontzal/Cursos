
public class OResta extends Operador {
	
	public OResta() {
		super('-');
	}

	@Override
	public Numero calcula() {
		return new Numero(super.getOperando1().getValor() - super.getOperando2().getValor());
	}

}
