package graficosSWING;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class Nueve_Ventanas_Estado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoEstado miMarcoEstado = new MarcoEstado();
		miMarcoEstado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoEstado extends JFrame{
	
	public MarcoEstado() {
		setVisible(true);
		setBounds(300, 300, 500, 350);
		
		//Clase		nombreInstancia que implementa metodo de interfaz
		CambiaEstado nuevoCambiaEstado = new CambiaEstado();
		addWindowStateListener(nuevoCambiaEstado);//instancia que implementa WindowstateListener
	}
}

//								interfaz
class CambiaEstado implements WindowStateListener{
	public void windowStateChanged(WindowEvent e) {
		System.out.println("Cambió estado");
		
		if(e.getNewState()==Frame.MAXIMIZED_BOTH) {
			System.out.println("Pantalla completa");//muestra en consola cada que cambia el estado de la ventana
		}
	}
}