package graficosSWING;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Quince_Layouts {

	public static void main(String[] args) {
		Marco_Layout miMarco= new Marco_Layout();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
//+++++++++++++++++++++++++++++++++

class Marco_Layout extends JFrame{
	public Marco_Layout() {
		setTitle("Layouts");
		setBounds(300, 300, 500, 300);
		
		Panel_Layout  lamina=new Panel_Layout();
		//FlowLayout disposicion=new FlowLayout(FlowLayout.LEFT);
		//lamina.setLayout(disposicion);
		add(lamina, BorderLayout.NORTH);
		
		Panel_Layout2 lamina2=new Panel_Layout2();
		add(lamina2, BorderLayout.SOUTH);
	}
}

//+++++++++++++++++++++++++++++++++++++++

class Panel_Layout extends JPanel{
	public Panel_Layout() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JButton("Amarillo"));
		add(new JButton("Azul"));
		
		
		//setLayout(new FlowLayout(FlowLayout.CENTER, 50, 100));
		
	}
}
//+++++++++++++++++++++++++++++++++++++++
class Panel_Layout2 extends JPanel{
	public Panel_Layout2() {
		
		setLayout(new BorderLayout());
		add(new JButton("Rojo"), BorderLayout.WEST);
		add(new JButton("Verde"), BorderLayout.SOUTH);
		add(new JButton("Negro"), BorderLayout.EAST);
	}
}
