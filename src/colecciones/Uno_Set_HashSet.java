package colecciones;

import java.util.HashSet;
import java.util.Set;

public class Uno_Set_HashSet {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Antonio", "00001", 200000);
		Cliente cliente2 = new Cliente("Jose", "00002", 250000);
		Cliente cliente3 = new Cliente("Rafel", "00003", 450000);
		Cliente cliente4 = new Cliente("Marbella", "00004", 50000);
		Cliente cliente5 = new Cliente("Antonio", "00001", 200000);
		
		Set<Cliente> clientesBanco = new HashSet<>();//Interfaz<tipo> nombre = new ClaseQueImplementaLaInterfaz<>()
			clientesBanco.add(cliente1);
			clientesBanco.add(cliente2);
			clientesBanco.add(cliente3);
			clientesBanco.add(cliente4);
			clientesBanco.add(cliente5);
			
		for (Cliente cliente : clientesBanco) {
			System.out.println(cliente.toString());
		}

	}

}

class Cliente {
	
	
	public Cliente(String nombre, String no_cuenta, double saldo) {
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
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
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