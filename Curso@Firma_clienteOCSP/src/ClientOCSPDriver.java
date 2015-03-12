/*
Copyright (c) 2003 
Johannes Nicolai (johannes.nicolai@novosec.com)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
/*
Modified by Sainathan Sivasubramanian (sainathan@gmail.com) in Nov 2004 to support the following:
1. Use a different constructor of X509Name to reverse order of requestor subject DN
2. ASN1Encode requestorName to encode requestor subject DN in appropriate ASN1 format
3. Inlude nonce extension - A command line param can be added to enable/disable nonce in OCSP request
*/

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.NoSuchProviderException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Date;
import org.bouncycastle.ocsp.OCSPResp;
import org.bouncycastle.ocsp.OCSPReqGenerator;
import org.bouncycastle.ocsp.CertificateID;
import org.bouncycastle.ocsp.OCSPException;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509Name;

import org.bouncycastle.ocsp.OCSPRespStatus;
import org.bouncycastle.ocsp.BasicOCSPResp;
import org.bouncycastle.ocsp.RespID;
import org.bouncycastle.ocsp.SingleResp;

//Sai
import java.util.Vector;
import java.security.SecureRandom;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1EncodableVector;
//End

/**
This class is responsable for generating OCSP client responses and processing OCSP server responses. All OCSP information is processed and generated as raw
DER encoded data.
*/
public class ClientOCSPDriver {
	private X509Certificate usercert;
	private PrivateKey userkey;
	private X509Certificate [] certificates;
	private X509Certificate mastercert;	
	private HashMap map;
	private boolean calledgenerate=false;
	private boolean calledprocess=false;
	//Sai
	private X509Certificate respcert;
	private static SecureRandom random = new SecureRandom();
	//End
/**
Constructs a ClientOCSPDriver object. Objects of this class can only be used for one OCSP client request and the processing of the resulting server OCSP response.
@param usercert Certificate that should be used to authenticate the OCSP client 
@param userkey  Private key that belongs to the certificate
@param certificates Certificates whose status should be requested from the OCSP server
@param mastercert Certificate that is aspected to authenticate the OCSP server response
*/
	public ClientOCSPDriver(X509Certificate usercert, PrivateKey userkey, X509Certificate [] certificates, X509Certificate mastercert, X509Certificate respcert) throws OCSPException {
		if (certificates==null||mastercert==null||respcert==null)
			throw new OCSPException("At least one parameter of ClientOCSPDriver was uninitialised");
		
		this.usercert=usercert;
		this.userkey=userkey;
		this.certificates=certificates;
		this.mastercert=mastercert;
		this.respcert=respcert;
		map=new HashMap(certificates.length);		
		
	}
/**
Generates a signed OCSP client request with the parameters specified in the constructor.
This method can only be called once.
@return The raw DER encoded client OCSP request. This data has to be transported over a specific protocol (such as HTTP) to the OCSP server in order to get
an OCSP server response.
*/
	public byte [] getRequest(String user) throws OCSPException, NoSuchProviderException,IOException {
		//return getRequest("MD5WITHRSA","BC");
		//Sai - Choose the signature algorithm based on what your responder expects/supports
		return getRequest("SHA1WITHRSA","BC",user);		
	}


//Sai
/**
     * Apply ASN1 coversion for the given value depending on the oid
     * and the character range of the value.
     *
     * This code was taken and modified from X509DefaultEntryConverter.java file 
     * of BouncyCastle. Modify this code to match the ASN1 type for your requestor subject DN
     * Refer Bouncycastle X509DefaultEntryConverter.java source for implementation of methods
     * such as convertHexEncoded, canBePrintable and canBeUTF8 
     * 
     * @param oid the object identifier for the DN entry
     * @param value the value associated with it
     * @return the ASN.1 equivalent for the string value.
     *      
     */
    public DERObject getConvertedValue(
        DERObjectIdentifier  oid,
        String               value)
    {
    	if (oid.equals(X509Name.O) || oid.equals(X509Name.OU)) {
            return new DERT61String(value);
        }
        else /*if (canBePrintable(value))  */
        {
            return new DERPrintableString(value);
        }
    }	
	
/**
 Method added to generate ASNSequence object of subjectDN consturcted in appropriate ASN1 type
 X509Name constructs all DN components as printablestring by default
 
 This code was taken and modified from X509Name.java file of BouncyCastle
 **/	
	public ASN1Sequence getASNSequence(Vector oids, Vector values)
    {
        ASN1Sequence seq;
        
        ASN1EncodableVector  vec = new ASN1EncodableVector();
        ASN1EncodableVector  sVec = new ASN1EncodableVector();
        DERObjectIdentifier  lstOid = null;
        
        for (int i = 0; i != oids.size(); i++)
        {
            ASN1EncodableVector     v = new ASN1EncodableVector();
            DERObjectIdentifier     oid = (DERObjectIdentifier)oids.elementAt(i);

            v.add(oid);

            String  str = (String)values.elementAt(i);

            v.add(getConvertedValue(oid, str));

            if (lstOid == null)
            {
                sVec.add(new DERSequence(v));
            }
            else
            {
                vec.add(new DERSet(sVec));
                sVec = new ASN1EncodableVector();                
                sVec.add(new DERSequence(v));
            }
            
            lstOid = oid;
        }
        
        vec.add(new DERSet(sVec));
        
        seq = new DERSequence(vec);        

        return seq;
    }
//End	
/**
Generates a signed OCSP client request with the parameters specified in the constructor.
This method can only be called once.
@param signingalgorithm The algorithm, that should be used to sign the OCSP client request, default is "MD5WITHRSA".
@param provider The provider used to compute the hashes and sign the request, default is "BC" (Bouncy Castle).
@return The raw DER encoded client OCSP request. This data has to be transported over a specific protocol (such as HTTP) to the OCSP server in order to get
an OCSP server response.
*/
	public byte [] getRequest(String signingalgorithm,String provider,String user) throws OCSPException,NoSuchProviderException,IOException {
		if (calledgenerate)
			throw new OCSPException("Request was already generated!");
		map.clear();	
		OCSPReqGenerator gen= new OCSPReqGenerator();
		for (int i=0;i<certificates.length;++i) {
			CertificateID certid=new CertificateID(CertificateID.HASH_SHA1,mastercert,certificates[i].getSerialNumber());
			System.out.println("issuerNameHash: " + toHexadecimal(certid.getIssuerNameHash()));
			System.out.println("issuerKeyHash: " + toHexadecimal(certid.getIssuerKeyHash()));
			System.out.println("serialNumber: " + certid.getSerialNumber());		
			map.put(certid,certificates[i]);
			gen.addRequest(certid);
		}                

		ASN1Sequence seq = null;
		if (usercert!=null && userkey!=null && user==null) {
			X509Name subjectName = new X509Name(true,usercert.getSubjectX500Principal().getName());
			Vector oids = subjectName.getOIDs();  
			Vector values = subjectName.getValues();		

			//Create a ASNSequence object for the subject DN
			seq = getASNSequence(oids,values);    						
	    	gen.setRequestorName(new GeneralName(new X509Name(seq)));
		}
		if (user!=null) {
	    	gen.setRequestorName(new GeneralName(GeneralName.rfc822Name,user));
		}
    	
   		//Include nonce extension 1.3.6.1.5.5.7.48.1.2    	    	    	
/*
  		byte[] Nonce = new byte[16];
  		random.nextBytes(Nonce);     		    	
    	ASN1EncodableVector  v = new ASN1EncodableVector();    	
        ASN1EncodableVector  sVec = new ASN1EncodableVector();        
    	DERObjectIdentifier  oid = new DERObjectIdentifier("1.3.6.1.5.5.7.48.1.2");
        v.add(oid);        
        v.add(new DEROctetString(Nonce));
        sVec.add(new DERSequence(v));        
        seq = new DERSequence(sVec);		
    	gen.setRequestExtensions(new X509Extensions(seq));
*/
          //End   

		byte [] ocspdata = null;
		if (usercert!=null && userkey!=null) {
			ocspdata = gen.generate(signingalgorithm,userkey,new X509Certificate[] {usercert},provider).getEncoded();
		}
		else {
			ocspdata = gen.generate().getEncoded();
		}
		calledgenerate=true;
		return ocspdata;
	}
	
/**
Processes the resulting OCSP server response. This method checks, whether the server can authenticate itself and then finds out the status of the
requested certificates. This method can be called only once after generating the OCSP client response via {@link #getRequest() getRequest}.
@param data The raw DER encoded OCSP server response
@return A hashmap is returned that contains the status of each requested certificate. The key for the hashmap is the certificate itself. The status (the associated value) is either null (certificate is good), an {@link org.bouncycastle.ocsp.UnknownStatus UnkownStatus} object or a {@link org.bouncycastle.ocsp.RevokedStatus RevokedStatus} object.  
*/
	public HashMap processResponse(byte [] data) throws OCSPException,IOException,NoSuchProviderException{
		return processResponse(data,"BC");
	}
	
/**
Processes the resulting OCSP server response. This method checks, whether the server can authenticate itself and then finds out the status of the
requested certificates. This method can be called only once after generating the OCSP client response via {@link #getRequest(String,String) getRequest}.
@param data The raw DER encoded OCSP server response
@param provider The provider used to authenticate the server, default is "BC" (Bouncy Castle).
@return A hashmap is returned that contains the status of each requested certificate. The key for the hashmap is the certificate itself. The status (the associated value) is either null (certificate is good), an {@link org.bouncycastle.ocsp.UnknownStatus UnkownStatus} object or a {@link org.bouncycastle.ocsp.RevokedStatus RevokedStatus} object.  
*/
	public HashMap processResponse(byte [] data,String provider) throws IOException,OCSPException,NoSuchProviderException {
		if (!calledgenerate)
			throw new OCSPException("No request was generated!");
		if(calledprocess)
			throw new OCSPException("Request was already processed!");
			
		Date current=new Date();
		HashMap responsemap=new HashMap(certificates.length);
		OCSPResp resp=null;
		try {
			resp = new OCSPResp(data);
		}
		catch (Exception e) {
			throw new OCSPException("No valid OCSPResponse - object obtained! Exception: "+e);
		}
		int status = resp.getStatus();
		switch (status) {
			case OCSPRespStatus.INTERNAL_ERROR: throw new OCSPException ("INTERNAL_ERROR: An internal error occured in the OCSP Server!");
			case OCSPRespStatus.MALFORMED_REQUEST: throw new OCSPException ("MALFORMED_REQUEST: Your request did not fit the RFC 2560 syntax!");
			case OCSPRespStatus.SIGREQUIRED: throw new OCSPException ("SIGREQUIRED: Your request was not signed!");
			case OCSPRespStatus.TRY_LATER: throw new OCSPException ("TRY_LATER: The server was too busy to answer you!");
			case OCSPRespStatus.UNAUTHORIZED: throw new OCSPException ("UNAUTHORIZED: The server could not authenticate you!");
			case OCSPRespStatus.SUCCESSFUL: break;
			default: throw new OCSPException ("Unknown OCSPResponse status code!");
		}
		BasicOCSPResp bresp=null;
		try {
			bresp= (BasicOCSPResp) resp.getResponseObject();
		}
		catch (Exception e) {
			throw new OCSPException("No valid BasicOCSPResponse object obtained! Exception: "+e);
		}
		if (bresp==null)
			throw new OCSPException("No BasicOCSPResponse found!");
			
		if (current.before(bresp.getProducedAt())) 
			throw new OCSPException("Response was generated in the future at "+bresp.getProducedAt() + ". Check your system time");
		
		X509Certificate [] servercerts = (X509Certificate[])bresp.getCerts(provider);
		
		//Sai		
		if (servercerts!=null&&servercerts.length!=0) 
			//Sai
			//replace mastercert with respcert and use serial# to compare the certs instead of cert itself
			//if (!servercerts[0].equals(mastercert))
			if (!servercerts[0].getSerialNumber().equals(respcert.getSerialNumber()))
			//End
				throw new OCSPException("Certificate seems to be signed with unknown certificate!");
				
		RespID respid=bresp.getResponderId();
		//Sai
		//replace mastercert with respcert		
		//if (!respid.equals(new RespID(mastercert.getPublicKey()))&&!respid.equals(new RespID(mastercert.getSubjectX500Principal()))) 
		if (!respid.equals(new RespID(respcert.getPublicKey()))&&!respid.equals(new RespID(respcert.getSubjectX500Principal())))
		//End
			throw new OCSPException("The Responder ID does not match your responder certificate!");
		//Sai
		//replace mastercert with respcert
		if (!bresp.verify(respcert.getPublicKey(),provider))
			throw new OCSPException("Could not verify OCSP server response");
		
		SingleResp [] responses = bresp.getResponses();
		if (responses==null)
			throw new OCSPException("No client certificates inside OCSP response");
		
		//Sai
		//This validation is commented as the OCSP responder I was using does not validate
		//multiple certs coming in a single request. 
		/*		
		if (responses.length!=certificates.length)
			throw new OCSPException("Number of certificates inside OCSP response does not fit to request");
		*/
		//End
		calledprocess=true;
		for (int i=0;i<responses.length;++i) {
			SingleResp sresp=responses[i];
			/*
			if (current.before(sresp.getThisUpdate()))
				throw new OCSPException("Certificate was revoked in the future!");
			*/
			Date nextu=sresp.getNextUpdate();
			if (nextu!=null)
				if (current.after(nextu))
					throw new OCSPException("OCSP response is too old (New version already available)!");
			X509Certificate cert=(X509Certificate)map.remove(sresp.getCertID());
			if (cert==null)
				throw new OCSPException("Received certificate twice or one, that was not requested!");
			responsemap.put(cert,sresp.getCertStatus());
		}
		return responsemap;
		
	}
	public static String toHexadecimal(byte[] datos) 
    { 
            String resultado=""; 
            ByteArrayInputStream input = new ByteArrayInputStream(datos); 
            String cadAux; 
            int leido = input.read(); 
            while(leido != -1) 
            { 
                    cadAux = Integer.toHexString(leido); 
                    if(cadAux.length() < 2) //Hay que añadir un 0 
                            resultado += "0"; 
                    resultado += cadAux; 
                    leido = input.read(); 
            } 
            return resultado; 
    }
}
