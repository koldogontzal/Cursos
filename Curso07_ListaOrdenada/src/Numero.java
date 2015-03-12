
public class Numero extends Dato {
	
	private double val;
	
	public Numero(double v) {
		this.val = v;
	}
	
	@Override
	public int compareTo(Object o) {
		return Double.valueOf(this.val).compareTo(Double.valueOf(((Numero)o).getValor()));
	}

	public double getValor() {
		return this.val;
	}

	@Override
	public boolean equals(Object obj) {
		Numero n = (Numero)obj;
		
		return (this.val == n.getValor());
	}

	@Override
	public String toString() {
		return "" + this.val;
	}

}
