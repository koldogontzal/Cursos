package ejemplo05ServidorWeb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorThread extends Thread {
	
	private Socket soc;
	
	public ServidorThread(Socket s) {
		this.soc = s;
	}
	
	@Override
	public void run() {
		super.run();
		
		BufferedReader in;
		try {
			// Leo el texto que me manda el cliente
			// Me interesa unicamente la primera linea			
			in = new BufferedReader(new InputStreamReader(this.soc.getInputStream()));
			String linea = in.readLine();
			// El resto de lineas me dan informacion que no necesito, así que las leo pero no las guardo

			@SuppressWarnings("unused")
			String basura;			
			while (!(basura = in.readLine()).equals("")) {
				//System.out.println(basura);
			}
			
			// De la primera linea, solo necesito el segundo elemento que es el que tiene el fichero
			String[] elementos = linea.split(" "); // Esto  lo divide por espacios
			// elementos[1] tiene el fichero que me pide
			// lo busco en mi directorio
			File fileArchivo = new File("html" + elementos[1]);
			if (fileArchivo.exists()) {
				// Existe el archivo, se lo mando
				this.mandaArchivo(fileArchivo);
			} else {
				// No existe el archivo, mando un error
				this.mandarError404();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mandaArchivo(File fileArchivo) throws IOException {
		// Devuevlo mi respuesta
		this.responderGeneral("HTTP/1.1 200 OK", fileArchivo);
	}
	
	private void mandarError404() throws IOException {
		// Devuevlo mi respuesta
		File fileError = new File("html/error404.html");
		this.responderGeneral("HTTP/1.1 404 NOT FOUND", fileError);
	}
	
	private void responderGeneral(String mensajeRespuesta, File file) throws IOException {
		// Devuelvo mi respuesta
		PrintWriter out = new PrintWriter(new OutputStreamWriter(this.soc.getOutputStream()));
		out.println(mensajeRespuesta);
		out.println("Content-type: text/html");
		// Lee del disco el archivo que me han pedido
		String archivo = this.leeArchivoDisco(file);
		out.println("Content-length: " + archivo.length());
		out.println();// Tiene que haber una linea vacia entre las cabeceras y el contenido
		out.println(archivo); // Contenido		
		out.flush();
		out.close();
	}

	private String leeArchivoDisco(File fileArchivo) throws IOException {
		String ret = "";		
		BufferedReader in = new BufferedReader(new FileReader(fileArchivo));
		String linea;
		while ((linea = in.readLine()) != null) {
			ret = ret + linea + "\n";
		}
		in.close();
		return ret;
	}

}
