package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tres_SyncHilos_Lock_PracticaBanco {//******************LOCK**********************

	public static void main(String[] args) {
		
		Banco b = new Banco();
		
		for(int i=0; i < 100; i++) {
			
			EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);//Clase que implementa runnable, necesario para Thread
			Thread t = new Thread(r);//como parametro la instancia recien creada
				t.start();
		}

	}

}

//*****************************************

class Banco {
	
	public Banco() {
		cuentas = new double[100];//creacion de las cuentas
		
		for(int i=0; i < cuentas.length; i++) {
			cuentas[i] = 2000;//cada cuenta con 2000 peje-coins
		}
		
		saldoSuficiente = cierreBanco.newCondition();//bloqueo del hilo dependerá de una condicion
	}
	
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		
		cierreBanco.lock();//+++bloquea el trozo de codigo para que SOLO UN HILO pueda ejecutarlo por tiempo++++
		
		try {
			while(cuentas[cuentaOrigen] < cantidad){//corroborar que los fondos son suficientes para lo que se quiere hacer
													//si NO, pone a la espera el hilo actual
				
				//++++CONDICION+++++
				saldoSuficiente.await();//si la condicion se cumple, que el saldo de la cuenta origen es menor que la
										//cantidad a transferir, pone el hilo en espera hasta que la cuenta tenga suficiente dinero 
				
			}
			
			System.out.println(Thread.currentThread());//hilo que va a realizar la transferencia
			
			cuentas[cuentaOrigen] -= cantidad;//se le descuenta la cantidad al origen
			
			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
			
			cuentas[cuentaDestino]+=cantidad;// se le suma la cantidad al destino
			
			System.out.printf("Saldo total: %10.2f%n", saldoTotal());
			
			saldoSuficiente.signalAll();//avisa a los hilos en espera para replantear condicion
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			cierreBanco.unlock();//+++++Abrir para que el proximo hilo lo pueda ejecutar+++++
		}
	}
	
	//Como no estan los hilos sincronizados, mostrará, en algún punto, cantidadesinferiores a 200,000. Y está mal eso
	public double saldoTotal() {//muestra la suma de todas las cuentas
		double sumaCuentas = 0;
		for (double d : cuentas) {
			sumaCuentas += d;
		}
		return sumaCuentas;
	}
	
	private final double[] cuentas;
	//+++++++++++++++++++++++++++
	//RenntrantLock- es lo que permite bloquear la ejecucion de hilos
	//+++++++++++++++++++++++++
	private Lock cierreBanco = new ReentrantLock();//Interfaz Lock = instancia de ReentrantLock
	private Condition saldoSuficiente;//permitirá reservar el flujo del hilo actual a la condicion de q el saldo sea suficiente
}

//*****************************************************
//Clase que construirá los hilos
class EjecucionTransferencias implements Runnable{
	
	public EjecucionTransferencias(Banco b, int cuentaOrigen, double cantidadMax) {
		this.banco = b;
		this.cuentaOrigen = cuentaOrigen;
		this.cantidadMax = cantidadMax;
	}

	@Override
	public void run() {
		
		while(true) {
			int cuentaRandomDestino = (int) (100*Math.random());//Math.random=num decimal entre 0-1
																//*100 lo recorre dos cifras
																//(int) toma solo la parte entera
			double cantidadTransferida = cantidadMax * Math.random();
			
			banco.transferencia(cuentaOrigen, cuentaRandomDestino, cantidadTransferida);
			
			try {
				Thread.sleep((int)(Math.random()*10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private Banco banco;
	private int cuentaOrigen;
	private double cantidadMax;
}