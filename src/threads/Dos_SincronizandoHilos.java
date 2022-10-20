package threads;

public class Dos_SincronizandoHilos {//con JOIN()

	public static void main(String[] args) {
		HilosVarios hilo1 = new HilosVarios();
		HilosVarios2 hilo2 = new HilosVarios2(hilo1);
			hilo2.start();
			hilo1.start();
			

		System.out.println("Terminadas las tareas");
	}

}

//****************************************

class HilosVarios extends Thread{
	
	@Override
	public void run() {
		
		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo" + getName());//getName()---nombre del hilo
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//************************************
class HilosVarios2 extends Thread{
	
	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
	}
	
	@Override
	public void run() {
		
		try {
			hilo.join();//no pasa a la ejecucion del siguiente hilo hasta que el actual muere
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo" + getName());//getName()---nombre del hilo
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private Thread hilo;
}
