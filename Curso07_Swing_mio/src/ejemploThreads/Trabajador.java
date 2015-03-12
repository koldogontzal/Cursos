package ejemploThreads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.SwingWorker;

public class Trabajador extends SwingWorker {

	@Override
	protected Object doInBackground() throws Exception {
		// Tarea larga
		System.out.println("Entramos en tarea larga");
		try {
			byte[] buffer = new byte[1000];
			FileInputStream fis = new FileInputStream(new File("docs/musica.mp3"));
			while(fis.available() > 0) {
				fis.read(buffer);
				for (int i = 0; i < buffer.length; i++) {
					System.out.println(buffer[i]);
				}				
			}
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Salimos de tarea larga");
		return null;
	}

}
