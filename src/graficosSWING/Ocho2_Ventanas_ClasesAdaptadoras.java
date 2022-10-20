package graficosSWING;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ocho2_Ventanas_ClasesAdaptadoras {

	public static void main(String[] args) {
		
		MarcoVentana2 miMarco= new MarcoVentana2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setTitle("Ventana 1");
		miMarco.setBounds(300, 300, 500, 350);
		
		MarcoVentana2 miMarco2= new MarcoVentana2(); 
		miMarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		miMarco2.setTitle("Ventana 2 .l.");
		miMarco2.setBounds(900, 300, 500, 350);

	}

}


class MarcoVentana2 extends JFrame{
	
	public MarcoVentana2() {
		
		setVisible(true);
		
		//M_Ventana listenerM_Ventana= new M_Ventana();
		//addWindowListener(listenerM_Ventana);
		addWindowListener(new M_Ventana2());//otra forma
	}
}
//Clase adaptadora---permite solo utilizar el metodo q necesitamos, y no los 8 de interfaz WindowListener
class M_Ventana2 extends WindowAdapter{
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana minimizaa");
		
	}
}