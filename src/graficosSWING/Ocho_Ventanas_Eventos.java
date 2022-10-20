package graficosSWING;

import java.awt.SystemColor;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Ocho_Ventanas_Eventos {

	public static void main(String[] args) {

		MarcoVentana miMarco= new MarcoVentana();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setTitle("Ventana 1");
		miMarco.setBounds(300, 300, 500, 350);
		
		MarcoVentana miMarco2= new MarcoVentana(); 
		miMarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		miMarco2.setTitle("Ventana 2");
		miMarco2.setBounds(900, 300, 500, 350);
	}

}


class MarcoVentana extends JFrame{
	
	public MarcoVentana() {
		//setTitle("Respondiendo");
		//setBounds(300, 300, 500, 350);
		setVisible(true);
		//miLamina.setBackground(SystemColor.window);
		
		M_Ventana listenerM_Ventana= new M_Ventana();
		
		addWindowListener(listenerM_Ventana);
	}
}

class M_Ventana implements WindowListener{
	
	//metodos de WindowListener
	public void windowActivated(WindowEvent e) {//ventana toma foco
		
	}
	public void windowClosed(WindowEvent e) {
		
	}
	public void windowClosing(WindowEvent e) {//ventana se cierra
		
	}
	public void windowDeactivated(WindowEvent e) {//ventana pierde foco
		
	}
	public void windowDeiconified(WindowEvent e) {//ventana se restablece despues de ser minimizada
		
	}
	public void windowIconified(WindowEvent e) {//ventana se minimiza
		System.out.println("Ventana Minimizada");
	}
	public void windowOpened(WindowEvent e) {//ventana se abre
		
	}
}