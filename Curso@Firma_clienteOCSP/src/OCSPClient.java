/*
Copyright (c) 2003 
Johannes Nicolai (johannes.nicolai@novosec.com)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
/*
Modified by Sainathan Sivasubramanian (sainathan@gmail.com) in Nov 2004 to support the following:
1. Add debuglog, writetofile methods
2. Include argument to receive responder cert as this code assumes mastercert(issuer of usercert) and responder are same
3. write request and response data to file in debug mode 
Note: Single line edits are prefixed by //Sai and multiline changes are suffixed with //End
* suggested change: include debug and nonce as command line options.
*/


//Sai
import java.io.FileOutputStream;
//End
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.net.URL;
import java.net.HttpURLConnection;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.ocsp.CertificateStatus;
import org.bouncycastle.ocsp.RevokedStatus;
import org.bouncycastle.ocsp.UnknownStatus;


public class OCSPClient {

	private static boolean debug = false;
	
	public static void main (String args[]) {
		
		boolean signed = false; 
		X509Certificate signer = null;
		X509Certificate[] certificates = new X509Certificate[1];
		PrivateKey signerPK = null;
		X509Certificate issuer = null;
		X509Certificate responder = null;
		try {

	        Security.addProvider(new BouncyCastleProvider());
			Hashtable hOCSPParams = readOCSPParameters();
			if (hOCSPParams!=null) {
				
				// Debug
				if ((hOCSPParams.get("debug")!=null) && (hOCSPParams.get("debug").equals("true"))) {
					debug = true;
					System.out.println("debug: ON\n");
				}
				else {
					System.out.println("debug: OFF\n");
				}
				
				// Inicialización para el uso de certificados X509
				CertificateFactory cf = CertificateFactory.getInstance("X509");
				
				// Obtener la clave privada del firmante de la petición OCSP
				String signerKeystoreType = (String)hOCSPParams.get("OCSPSigner.KS.type");
				String signerKeystoreFile = (String)hOCSPParams.get("OCSPSigner.KS.filename");
				String signerKeystorePassWD = (String)hOCSPParams.get("OCSPSigner.KS.password");
				String signerPKAlias = (String)hOCSPParams.get("OCSPSigner.KS.privkey.alias");
				String signerPKPassPW= (String)hOCSPParams.get("OCSPSigner.KS.privkey.password");
				if (signerKeystoreType!=null && signerKeystoreFile!=null && signerKeystorePassWD!=null
						&& signerPKAlias!=null && signerPKPassPW!=null) {
					signed = true;
					// Extraer información para firmar la petición OCSP
					KeyStore ks= KeyStore.getInstance(signerKeystoreType);
					ks.load(new FileInputStream(signerKeystoreFile),signerKeystorePassWD.toCharArray());
					signerPK = (PrivateKey)ks.getKey(signerPKAlias,signerPKPassPW.toCharArray());
					signer = (X509Certificate)ks.getCertificate(signerPKAlias);
					if (signer==null || signerPK==null) {
						System.out.println("ERROR: el alias " + signerPKAlias + " no existe!");
						System.exit(1);
					}
					debuglog("Certificado firmante petición OCSP: " + signer.getSubjectDN());
					
				}
				else {
					debuglog("No se encuentran todos los parámetros necesarios para firmar la petición OCSP. La petición NO se firmará.\n");
				}

				// Extraer información del certificado a firmar
				String certificateFile = (String)hOCSPParams.get("OCSPRequest.certificate.file");
				if (certificateFile!=null) {
					FileInputStream certfile =new FileInputStream(certificateFile);
					Collection certs=cf.generateCertificates(certfile);
					if (certs.size()==0) {
						System.out.println("ERROR: no se han encontrado certificados en el fichero: " + certificateFile);	
						System.exit(1);
					}			
					certificates = (X509Certificate[])certs.toArray(new X509Certificate[0]);			
					debuglog("Certificado a consultar:            " + certificates[0].getSubjectDN());
				}
			
				// Extraer información del certificado emisor
				String issuerFile = (String)hOCSPParams.get("OCSPRequest.issuer.file");
				if (issuerFile!=null) {
					FileInputStream masterfile =new FileInputStream(issuerFile);
					issuer = (X509Certificate)cf.generateCertificate(masterfile);
					if (issuer==null) {
						System.out.println("ERROR: no se ha encontrado el certificado emisor!!");	
						System.exit(1);
					}
					debuglog("Certificado emisor:                 " + issuer.getSubjectDN());						
				}
				
				// Extraer información del certificado responder
				String responderFile = (String)hOCSPParams.get("OCSPRequest.responder.certificate.file");
				if (responderFile!=null) {
					FileInputStream respfile =new FileInputStream(responderFile);
					responder = (X509Certificate)cf.generateCertificate(respfile);
					if (responder==null) {
						System.out.println("ERROR: no se ha encontrado el certificado responder!");	
						System.exit(1);
					}			
					debuglog("Certificado Responder:              " + responder.getSubjectDN());			
				}

				debuglog("\nPETICION");
				if (signed)
					debuglog("La petición será firmada usando " + signer);
				else
					debuglog("La petición NO va firmada.");

				// Incluir ID de aplicación para auditar
				String requestorName = (String)hOCSPParams.get("OCSPRequest.userToAudit");
				if (requestorName!=null) {
					debuglog("La petición incluye el ID [" + requestorName + "] como RequestorName para auditar la petición en @firma.");
				}
				else {
					debuglog("La petición NO incluirá el ID para auditar la petición en @firma.");
				}

				// Construyendo la petición 
				ClientOCSPDriver driv =new ClientOCSPDriver(signer,signerPK,certificates,issuer,responder);
				debuglog("Objeto ClientOCSPDriver construido.");
				byte[] ocspdata= driv.getRequest(requestorName);			
				debuglog("Petición OCSP completada.");			

				String saveRequest = (String)hOCSPParams.get("OCSPRequest.saveToFile");
				if (saveRequest!=null) {
					debuglog("Guardando la petición OCSP en: " + saveRequest);
					writeToFile(saveRequest, ocspdata);
				}
				
				// Realizando la llamada al OCSPResponder
				debuglog("\nRESPUESTA");
				String urlOCSP = (String)hOCSPParams.get("OCSPResponder.URL");
				if (urlOCSP!=null) {

					URL url= new URL(urlOCSP);
					HttpURLConnection con=(HttpURLConnection) url.openConnection();
					con.setAllowUserInteraction(false);
					con.setDoInput(true);
					con.setDoOutput(true);
					con.setUseCaches(false);
					con.setFollowRedirects(false);
					con.setRequestMethod("POST");
					con.setRequestProperty("Content-Length",Integer.toString(ocspdata.length));
					con.setRequestProperty("Content-Type","application/ocsp-request");
					OutputStream os=con.getOutputStream();
					os.write(ocspdata);
					con.connect();
					os.close();			
					
					if (con.getResponseCode()!=HttpURLConnection.HTTP_OK) {
						System.out.println("ERROR: la petición no ha sido aceptada! (código devuelto: " + con.getResponseCode() + ")");
						System.exit(1);
					}
					if (con.getContentType()==null||!con.getContentType().equals("application/ocsp-response")) {
						System.out.println("ERROR: la respuesta no es de tipo OCSPResponse!");
						System.exit(1);
					}
					int len=con.getContentLength();
					if (len<1) {
						System.out.println("ERROR: no hay respuesta en el OCSPResponse!");
						System.exit(1);
					}
					InputStream reader=con.getInputStream();
					byte [] ocsprespdata=new byte [len];
					int offset=0;
					int bytes_read;
					while ((bytes_read=reader.read(ocsprespdata,offset,len-offset))!=-1) {
						offset+=bytes_read;
						if(offset==len)
							break;
					}
					if (offset!=len) {
						System.out.println("ERROR: no es posible leer el OCSPResponse!");
						System.exit(1);
					}
					reader.close();			
					con.disconnect();

					debuglog("El servidor OCSPResponder [" + urlOCSP + "] ha contestado satisfactoriamente.");

					String saveResponse = (String)hOCSPParams.get("OCSPResponse.saveToFile");
					if (saveResponse!=null) {
						debuglog("Guardando la respuesta OCSP en: " + saveResponse);
						writeToFile(saveResponse, ocsprespdata);
					}
					
					HashMap certstat=driv.processResponse(ocsprespdata);
					System.out.println("---------------------------------");
					System.out.println("RESULTADO:");
					System.out.println();
					for (int i=0;i<certificates.length;++i) {
						System.out.println("Certificado "+(i+1)+": "+certificates[i].getSubjectX500Principal());
						CertificateStatus stat=(CertificateStatus)certstat.get(certificates[i]);
						if (stat==null)
							System.out.println("Estado: CORRECTO (good)");
						else if (stat instanceof UnknownStatus)
							System.out.println("Estado: DESCONOCIDO (unknown)");
						else if (stat instanceof RevokedStatus) {
							RevokedStatus rstat = (RevokedStatus) stat;
							System.out.println("Estado: REVOCADO (" + rstat.getRevocationTime() + ")");
							try {					
								System.out.println("Causa: "+(rstat.hasRevocationReason()?Integer.toString(rstat.getRevocationReason()):"Unknown"));
							}
							catch (IllegalStateException e){
								System.out.println("Causa: Unknown");
								
							}	
						}
						else 
							System.out.println("Estado no reconocido!");
						System.out.println("---------------------------------");
					}
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	//Sai
	static void writeToFile(String fileName, byte[] buffer) throws Exception
    	{	
        	FileOutputStream f = new FileOutputStream(fileName);
        	f.write(buffer);
        	f.close();
    	}    
	static void debuglog(String msg)
	{
    	if (debug)
			System.out.println(msg);
	}
	
	static Hashtable readOCSPParameters () throws FileNotFoundException, IOException {
		
		Properties props = new Properties();
		props.load(OCSPClient.class.getResourceAsStream("ocsp_parameters.properties"));

		Hashtable h = new Hashtable();
		for (Enumeration e = props.keys(); e.hasMoreElements() ; ) {
		    String key = (String)e.nextElement();
		    String value = (String)props.getProperty(key);
		    h.put(key, value);
		}
		return h;
		
	}
	
}
