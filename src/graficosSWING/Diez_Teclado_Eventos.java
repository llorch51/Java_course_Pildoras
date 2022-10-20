package graficosSWING;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Diez_Teclado_Eventos {

	public static void main(String[] args) {

		MarcoTeclas miMarcoTeclas=new MarcoTeclas();
		miMarcoTeclas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
//+++++++++++++++++++++++++++++++++++CLASE
class MarcoTeclas extends JFrame{
	public MarcoTeclas() {
		
		setVisible(true);
		setBounds(700, 300, 600, 450);
		setTitle("Eventos Teclado");
		
		EventosTeclado teclado = new EventosTeclado();
		addKeyListener(teclado);
		
	}
}

//+++++++++++++++++++++++CLASEE
class EventosTeclado implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int codigo=e.getKeyCode();
		System.out.println(codigo);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		
	}
	
	
}
