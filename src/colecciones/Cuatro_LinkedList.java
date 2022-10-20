package colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class Cuatro_LinkedList {

	public static void main(String[] args) {
		
		LinkedList<String> personas = new LinkedList<>();
			personas.add("Jose");
			personas.add("Maria");
			personas.add("Jesus");
			personas.add("Miguel");
			personas.add("Ana");
			personas.add("Julio");
			personas.add("Fidel");
			
			System.out.println("Tamanio de la lista: " + personas.size());
			System.out.println("Nombres:");
			for (String string : personas) {
				System.out.println(string);
			}
			
			System.out.println("\nAgregando elemento");
			ListIterator<String> iterador = personas.listIterator();//porque la lista tiene el metodo listIterator()
				iterador.next();//se mueve una posicion
				iterador.add("Pati");

				
			System.out.println("\nLista con elemento agregado:");
			for (String string : personas) {
				System.out.println(string);
			}
	}

}
