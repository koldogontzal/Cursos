package ejercicioAlmacen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Almacen {
	
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
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			
			for (int i = 0; i < this.numProductos; i++) {
				this.productos[i].grabarDisco(pw);
			}
			
			pw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void leerDisco(String str) {
		File f = new File(str);
		
		// Borra el almacen
		this.vaciarAlmacen();

		// Carga del disco
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			// Leo 		
			Producto p = null;
			while((p = Producto.leerDisco(br)) != null ) { 	
				this.agnadirProducto(p);
			}
			//Cierro todo
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void vaciarAlmacen() {
		if (!this.vacio()) {
			for (int i = 0; i < this.numProductos; i++) {
				this.productos[i] = null;
			}
			this.numProductos = 0;
		}
	}
}
