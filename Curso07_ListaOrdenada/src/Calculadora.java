
public class Calculadora extends Pila {
	
	public Calculadora() {
		super();
	}
	
	public double calcular() {
		double val = 0;
		
		while (super.numElementos() > 1) {
			Dato n1 = super.pop();
			Numero n2 = (Numero)super.pop();
			Operador o = (Operador)super.pop();
			
			//o.setOperando1(n1);
			o.setOperando2(n2);
			Numero n = o.calcula();
			
			System.out.println(n1 + " " + n2 + " " + n);
			
			super.push(n);
			val = n.getValor();
		}
		return val;
	}
	
	public void crearpila() {
		super.push(new OMultiplicacion());
		super.push(new Numero(1.5));
		super.push(new Numero(8));
		
		
	}

}
