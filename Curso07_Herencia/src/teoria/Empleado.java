package teoria;

public class Empleado {

	private String categoria = "";
	public int antiguedad = 20;
	protected String departmento = "";
	
	public void metodoPublico() {
		System.out.println("Empleado");
	}
	private void metodoPrivado() {}
	protected void metodoProtegido() {}
	
	
	public Empleado() {
		this.antiguedad = 0;
	}
	
	public Empleado(int a) {
		this.antiguedad = a;
	}
	
}
