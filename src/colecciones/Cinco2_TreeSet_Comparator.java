package colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class Cinco2_TreeSet_Comparator {

	public static void main(String[] args) {

		Articulo2 primero = new Articulo2(1, "Primer articulo");
		Articulo2 segundo = new Articulo2(2, "Segundo articulo");
		Articulo2 tercero = new Articulo2(3, "Tercer articulo");

		System.out.println("Ordenado alfabeticamente de acuerdo a la descripcion: \n");
		ComparadorArticulos comparadorArticulos = new ComparadorArticulos();// Objeto de tipo comparador. Porque es de
																			// una clase que implementa interfaz
																			// 'Comparator'
		TreeSet<Articulo2> ordenaArticulos2 = new TreeSet<>(comparadorArticulos);// En este TreeSet los objetos se
																					// almacenan
																					// en el orden que define
																					// 'comparadorArticulos'
																					// definido por el metodo compare(),
																					// que en este caso
																					// lo hace alfabeticamente

		// no están añadidos en orden
		ordenaArticulos2.add(tercero);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);

		for (Articulo2 articulo : ordenaArticulos2) {
			System.out.println(articulo.getDescripcion());
		}
		
		System.out.println("\n\n--------------------------------------");
		System.out.println("Comparator como clase anonima en TreeSet: ");
		Articulo2 uno = new Articulo2(1, "Zambia");
		Articulo2 dos = new Articulo2(1, "Yemen");
		Articulo2 tres = new Articulo2(1, "Argentina");
		Articulo2 cuatro = new Articulo2(1, "Mexico");
		Articulo2 cinco = new Articulo2(1, "Noruega");
		
		TreeSet<Articulo2> paises = new TreeSet<>(new Comparator<Articulo2>() {//nos ahorramos desarrollar clase que la implemente 'Comparator'
																			//y lo hacemos aquí directamente
			@Override
			public int compare(Articulo2 o1, Articulo2 o2) {
				String descripcionA = o1.getDescripcion();
				String descripcionB = o2.getDescripcion();

				return descripcionA.compareTo(descripcionB);
			}
		});
		
			paises.add(uno);
			paises.add(dos);
			paises.add(tres);
			paises.add(cuatro);
			paises.add(cinco);
			
		for (Articulo2 articulo2 : paises) {
			System.out.println(articulo2.getDescripcion());
		}

	}

}

class Articulo2 implements Comparable<Articulo2> {

	public Articulo2(int numero_articulo, String descripcion) {
		this.numero_articulo = numero_articulo;
		this.descripcion = descripcion;

	}

	@Override
	public int compareTo(Articulo2 o) {

		return numero_articulo - o.numero_articulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	private int numero_articulo;
	private String descripcion;

}

//*********************************************************
//Interfaz 'Comparator' en otra clase
//Así no obligamos que la clase que construye los objetos principales 'Articulo2', la implemente
class ComparadorArticulos implements Comparator<Articulo2> {

	@Override
	public int compare(Articulo2 o1, Articulo2 o2) {
		String descripcionA = o1.getDescripcion();
		String descripcionB = o2.getDescripcion();

		return descripcionA.compareTo(descripcionB);
	}

}
