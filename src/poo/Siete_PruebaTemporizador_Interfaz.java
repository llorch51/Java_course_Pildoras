package poo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Siete_PruebaTemporizador_Interfaz {

	public static void main(String[] args) {

		DameLaHora listener=new DameLaHora();
		//ActionListener listener=new DameLaHora(); ---Otra opcion
									//(tiempo, objetoDeClase/objetodeInterfaz)---creamos clase que implemente interfaz ActionListener
		Timer miTemporizador = new Timer(5000, listener);
			miTemporizador.start();
		JOptionPane.showMessageDialog(null, "Aceptar para Detener");//para que el programa no muera sin ver qué pasa
		System.exit(0);
	}

}
//¨***********************************
class DameLaHora implements ActionListener{
	
	//Unico metodo que implementa la interfaz
	public void actionPerformed(ActionEvent e) {
		
		Date ahora=new Date();
		System.out.println("Te pongo la hora cada 5 segundos"+ ahora);
		Toolkit.getDefaultToolkit().beep();//sonidito de sistema
	}
}
