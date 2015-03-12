package ejSingleton;

public class Demo {

	public static void main(String[] args) {
		Singleton s1 = Singleton.get();
		Singleton s2 = Singleton.get();
		
		System.out.println("s1 " + s1.dameValor() + " puntero: " + s1);
		System.out.println("s2 " + s2.dameValor() + " puntero: " + s2);
	}

}
