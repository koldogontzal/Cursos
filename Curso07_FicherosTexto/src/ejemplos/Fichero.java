package ejemplos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class Fichero {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Crea el fichero
		File f = new File("hola.txt");
		
		// Asocia fichero stream
		FileWriter fw = new FileWriter(f, true); // Este true hace que se añadan cosas en vez de machacar lo que había en el fichero

		// Crea stream especializado (no es necesario pero si conveniente)
		PrintWriter sw = new PrintWriter(fw);
		sw.write("Mameluco tercer");
		sw.write("\nOtra linea");
		
		// Ahora hay que cerrar todo, en orden inverso
		sw.close();
		fw.close();
		// File no tiene que cerrarse.
		
		
		// Ahora voy a leer
		File f2 = new File("hola.txt");
		
		// Asocia fichero al stream
		FileReader fr = new FileReader(f2);
		
		//Creo el stream adecuado
		BufferedReader br = new BufferedReader(fr);
		
		// Leo
		System.out.println(br.readLine());
		
		//Cierro todo
		br.close();
		fr.close();
		
	}

}
