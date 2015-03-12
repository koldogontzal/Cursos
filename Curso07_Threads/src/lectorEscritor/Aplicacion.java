package lectorEscritor;

public class Aplicacion {

	public static void main(String[] args) {
		Buffer recurso = new Buffer(20);
		
		Lector lector = new Lector();
		lector.asocia(recurso);
		Thread l = new Thread(lector);
		
		Escritor escritor = new Escritor();
		escritor.asocia(recurso);
		Thread e = new Thread(escritor);
		
		Pintor pintor = new Pintor();
		pintor.asocia(recurso);
		Thread p = new Thread(pintor);
		
		e.start();
		l.start();
		p.start();
		
	}

}
