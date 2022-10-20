package graficosSWING;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Uno2_MarcoCentrado {

	public static void main(String[] args) {

		MarcoCentrado miMarcoCentrado=new MarcoCentrado();
		miMarcoCentrado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoCentrado.setVisible(true);
	}

}


//++++++++++++OTRA CLASE++++++++++++++++

class MarcoCentrado extends JFrame{
	public MarcoCentrado() {
		
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		
		Dimension tamanoPantalla=miPantalla.getScreenSize();
		
		int hPantalla=tamanoPantalla.height;
		int anchoPantalla=tamanoPantalla.width;
		
		setSize(anchoPantalla/2, hPantalla/2);
		setLocation(anchoPantalla/4, hPantalla/4);
		
		setTitle("marcoCentrado");
		Image miIcono=miPantalla.getImage("icono.gif");
		setIconImage(miIcono);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
	}
}