package graficosSWING;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.PublicKey;

import javax.swing.JFrame;

public class Once_Mouse_Eventos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoRaton miMarcoRaton=new MarcoRaton();
		miMarcoRaton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

//++++++++++++++++++++++++++++++++++++++++
class MarcoRaton extends JFrame{
	public MarcoRaton() {
		setTitle("Eventos de Ratón");
		setVisible(true);
		setBounds(500, 300, 600, 450);
		
		EventosRaton eventosRaton=new EventosRaton();
		addMouseListener(eventosRaton);
		
	}
}

//++++++++++++++++++++++++++++++++++++
/* CON INTERFAZ
 * debes de implementar TODOS los metodos de la interfaz
class EventosRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pito");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("acabas de presionar");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Entrar");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Salir");
	}
	
}
*/
//con CLASE ADAPTADORA
//implementas solo el metodo que necesitas
class EventosRaton extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		System.out.println("pito");
		//System.out.println(e.getX()+ " "+ e.getY());
		//System.out.println(e.getClickCount());
		
	}

	public void mousePressed(MouseEvent e) {
		
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("Boton izq");
		}else if(e.getModifiersEx()==MouseEvent.BUTTON2_DOWN_MASK) {
			System.out.println("boton en medio");
		}else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) {
			System.out.println("boton derecho");
		}
		
		
	}
}


















