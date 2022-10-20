package poo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Siete3_PruebaTemporizador2_InnerClassLocal {

	public static void main(String[] args) {

		Reloj3 miReloj=new Reloj3();
			miReloj.enMarcha(4000, true);
		JOptionPane.showMessageDialog(null, "terminar");
		System.exit(0);
		
	}

}


class Reloj3{
	
	//metodo			se utilizan como argumentos del metodo lo que antes eran propiedades de clase y te ahorras el constructor
	public void enMarcha(int intervalo, final boolean sonido) {//la variable que se usará dentro de la clase debe ser FINAL
															//intervalo no se esta usando en la clase, si no en el metodo
		
		//****CLASE INTERNA Local---dentro del metodo
		class DameLaHora2 implements ActionListener{//clase interna local sin modificador de acceso
			public void actionPerformed(ActionEvent e) {//metodo a implementar a fuerzas porque viene de interfaz ActionListener
				Date ahora=new Date();
				System.out.println("Cada 3 segundos"+ ahora);
				
				if(sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		
		ActionListener listener=new DameLaHora2();//Se crea objeto de interfaz usando como constructor una clase interna 
		Timer miTemporizador=new Timer(intervalo, listener);
			miTemporizador.start();
	}
	
	
}