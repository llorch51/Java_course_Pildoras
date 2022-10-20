package programacion_generica;

import java.util.GregorianCalendar;

public class Tres_MetodoGenerico_Propio {

	public static void main(String[] args) {
		String[] nombres = {"Jose", "maria", "Ariel", "guadalupe","jesus"};
		//String elementos = MisMatrices.getElementos(nombres);//regresa un String, por eso se guarda en un String
		//System.out.println(elementos);
		
		System.out.println("Array de tipo String: ");
		System.out.println(MisMatrices.getElementos(nombres));
		
		//metodo getMenor()
		System.out.println("El menor elemento es: ");
		System.out.println(MisMatrices.getMenor(nombres));
		
		
		Empleado[] listaEmpleado2 = {
				new Empleado("Maria", 44, 12500),
				new Empleado("Maria", 44, 12500),
				new Empleado("Maria", 44, 12500),
				new Empleado("Maria", 44, 12500),
				new Empleado("Maria", 44, 12500),
				new Empleado("Maria", 44, 12500),
				new Empleado("Maria", 44, 12500),
				new Empleado("Maria", 44, 12500),
				new Empleado("Maria", 44, 12500),
		};
		System.out.println("\n\nArray de tipo Empleado: ");
		System.out.println(MisMatrices.getElementos(listaEmpleado2));
		
		
		GregorianCalendar[] fechas = {
				new GregorianCalendar(2015, 07, 12),
				new GregorianCalendar(2012, 06, 11),
				new GregorianCalendar(2002, 8, 13),
				new GregorianCalendar(2009, 8, 22),
				new GregorianCalendar(2015, 02, 2)
		};
		System.out.println("\n\n" + MisMatrices.getMenor(fechas).getTime());
	}

}
//*************************************************
class MisMatrices {
	//metodo generico
	public static <T> String getElementos(T[] a) {
		return "El array tiene "+ a.length + " elementos";
	}
	
	public static <T extends Comparable<T>> T getMenor(T[] a) {//'extends' porque de un metodo a una Interfaz-que son metodos- se pone eso
													//todos los objetos que implementen el metodo getMenor, deben de ser de una clase que implemente interfaz Comparable
		if(a == null || a.length==0) {
			return null;
		}
		
		T elementoMenor = a[0];
		for(int i=1; i < a.length; i++) {//desde i=1, porque la posicion 0 ya la tenemos en 'elementoMenor'
			if(elementoMenor.compareTo(a[i]) > 0) {
				elementoMenor = a[i];
			}
		}
		return elementoMenor;
	}
}