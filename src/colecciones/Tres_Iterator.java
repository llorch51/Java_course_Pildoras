package colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Tres_Iterator {

	public static void main(String[] args) {
		Cliente2 cliente1 = new Cliente2("Antonio", "00001", 200000);
		Cliente2 cliente2 = new Cliente2("Jose", "00002", 250000);
		Cliente2 cliente3 = new Cliente2("Rafel", "00003", 450000);
		Cliente2 cliente4 = new Cliente2("Marbella", "00004", 50000);
		Cliente2 cliente5 = new Cliente2("Antonio", "00001", 200000);
		
		Set<Cliente2> clientesBanco2 = new HashSet<>();//Interfaz<tipo> nombre = new ClaseQueImplementaLaInterfaz<>()
			clientesBanco2.add(cliente1);
			clientesBanco2.add(cliente2);
			clientesBanco2.add(cliente3);
			clientesBanco2.add(cliente4);
			clientesBanco2.add(cliente5);
			
		Iterator<Cliente2> ite = clientesBanco2.iterator();//como iterator() devuelve un objeto tipo Iterator, hay que guardarlo en uno tipo Iterator
		
		while (ite.hasNext()) {//mientras el iterator tenga siguiente
			Cliente2 cliente22 = (Cliente2) ite.next();//instancia de tipo Cliente para el iterador
			System.out.println(cliente22.getNombre());//Mostrar el nombre de cada posición en esa instancia temporal recien creada
		}
		
		//Quitamos elemento
		Iterator<Cliente2> ite2 = clientesBanco2.iterator();//otro iterador, no se por qué, pero sólo así funciona
		while (ite2.hasNext()) {
			String nombre = ite2.next().getNombre();
			if (nombre.equalsIgnoreCase("antonio")) {
				ite2.remove();
				System.out.println("\n -----pito");
			}
			
		}
		
		
		System.out.println("\n\n---------------Sin elemento Eliminado: ");
		for (Iterator<Cliente2> iterator = clientesBanco2.iterator(); iterator.hasNext();) {
			//Cliente2 cliente22 = (Cliente2) iterator.next();
			System.out.println(iterator.next().getNombre());
		}
	
	}
}

class Cliente2 {
	
	
	public Cliente2(String nombre, String no_cuenta, double saldo) {
		super();
		this.nombre = nombre;
		this.no_cuenta = no_cuenta;
		this.saldo = saldo;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public String getNo_cuenta() {
		return no_cuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNo_cuenta(String no_cuenta) {
		this.no_cuenta = no_cuenta;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", no_cuenta=" + no_cuenta + ", saldo=" + saldo + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((no_cuenta == null) ? 0 : no_cuenta.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente2))
			return false;
		Cliente2 other = (Cliente2) obj;
		if (no_cuenta == null) {
			if (other.no_cuenta != null)
				return false;
		} else if (!no_cuenta.equals(other.no_cuenta))
			return false;
		return true;
	}



	private String nombre;
	private String no_cuenta;
	private double saldo;
}