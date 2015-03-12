package datagramas;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

public class ListadoNombres extends HashMap<String, InetAddress> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -232600134708112L;

	private HashMap<InetAddress, String> listaInversa;
	
	//private static final int 
	
	private String[] listaNombres = new String[7];
	private InetAddress[] listaDireciones = new InetAddress[10];
	
	public ListadoNombres() {
		
		this.listaInversa = new HashMap<InetAddress, String>();

		// Añade Gente
		try {		
					this.listaNombres[0] = "victor";
					this.listaNombres[1] = "luis";
					this.listaNombres[2] = "stephane";
					this.listaNombres[3] = "coco";
					this.listaNombres[4] = "esther";
					this.listaNombres[5] = "gonzalo";
					this.listaNombres[6] = "angel";
			

					this.listaDireciones[0] = InetAddress.getByName("138.100.158.94");
					this.listaDireciones[1] = InetAddress.getByName("138.100.158.99");
					this.listaDireciones[2] = InetAddress.getByName("138.100.158.96");
					this.listaDireciones[3] = InetAddress.getByName("138.100.158.89");
					this.listaDireciones[4] = InetAddress.getByName("138.100.158.127");
					this.listaDireciones[5] = InetAddress.getByName("138.100.158.100");
					this.listaDireciones[6] = InetAddress.getByName("138.100.158.102");

			
			for (int i = 0; i < this.listaNombres.length; i++) {
				// Lista directa
				this.put(this.listaNombres[i], this.listaDireciones[i]);
				
				// Lista inversa
				this.listaInversa.put(this.listaDireciones[i], this.listaNombres[i]);	
			}			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	

	public String getInverso(InetAddress key) {
		return this.listaInversa.get(key);
	}
	
	public String putInverso(InetAddress key, String value) {
		return this.listaInversa.put(key, value);
	}
}
