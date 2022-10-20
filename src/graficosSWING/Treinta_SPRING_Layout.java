package graficosSWING;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class Treinta_SPRING_Layout {

	public static void main(String[] args) {
		Marco_spring miMarco = new Marco_spring();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco_spring extends JFrame{
	public Marco_spring() {
		setTitle("Spring Layout");
		setBounds(300, 300, 600, 400);
		
		
		add(new Lamina_spring());
		setVisible(true);
	}
}

class Lamina_spring extends JPanel{
	public Lamina_spring() {
		
		SpringLayout miLayout = new SpringLayout();
		setLayout(miLayout);
		
		JButton boton1 = new JButton("boton1");
		JButton boton2 = new JButton("Boton2");
		JButton boton3 = new JButton("Boton3");
		
		add(boton1);
		add(boton2);
		add(boton3);
		
		Spring miSpring = Spring.constant(0,10,100);
		
		//Antes del primer boton
		miLayout.putConstraint(SpringLayout.WEST, boton1, miSpring, SpringLayout.WEST, this);
		//(punto inicial, componente inicial, objeto Spring construido, 
		// 		donde tiene que ir este recien construido objeto Spring, de dónde ||esta lamina)
		
		//antes del segundo boton
		miLayout.putConstraint(SpringLayout.WEST, boton2, miSpring, SpringLayout.EAST, boton1);
		miLayout.putConstraint(SpringLayout.WEST, boton3, miSpring, SpringLayout.EAST, boton2);
		miLayout.putConstraint(SpringLayout.EAST, this, miSpring, SpringLayout.EAST, boton3);
		
		
	}
}





















