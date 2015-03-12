
public class EjemploRunnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EjemploRunnable app = new EjemploRunnable();
		app.comenzar();
	}

	private void comenzar() {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Proceso(1000 + i));
			t.start();
		}
	}
}

class Proceso implements Runnable {

	private int id;
	
	public Proceso(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Proceso " + this.id + ". Contador " + i);
			try {
				Thread.sleep((int)(Math.random() * 2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}