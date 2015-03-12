
public class NoSocio extends Cliente {

	boolean fianzaPagada;
	
	public NoSocio(String n, String d) {
		super(n, d);
		this.fianzaPagada = false;
	}
	
	public String toString() {
		return "CLIENTE NO SOCIO: \n" + super.toString() +
			"\nFianza pagada: " + (this.fianzaPagada ? "Sí" : "No");
	}
	
	public void recuperarFianza() {
		this.fianzaPagada = false;
	}
	
	public void pagarFianza() {
		this.fianzaPagada = true;
	}
}
