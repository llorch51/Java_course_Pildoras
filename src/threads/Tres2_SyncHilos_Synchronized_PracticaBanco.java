package threads;

public class Tres2_SyncHilos_Synchronized_PracticaBanco {

	public static void main(String[] args) {
		Banco2 b2 = new Banco2();
		
		for(int i=0; i < 100; i++) {
			
			EjecucionTransferencias2 r = new EjecucionTransferencias2(b2, i, 2000);//Clase que implementa runnable, necesario para Thread
			Thread t = new Thread(r);//como parametro la instancia recien creada
				t.start();
		}

	}

}
//***************************************************

class Banco2 {
	
	public Banco2() {
		cuentas = new double[100];//creacion de las cuentas
		
		for(int i=0; i < cuentas.length; i++) {
			cuentas[i] = 2000;//cada cuenta con 2000 peje-coins
		}
		
		
	}
	
	//SYNCHRONIZED---	como lock(), detendrá la ejecucion del trozo de codigo a un solo hilo a la vez
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
		
		
			while(cuentas[cuentaOrigen] < cantidad){//corroborar que los fondos son suficientes para lo que se quiere hacer
													//si NO, pone a la espera el hilo actual
				 wait();//pone a la espera, al hilo, de que deje de cumplirse condicion
				
			}
			
			System.out.println(Thread.currentThread());//hilo que va a realizar la transferencia
			
			cuentas[cuentaOrigen] -= cantidad;//se le descuenta la cantidad al origen
			
			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
			
			cuentas[cuentaDestino]+=cantidad;// se le suma la cantidad al destino
			
			System.out.printf("\nSaldo total: %10.2f%n", saldoTotal());
			
			notifyAll();//notifica a los hilos en espera
		
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
}

//***************************************************************
class EjecucionTransferencias2 implements Runnable{
	
	public EjecucionTransferencias2(Banco2 b, int cuentaOrigen, double cantidadMax) {
		this.banco = b;
		this.cuentaOrigen = cuentaOrigen;
		this.cantidadMax = cantidadMax;
	}

	@Override
	public void run() {
		try {
		while(true) {
			int cuentaRandomDestino = (int) (100*Math.random());//Math.random=num decimal entre 0-1
																//*100 lo recorre dos cifras
																//(int) toma solo la parte entera
			double cantidadTransferida = cantidadMax * Math.random();
			
			banco.transferencia(cuentaOrigen, cuentaRandomDestino, cantidadTransferida);
			
			
				Thread.sleep((int)(Math.random()*10));
			} 
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Banco2 banco;
	private int cuentaOrigen;
	private double cantidadMax;
}