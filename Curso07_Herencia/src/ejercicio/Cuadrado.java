package ejercicio;

public class Cuadrado extends Rectangulo {

	public Cuadrado(double lado) {
		super(lado, lado);
	}
	
	@Override
	public void visualiza() {
		System.out.println("Cuadrado de lado " + super.getL1());
	}

}
