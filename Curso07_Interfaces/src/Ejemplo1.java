import java.util.Enumeration;
import java.util.Vector;


public class Ejemplo1 {

	public static void main(String[] args) {
		Vector v = new Vector();
		
		v.add(45);
		v.add("otro");
		v.add(4.56);
		v.add('t');
		v.add("Tralarí");
		v.add(6.56f);
		
		Enumeration e = v.elements();		
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

	}
	
}
