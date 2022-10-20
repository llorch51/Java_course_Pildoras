package colecciones;

import java.util.HashMap;
import java.util.Map;

public class Seis_Map {

	public static void main(String[] args) {
		
		HashMap<String, Empleado> personal = new HashMap<>();//HashMap<Key, Value>
			personal.put("145", new Empleado("Jose"));	
			personal.put("458", new Empleado("Miguel"));
			personal.put("155", new Empleado("Tadeo"));		//Agregar
			personal.put("35", new Empleado("Luis"));
		System.out.println("Original: ");	
		System.out.println(personal);
		
		//Eliminar
			personal.remove("155");	//Remover, basado en la Key
		System.out.println("\n\nElemento eliminado: ");
		System.out.println(personal);
		
		//Reemplazar
		personal.put("35", new Empleado("Maritza"));//	Reemplazar
		System.out.println("\n\nElementoReemplazado: ");
		System.out.println(personal);
		
		System.out.println("\n\n------------Map.entry");
		for(Map.Entry<String, Empleado> entrada : personal.entrySet()) {
			String clave = entrada.getKey();
			Empleado valor = entrada.getValue();
			
			System.out.println(clave + ", " + valor);
		}

	}

}
//*******************************************
class Empleado {
	public Empleado(String nombre) {
		this.nombre = nombre;
		sueldo = 2000;
	}
	
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}

	private String nombre;
	private double sueldo;
}