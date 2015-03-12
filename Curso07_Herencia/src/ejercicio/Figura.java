package ejercicio;

public abstract class Figura {

	private double l1;
	
	public Figura(double v) {
		this.l1 = v;
	}
	
	protected double getL1() {
		return this.l1;
	}
	
	public abstract double area();
	public abstract double perimetro();
	public abstract void visualiza();
	
}
