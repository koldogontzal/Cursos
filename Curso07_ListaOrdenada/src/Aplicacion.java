
public class Aplicacion {
	public static void main(String[] args) {
		// Ejemplo de lista de personas
		
		Lista l = new ListaOrdenada();
		System.out.println(l);
		l.insert(new Persona(31, "Luis"));
		l.insert(new Persona(27, "Pepe"));
		l.insert(new Persona(36, "Marian"));
		
		
		System.out.println(l);
		
		Persona p = new Persona(31, "Luis"); //10, "Manolito Gafotas");
		
		System.out.println("Buscar el elemento " + p + ": " + l.buscar(p));
		
		l.borrar(new Persona(10, "Manolito Gafotas"));
		
		System.out.println(l);
		
		l.borrar(new Persona(36, "Marian"));
		
		System.out.println(l);
		
		
		// Ejemplo de lista de listas
		Lista m = new Lista();
		Lista listaDeListas = new Lista();
		listaDeListas.insert(l);
		listaDeListas.insert(m);
		System.out.println("\nEjemplo de lista de listas:\n" + listaDeListas);
		
		
		// Ejemplo de comparar listas
		Lista a1 = new Lista();
		Lista a2 = new Lista();
		a1.insert(new Persona(31, "Luis"));
		a1.insert(new Persona(27, "Pepe"));
		a2.insert(new Persona(27, "Pepe"));
		a2.insert(new Persona(31, "Luis"));
		
		Lista listaDeListas1 = new Lista();
		Lista listaDeListas2 = new Lista();
		listaDeListas1.insert(a1);
		listaDeListas1.insert(a2);
		listaDeListas2.insert(a2);
		listaDeListas2.insert(a1);
		
		
		
		
		
		System.out.println("\nEjemplo de equals de listas:\n Lista 1: " + listaDeListas1);
		System.out.println(" Lista 2: " + listaDeListas2);
		System.out.println("¿Son iguales? " + listaDeListas1.equals(listaDeListas2));
		
		// Pila
		System.out.println("\n");
		Pila pila = new Pila();
		pila.push(new Persona(31, "Luis"));
		pila.push(new Persona(36, "Marian"));
		pila.push(new Persona(27, "Pepe"));
		pila.push(new Persona(13, "Misi"));
		
		System.out.println("Ejemplo de pila: " + pila);
		
		for (int i = 0; i < 5; i++) {
		Dato d = pila.pop();
		System.out.println("Desapilo " + d + "\ny la pila queda: " + pila);
		}
		
		
		
		// Cola
		System.out.println("\n");
		Cola cola = new Cola();
		cola.push(new Persona(31, "Luis"));
		cola.push(new Persona(36, "Marian"));
		cola.push(new Persona(27, "Pepe"));
		cola.push(new Persona(13, "Misi"));
		
		System.out.println("Ejemplo de cola: " + cola);
		
		for (int i = 0; i < 5; i++) {
		Dato d = cola.pop();
		System.out.println("Desapilo " + d + "\ny la cola queda: " + cola);
		}
		
		// Arreglo
		System.out.println("\n");
		Arreglo arreglo = new Arreglo();
		arreglo.push(new Persona(31, "Luis"), 3);
		arreglo.push(new Persona(36, "Marian"), 3);
		arreglo.push(new Persona(27, "Pepe"), 3);
		arreglo.push(new Persona(13, "Misi"), 3);
		
		System.out.println("Ejemplo de arreglo: " + arreglo);
		
		for (int i = 0; i < 5; i++) {
		Dato d = arreglo.pop(2);
		System.out.println("Desapilo " + d + "\ny la arreglo queda: " + arreglo);
		}
		
		// Calculadora
		Calculadora c = new Calculadora();
		c.crearpila();
		System.out.println("El resultado es: "+ c.calcular());
	}
}
