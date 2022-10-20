package colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class Cuatro2_LinkedList {

	public static void main(String[] args) {
		
		LinkedList<String> paises = new LinkedList<>();
			paises.add("Espa�a");
			paises.add("Colombia");
			paises.add("M�xico");
			paises.add("Per�");
			
		LinkedList<String> capitales = new LinkedList<>();
			capitales.add("Madrid");
			capitales.add("Bogot�");
			capitales.add("CDMX");
			capitales.add("Lima");
			
		System.out.println("Paises: " + paises);
		System.out.println("Capitales: " + capitales);
		
		ListIterator<String> iteradorP = paises.listIterator();
		ListIterator<String> iteradorC = capitales.listIterator();
		
		//Se a�aden las capitales en la posicion contigua al pais correspondiente
		while (iteradorC.hasNext()) {
			if (iteradorP.hasNext()) {
				iteradorP.next();
			}
			
			iteradorP.add(iteradorC.next());
		}
		System.out.println("\n\nSe a�aden las capitales en la posicion contigua al pais correspondiente");
		System.out.println("" + paises);

		iteradorC = capitales.listIterator();//Como al final del primer While el iterador se encuentra al final de la lista,
											//hay que moverlo nuevamente al principio
		while(iteradorC.hasNext()) {
			iteradorC.next();//un salto
			if (iteradorC.hasNext()) {
				iteradorC.next();//un salto
				iteradorC.remove();//eliminar� cada dos posiciones, que ser�n pares
			}
		}
		System.out.println("\n\nSe han eliminado las posiciones pares de la lista Capitales: ");
		System.out.println(capitales);
		
		System.out.println("\n\nEliminar de la lista Paises los elementos que quedan en la lista Capitales:");
		paises.removeAll(capitales);
		System.out.println(paises);
	}

}
