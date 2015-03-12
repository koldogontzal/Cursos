package lectorEscritor;

public class Escritor extends Proceso {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			int dato = (int)(Math.random()*100);
			super.escribir(dato);
			Pantalla.println("ESCRITOR ha esrito: " + dato);
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
