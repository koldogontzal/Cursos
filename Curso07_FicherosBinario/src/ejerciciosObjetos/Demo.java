package ejerciciosObjetos;

import java.io.*;

public class Demo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Persona p = new Persona("Pepe");
		Coche c = new Coche("M-31416");
		
		p.asociaCoche(c);
		
		System.out.println(p);
		
		//// Escribir el objeto en fichero	
		File f = new File("personas.dat");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(p);
		
		oos.close();
		fos.close();
		
		
		/// Leer el objeto
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		// Hay que hacer siempre el casting
		Persona pLectura = (Persona)ois.readObject();
		
		ois.close();
		fis.close();
		
		System.out.println(pLectura);		
	}
}
