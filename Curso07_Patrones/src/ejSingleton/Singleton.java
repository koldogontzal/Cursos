package ejSingleton;

public final class Singleton {

	private static Singleton laInstancia = new Singleton();
	
	private int valor;
	
	private Singleton() {
		this.valor = (int)(Math.random() * 1000);
	}
	
	public static Singleton get() {
		return Singleton.laInstancia;
	}

	public int dameValor() {
		return this.valor;
	}
}
