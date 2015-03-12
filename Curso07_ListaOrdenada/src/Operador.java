
public abstract class Operador extends Dato {

	private Numero operando1;
	private Numero operando2;
	private char simbolo;
	
	public Operador(char s) {
		this.simbolo = s;
	}
	
	public void setOperando1(Numero o) {
		this.operando1 = o;
	}
	
	public void setOperando2(Numero o) {
		this.operando2 = o;
	}
	
	public Numero getOperando1() {
		return this.operando1;
	}
	
	public Numero getOperando2() {
		return this.operando2;
	}
	
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		Operador o = (Operador)obj;
		return (o.simbolo == this.simbolo);
	}

	@Override
	public String toString() {
		return "" + this.simbolo;
	}
	
	public abstract Numero calcula();

}
