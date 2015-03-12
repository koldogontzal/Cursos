
public class EjemploThread {
	public static void main(String[] args) {
		EjemploThread app = new EjemploThread();
		app.empieza();
	}

	private void empieza() {
		// Ejecuta cada una de estas en paralelo
		MiTarea mt = new MiTarea(1);
		mt.start();
		
		MiTarea mt2 = new MiTarea(21);
		mt2.start();
		
		MiTarea mt3 = new MiTarea(761);
		mt3.start();
		
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);
		}
	}
}

class MiTarea extends Thread {
	private int id;
	
	public MiTarea(int id) {super(); this.id = id;}
	
	public void run() {
		// Esto es lo que se ejecuta en paralelo
		// Hay que sobreescribir el método run() de esta forma
		for (int i = 0; i < 1000; i++) {
			System.out.println("Esto es la otra tarea " + this.id + " (" + i + ")");
			try {
				Thread.sleep((int)(Math.random()*2000.0));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}