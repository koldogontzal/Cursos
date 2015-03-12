/** 
 * <p>Fichero: TestClient.java</p>
 * <p>Descripción: </p>
 * <p>Empresa: Telvent Interactiva </p>
 * <p>Fecha creación: 02-dic-2005</p>
 * @author SERYS
 * @version 1.0
 * 
 */

/*
 * Copyright 2001-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//package samples.userguide.example1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class TestClient {
	
   public static void main(String [] args) {
	   
       try {
    	   
			Hashtable hWSParams = readWSParameters();
			if (hWSParams!=null) {

				// Obtener el almacén de confianza SSL para conectar a los WS via HTTPS
				String ruta_trusted_cacerts = (String)hWSParams.get("SSL.trustStore");
				if (ruta_trusted_cacerts!=null) {
					System.setProperty("javax.net.ssl.trustStore",ruta_trusted_cacerts);
					System.out.println("Se ha localizado el almacén de confianza SSL en " + ruta_trusted_cacerts);
				}
				else {
					System.out.println("No se ha encontrado el almacén de confianza SSL. No se podrá invocar a los WebServices por HTTPS.");
				}

				// Invocación al servicio
				String endpoint_base = (String)hWSParams.get("endPoint.url.base");
				String endpoint_service = (String)hWSParams.get("webservices.service");
				String endpoint_requestXML = (String)hWSParams.get("webservices.request");
				String endpoint_responseXML = (String)hWSParams.get("webservices.response");

				if (endpoint_base!=null && endpoint_service!=null && endpoint_requestXML!=null) {
					
					String endpoint = endpoint_base + endpoint_service;
					System.out.println("\nENDPOINT: " + endpoint);
					Service  service = new Service();
					Call     call    = (Call) service.createCall();

					call.setTargetEndpointAddress( new java.net.URL(endpoint) );
					call.setOperationName(new QName("http://soapinterop.org/", endpoint_service) );

			   		String paramIn = leeFichero(endpoint_requestXML);

					System.out.println("PETICION: " + paramIn);

		            String ret = (String) call.invoke( new Object[] { paramIn } );

					System.out.println("RESPUESTA: " + ret);
					System.out.println("\nPetición XML correctamente recuperada desde: " + endpoint_requestXML);

					if (endpoint_responseXML!=null) {
						writeToFile(endpoint_responseXML,ret.getBytes());
						System.out.println("Respuesta XML correctamente recuperada en: " + endpoint_responseXML);
					}
				}
				else {
					System.out.println("No se han podido encontrar los parámetros necesarios en el fichero de propiedades.");
				}
			}

       }
       catch (Exception e) {
    	   System.out.println("ERROR: " + e.toString());
       }
   }
   
	static void writeToFile(String fileName, byte[] buffer) throws Exception {	
    	FileOutputStream f = new FileOutputStream(fileName);
    	f.write(buffer);
    	f.close();
	}    

	static Hashtable readWSParameters () throws FileNotFoundException, IOException {
	
		Properties props = new Properties();
		props.load(TestClient.class.getResourceAsStream("webservices.properties"));
	
		Hashtable h = new Hashtable();
		for (Enumeration e = props.keys(); e.hasMoreElements() ; ) {
		    String key = (String)e.nextElement();
		    String value = (String)props.getProperty(key);
		    h.put(key, value);
		}
		return h;
	
	}
	
	static String leeFichero (String urlFichero) {
		
		try {
			BufferedReader in  = new BufferedReader(new FileReader(urlFichero));
			String leidoAux = "";
			String fichero = "";
			
			leidoAux = in.readLine();
			while (leidoAux != null) {
			  	fichero += leidoAux; 
				leidoAux = in.readLine();
			}
			
			if (fichero != null && fichero.trim().length()>0) {
				return fichero.toString();
			}
		}
		catch (Exception e) {
			System.out.println("ERROR: No se ha podido leer el fichero: " + urlFichero);
			System.exit(1);
		}
		return null;
   }

}

