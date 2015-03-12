package ejercicio;

public class Aplicacion {

	public static void main(String[] args) {
		
		Figura[] fig = new Figura[3];
		
		fig[0] = new Circulo(6);
		fig[1] = new Cuadrado(5);
		fig[2] = new Rectangulo(3, 4);
		
		for (int i=0; i<3; i++) {
			fig[i].visualiza();
			System.out.println("\tÁrea: "+ fig[i].area());
			System.out.println("\tPerímetro: " + fig[i].perimetro());
			System.out.println();
		}
		
	}
}
