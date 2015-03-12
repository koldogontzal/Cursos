package ejemplo02ListarInterfacesDeLaMaquina;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Aplicacion {

	/**
	 * @param args
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws SocketException {
		Enumeration e = NetworkInterface.getNetworkInterfaces();
		
		while (e.hasMoreElements()) {
			NetworkInterface ni = (NetworkInterface)e.nextElement();
			System.out.println(ni);
			System.out.println("Display Name: " + ni.getDisplayName());
			System.out.println("Name: " + ni.getName());

			System.out.println("Hardware address: " + escribirHwAdd(ni.getHardwareAddress()));
			System.out.println("InetAddress: " + ni.getInetAddresses());
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
		}
		
		
	}
	
	private static String escribirHwAdd(byte[] add) {
		if (add == null) {
			return "No tiene direccin fsica";
		} else {
			String str = "";
			for (int i = 0; i < add.length; i++) {
				str = str + i + ":";
			}
			return str;
		}
		
		
	}

}
