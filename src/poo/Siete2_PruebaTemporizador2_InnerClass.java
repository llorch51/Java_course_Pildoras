package poo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Siete2_PruebaTemporizador2_InnerClass {

	public static void main(String[] args) {

		Reloj miReloj=new Reloj(3000, true);
			miReloj.enMarcha();
		JOptionPane.showMessageDialog(null, "terminar");
		System.exit(0);
		
	}

}

//************************************
class Reloj{
	//Constructor
	public Reloj(int intervalo, boolean sonido) {
		this.intervalo=intervalo;
		this.sonido=sonido;
		
	}
	//metodo
	public void enMarcha() {
		
		ActionListener listener=new DameLaHora2();//Se crea objeto de interfaz usando como constructor una clase interna 
		Timer miTemporizador=new Timer(intervalo, listener);
			miTemporizador.start();
	}
	
	//propiedades
	private int intervalo;
	private boolean sonido;
	
	//****CLASE INTERNA
	//Te puedes ahorrar la declaracion de metodos(get-set) en la clase que la engloba
	private class DameLaHora2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Date ahora=new Date();
			System.out.println("Cada 3 segundos"+ ahora);
			
			//Se accede a propiedad privada de la clase que la engloba desde clase interna
			if(sonido) {//sonido no esta declarado en esta clase interna
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}