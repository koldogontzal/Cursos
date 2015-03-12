package ejercicioAlmacen;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Almacen implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5234706058037551964L;
	private Producto[] productos;
	private int numProductos;
	
	public Almacen(int n) {
		this.productos = new Producto[n];
		this.numProductos = 0;
	}
	
	public void agnadirProducto(Producto p) {
		if (!this.lleno()) {
			this.productos[this.numProductos] = p;
			this.numProductos++;
		}
	}

	private boolean lleno() {
		return (this.numProductos == this.productos.length);
	}
	
	private boolean vacio() {
		return (this.numProductos == 0);
	}

	public void borrarUltimoProducto() {
		if (!this.vacio()) {
			this.numProductos--;
			this.productos[this.numProductos] = null;
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for (int i = 0; i < this.numProductos; i++) {
			str = str + "[" + i + "] " + this.productos[i] + "\n";
		}
		
		return str;
	}

	public void grabarDisco(String str) {
		File f = new File(str);

		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(this);
			
			oos.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static Almacen leerDisco(String str) {
		File f = new File(str);

		// Carga del disco
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// Hay que hacer siempre el casting
			Almacen almacen = (Almacen)ois.readObject();
			
			ois.close();
			fis.close();
			
			return almacen;
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
