package ejercicio;

public class Rectangulo extends Figura {
	
	private double l2;

	public Rectangulo(double ancho, double largo) {
		super(ancho);
		this.l2 = largo;
	}

	@Override
	public double area() {
		return this.l2 * super.getL1();
	}

	@Override
	public double perimetro() {
		return 2 * (this.l2 + super.getL1());
	}

	@Override
	public void visualiza() {
		System.out.println("Rectángulo de dimensiones " + this.l2 + "x" + super.getL1());

	}

}
