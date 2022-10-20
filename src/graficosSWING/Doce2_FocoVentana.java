package graficosSWING;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class Doce2_FocoVentana extends JFrame implements WindowFocusListener{

	public static void main(String[] args) {
		
		Doce2_FocoVentana miMarco=new Doce2_FocoVentana();		
		miMarco.iniciar();
	}
	
	public void iniciar() {
		marco1=new Doce2_FocoVentana();
		marco2=new Doce2_FocoVentana();
		marco1.setVisible(true);
		marco2.setVisible(true);
		marco1.setBounds(200, 100, 600, 350);
		marco2.setBounds(900, 100, 600, 350);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco1.addWindowFocusListener(this);//propia clase donde nos encontramos
		marco2.addWindowFocusListener(this);
	}
	

	@Override
	public void windowGainedFocus(WindowEvent e) {
		if(e.getSource()==marco1) {
			marco1.setTitle("Tengo el foco");
		}else {
			marco2.setTitle("Tengo el foco");
		}
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		if(e.getSource()==marco1) {
			marco1.setTitle("");
		}else {
			marco2.setTitle("");
		}
	}
	
	//propiedades
	Doce2_FocoVentana marco1, marco2;

}
