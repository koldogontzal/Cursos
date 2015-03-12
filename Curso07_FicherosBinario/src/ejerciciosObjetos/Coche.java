package ejerciciosObjetos;

import java.io.Serializable;

public class Coche implements Serializable {
	
	private static final long serialVersionUID = 546001450550147205L;
	private String mat;
	
	public Coche(String m) {
		this.mat = m;
	}
	
	@ Override
	public String toString() {
		return "COCHE: " + this.mat;
	}

}
