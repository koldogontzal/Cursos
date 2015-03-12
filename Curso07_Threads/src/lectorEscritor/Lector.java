package lectorEscritor;

public class Lector extends Proceso {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			Pantalla.println("LECTOR ha leído: " + super.leer());
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
