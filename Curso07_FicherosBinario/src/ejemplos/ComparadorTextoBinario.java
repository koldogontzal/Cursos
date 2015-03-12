package ejemplos;

import java.io.*;

public class ComparadorTextoBinario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File fTexto = new File("prueba.txt");
		File fBinario = new File("prueba.dat");
		
		crearFicheroTexto(fTexto);
		crearFicheroBinario(fBinario);
		
		System.out.println("¿Tienen el mismo contenido? " + ficherosMismoContenido(fTexto, fBinario));
	}

	public static boolean ficherosMismoContenido(File texto, File binario) {
		
		boolean devolver = false;
		try {
			// Binario
			FileInputStream fis = new FileInputStream(binario);
			DataInputStream dis = new DataInputStream(fis);
			
			// Texto
			FileReader fr = new FileReader(texto);
			BufferedReader br = new BufferedReader(fr);
			
			devolver = true;
			devolver = devolver && (dis.readLine().equals(br.readLine()));
			//System.out.println(dis.readLine());
			//System.out.println(br.readLine());
			devolver = devolver && (dis.readInt() == Integer.parseInt(br.readLine()));
			//System.out.println(dis.readInt());
			//System.out.println(br.readLine());
		
			dis.close();
			fis.close();
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();			
		}
		
		
		return devolver;
	}

	private static void crearFicheroTexto(File f) {
		// Asocia fichero stream
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			// Crea stream especializado (no es necesario pero si conveniente)
			PrintWriter sw = new PrintWriter(fw);			
			
			sw.write("Hola qué tal\n");
			sw.write("23\n");
			
			
			
			// Ahora hay que cerrar todo, en orden inverso
			sw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	private static void crearFicheroBinario(File f) {
		try {
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeBytes("Hola qué tal\n");
			dos.writeInt(23);
			
			dos.close();
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

}
