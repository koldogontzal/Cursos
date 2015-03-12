package ejercicio;

public class Circulo extends Figura {

	public Circulo(double rad) {
		super(rad);
	}

	@Override
	public double area() {
		return Math.PI * super.getL1() * super.getL1();
	}

	@Override
	public double perimetro() {
		return Math.PI * 2 * super.getL1();
	}

	@Override
	public void visualiza() {
		System.out.println("Círculo de radio " + super.getL1());
	}

}
