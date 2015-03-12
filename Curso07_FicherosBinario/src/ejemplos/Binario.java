package ejemplos;

import java.io.*;

public class Binario {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// Escribir
		File f = new File("fich.dat");
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeChar('k');
		dos.writeInt(15);
		dos.writeBytes("ddd");
		//dos.writeChars("ddd");
		
		dos.close();
		dos.close();	
		
		
		// Leer
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		
		byte kk[] = new byte[20];
		
		System.out.println(dis.readChar());
		System.out.println(dis.readInt());
		System.out.print(dis.readLine());
		/*
		System.out.print(dis.readChar());
		System.out.print(dis.readChar());
		
		*/
		dis.close();
		fis.close();
		
	}

}
