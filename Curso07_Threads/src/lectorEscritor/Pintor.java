package lectorEscritor;

public class Pintor extends Proceso {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {			
			super.pintaBuffer();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
