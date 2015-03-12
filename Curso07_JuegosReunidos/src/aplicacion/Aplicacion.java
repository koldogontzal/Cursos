package aplicacion;

import teclado.Teclado;

public abstract class Aplicacion {

	public static void main(String[] args) {
		System.out.println("Juegos reunidos");
		System.out.println("===============");
		System.out.println();
		System.out.println("1.- Cuatro en raya");
		System.out.println("2.- Solitario");
		System.out.println();
		System.out.print("¿A qué quieres jugar? ");
		int resp = Teclado.leeEntero();
		Aplicacion app;
		if (resp == 1) {
			app = new CuatroRaya();
		} else if (resp == 2){
			app = new Solitario();
		} else {
			// Por defecto, Cuatro en Raya
			app = new CuatroRaya();
		}
		app.comenzar();
		
	}
	
	public abstract void comenzar();

}
