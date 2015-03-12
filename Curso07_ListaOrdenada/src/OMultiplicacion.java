
public class OMultiplicacion extends Operador {
	
	public OMultiplicacion() {
		super('*');
	}

	@Override
	public Numero calcula() {
		return new Numero(super.getOperando1().getValor() * super.getOperando2().getValor());
	}

}
