package colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class Cinco_TreeSet {

	public static void main(String[] args) {
		
		TreeSet<String> ordenaPersonas = new TreeSet<>();
			ordenaPersonas.add("Sandra");
			ordenaPersonas.add("Marisela");
			ordenaPersonas.add("Diana");
			ordenaPersonas.add("Blanca");
			ordenaPersonas.add("Juana");
			ordenaPersonas.add("Guadalupe");
			
		System.out.println("Ordenamiento natural de TreeSet en objetos String (alfabeticamente):");
		for (String string : ordenaPersonas) {//TreeSet los ordena por defecto alfabeticamente
			System.out.println(string);			//Implementa la interfaz Comparable
		}
		
		System.out.println("\n\n---------------------------------------");
		System.out.println("Ordenado de acuerdo al numero de artículo: ");
		
		Articulo primero = new Articulo(1, "Primer articulo");
		Articulo segundo = new Articulo(2, "Segundo articulo");
		Articulo tercero = new Articulo(3, "Tercer articulo");
		
		TreeSet<Articulo> ordenaArticulos = new TreeSet<>();
			ordenaArticulos.add(tercero);
			ordenaArticulos.add(primero);
			ordenaArticulos.add(segundo);
			
		for (Articulo articulo : ordenaArticulos) {
			System.out.println(articulo.getDescripcion());
		}
		
		System.out.println("\n\n-----------------------------------------");
		System.out.println("Ordenado alfabeticamente de acuerdo a la descripcion");
		Articulo comparadorArticulos = new Articulo();//Objeto de tipo comparador. Porque es de una clase que implementa interfaz 'Comparator'
		TreeSet<Articulo> ordenaArticulos2 = new TreeSet<>(comparadorArticulos);//En este TreeSet los objetos de almacenan
																				//en el orden que define 'comparadorArticulos'
																				//definido por el metodo compare(), que en este caso
																				//lo hace alfabeticamente
			ordenaArticulos2.add(tercero);
			ordenaArticulos2.add(primero);
			ordenaArticulos2.add(segundo);
			
		for (Articulo articulo : ordenaArticulos2) {
			System.out.println(articulo.getDescripcion());
		}
	}
	
	

}

//*********************************************************
//++++++Clase propia que implementará la interfaz COMPARABLE para poder ordenar los elementos que de la clase se construyan||compareTo
class Articulo implements Comparable<Articulo>, Comparator<Articulo>{//Comparator para poder ordenar de otra forma||compare
	
	public Articulo() {
		// TODO Auto-generated constructor stub
	}
	
	public Articulo(int numero_articulo, String descripcion) {
		this.numero_articulo = numero_articulo;
		this.descripcion = descripcion;
		
		
	}

	@Override
	public int compareTo(Articulo o) {
		
		return numero_articulo - o.numero_articulo;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public int compare(Articulo o1, Articulo o2) {//para ordenar alfabeticamente
		String descripcionA = o1.getDescripcion();
		String descripcionB = o2.getDescripcion();
		
		return descripcionA.compareTo(descripcionB);
	}

	private int numero_articulo;
	private String descripcion;
	
}
