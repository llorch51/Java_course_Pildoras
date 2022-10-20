package programacion_generica;

import java.util.ArrayList;
import java.util.Iterator;

public class Uno_ArrayList_Iterator {

	public static void main(String[] args) {
		/*
		Empleado[] listaEmpleados = new Empleado[3];
			listaEmpleados[0] = new Empleado("Ana", 45, 2500);
			listaEmpleados[1] = new Empleado("Jose", 33, 45000);
			listaEmpleados[2] = new Empleado("Juan", 22, 15000);
			*/
		ArrayList<Empleado> listaEmpleados = new ArrayList<>();//ArrayList solo permite almacenar objetos, NO tipos de dato primitivos
		//EnsureCapacity
			listaEmpleados.ensureCapacity(11);//define manualmente el tamaño inicial del ArrayList, defecto es 10
		//ADD()----------añadir elemento
			listaEmpleados.add(new Empleado("Ramona", 33, 15000));
			listaEmpleados.add(new Empleado("Jose", 22, 18000));
			listaEmpleados.add(new Empleado("Juan", 44, 22000));
			listaEmpleados.add(new Empleado("Mercedes", 26, 22000));
			listaEmpleados.add(new Empleado("Luis", 33, 22000));
			listaEmpleados.add(new Empleado("Juana", 25, 22000));
			listaEmpleados.add(new Empleado("Ernesto", 44, 22000));
			listaEmpleados.add(new Empleado("Felipe", 26, 22000));
			listaEmpleados.add(new Empleado("Miguel", 33, 22000));
			listaEmpleados.add(new Empleado("Nepomuceno", 25, 22000));
			listaEmpleados.add(new Empleado("Vladimir", 44, 22000));
			listaEmpleados.add(new Empleado("Katya", 26, 22000));
			listaEmpleados.add(new Empleado("Francisco", 33, 22000));
			listaEmpleados.add(new Empleado("Sugey", 25, 22000));
			
			//listaEmpleados.trimToSize();//bloquea el tamaño existente del array al numero de elementos
			
			//SET()-----ingresar elemnto en punto especifico del arrayList, lo sustituye/reemplaza
			listaEmpleados.set(2, new Empleado("Job", 99, 66000));
			
		//SIZE()	
		System.out.println(listaEmpleados.size());
		
		for (Empleado empleado : listaEmpleados) {
			System.out.println(empleado.dameDatos());
		}
		
		System.out.println("\n\n***********Mostrar elemento en especifico: ");
		System.out.println(listaEmpleados.get(9).dameDatos());//elemento en posicion 9 del ArrayList
		
		//Recorrer el arrayList con un iterador
		System.out.println("\n\nRecorrer el ArrayList con un Iterador: ");
		Iterator<Empleado> mi_iterador = listaEmpleados.iterator();
		
	    while (mi_iterador.hasNext()) {//hasta que hasNext devuelva False
			//Empleado empleado = (Empleado) mi_iterador.next();
			//System.out.println(empleado.dameDatos());
	    	System.out.println(mi_iterador.next().dameDatos());
			
		}
		
		
		

	}

}


class Empleado{
	
	
	public Empleado(String nombre, int edad, double salario) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	
	
	public String dameDatos() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + "]";
	}
	
	private String nombre;
	private int edad;
	private double salario;
	
}