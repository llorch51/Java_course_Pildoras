package graficosSWING;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dos_EscribiendoEnMarco {

	public static void main(String[] args) {

		MarcoConTexto miMarco=new MarcoConTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

//+++++++++++++CLASE+++++++++++++++
//Jframe es la ventana
class MarcoConTexto extends JFrame{
	
	public MarcoConTexto() {
		setVisible(true);
		setSize(600, 450);
		setLocation(400, 200);
		setTitle("Textoo");
		
		Lamina miLamina=new Lamina();//crear objeto de clase Lamina(layer)
		add(miLamina);//agregarlo a la ventana
	}
}

//++++++++OTRAA CLAASEEEE++++++++++++
//JPanel es la herramienta de "laminas"(layers) para pintar/poner sobre el Jframe
//Desarrollo de otra Clase para implementar  clase JPanel porque necesitamos sobreescribir metodo paintComponent
//con objeto Graphics como parametro
class Lamina extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Pepe pecas Swing", 100, 100);
	}
}
