package graficosSWING;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Siete2_Botones_Eventos {

	public static void main(String[] args) {

		MarcoBotones2 miMarco=new MarcoBotones2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}

//++++++++++++++++
class MarcoBotones2 extends JFrame{
	
	public MarcoBotones2() {
		setTitle("Botones y Eventos2");
		setBounds(700, 300, 500, 300);
		
		LaminaBotones2 miLamina=new LaminaBotones2();
		add(miLamina);
		miLamina.setBackground(SystemColor.window);
	}
}


//++++++++++++++++++++++
class LaminaBotones2 extends JPanel{
	
	JButton azulButton=new JButton("Azul");
	JButton redButton=new JButton("Red");
	JButton yellowButton= new JButton("Yellow");
	//constructor
	public LaminaBotones2() {
		add(azulButton);
		add(redButton);
		add(yellowButton);
		
		//objetos de clase ColorFondo, que son de tipo Color
		ColorFondo azul= new ColorFondo(new Color(0,120,215));
		ColorFondo rojo= new ColorFondo(new Color(232,17,35));
		ColorFondo amarillo= new ColorFondo(new Color(255,185,0));
		
		//ObjetoDesencadenante.metodo(sobre cual objeto actuará)
		azulButton.addActionListener(azul);//QUIEN||(this)listener, la misma lamina, SOBRE QUIEN
		redButton.addActionListener(rojo);
		yellowButton.addActionListener(amarillo);
	}
	
	//CLASE INTERNA
	private class ColorFondo implements ActionListener{
		
		//Constructor
		public ColorFondo (Color c) {
			colorFondo=c;
		}
		//Metodo de interfaz
		public void actionPerformed(ActionEvent e) {
			setBackground(colorFondo);
		}
		
		//Propiedades
		private Color colorFondo;
		
	}
}

//+++++++++++++++++++++++++++++++
