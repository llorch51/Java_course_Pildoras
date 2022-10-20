package graficosSWING;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TreintayUno_PropioLayout {

	public static void main(String[] args) {
		MarcoLibre miMarco = new MarcoLibre();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoLibre extends JFrame{
	
	public MarcoLibre() {
		setTitle("Disposicion Propia");
		setBounds(600, 300, 300, 300);
		
		add(new LaminaLibre());
		setVisible(true);
		
	}
}

class LaminaLibre extends JPanel{
	
	public LaminaLibre() {
		
		setLayout(new EnColumnas());
		
		JLabel nombre = new JLabel("Nombre: ");
		JLabel apellido = new JLabel("Apellido: ");
		JLabel edad = new JLabel("Edad: ");
		JLabel telefono = new JLabel();
		
		JTextField c_nombre = new JTextField();
		JTextField c_apellido = new JTextField();
		JTextField c_edad = new JTextField();
		JTextField c_tele = new JTextField();
		
		
		//agregarlos por parejas
		add(nombre);
		add(c_nombre);
		add(apellido);
		add(c_apellido);
		add(edad);
		add(c_edad);
		add(telefono);
		add(c_tele);
	}
	
	
	
}

//creacion de clase para construir nuestra propia distribucion(Layout)
class EnColumnas implements LayoutManager {

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void layoutContainer(Container parent) {
		int y = 20;
		int contador = 0;//saber cuantos elementos llevamos 
		int num_elementos = parent.getComponentCount(); //cuantos componentes hemos agregado al conteneedor
		int dimension = parent.getWidth();//dimensiones del contenedor
			x= dimension/2;
		
		
		for( int i=0;i<num_elementos; i++) {
			contador++;
			
			Component c = parent.getComponent(i);
			c.setBounds(x-100, y, 100, 20);
			x=x+100;
			
			if(contador % 2 == 0) {// saber si es par
				x = dimension/2;
				y = y + 40;
			}
		}
		
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}
	
	private int x;
	//private int y = 20;
	
}