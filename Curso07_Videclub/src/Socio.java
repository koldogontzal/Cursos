
public class Socio extends Cliente {
	
	private String visa;
	
	public Socio (String n, String d, String visa) {
		super(n, d);
		this.visa = visa;
	}
	
	public String toString() {
		return "SOCIO: \n" + super.toString() + "\nVISA: " + this.visa; 
	}

}
