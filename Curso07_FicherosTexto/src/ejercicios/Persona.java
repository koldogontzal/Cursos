package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Persona {

	/**
	 * @param args
	 */
	private String nombre;
	private long dni;
	
	public Persona(String n, long d) {
		this.nombre = n;
		this.dni = d;
	}
	
	public void visualiza() {
		System.out.print(this.nombre + " (" + this.dni + ")");
	}
	public static void main(String[] args) throws IOException {
		
		Persona p = new Persona("Ramón García", (long)(Math.random() * 100000000l));
		
		File f = new File("Fichero.dat");
		
		// Graba datos
		// Asocia fichero stream
		FileWriter fw = new FileWriter(f, true); // Este true hace que se añadan cosas en vez de machacar lo que había en el fichero

		// Crea stream especializado (no es necesario pero si conveniente)
		PrintWriter pw = new PrintWriter(fw);
		
		// Escribe los datos
		pw.write(p.getNombre() + "\n");
		pw.write("" + p.getDni() + "\n");
		
		// Cierra todo
		pw.close();
		fw.close();
		
		// Ahora lo leería
		// Uso el mismo File		
		
		// Asocia fichero al stream
		FileReader fr = new FileReader(f);
		
		//Creo el stream adecuado
		BufferedReader br = new BufferedReader(fr);
		
		// Leo 		
		String nombre=null;
		while( (nombre= br.readLine()) != null ) { 
			long dni = Long.parseLong(br.readLine());
			Persona p2 = new Persona(nombre, dni);
			
			p2.visualiza();
			System.out.println();
		}
		//Cierro todo
		br.close();
		fr.close();
		
		

	}

	public long getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

}
