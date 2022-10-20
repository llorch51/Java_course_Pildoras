package graficosSWING;
import java.awt.Frame;

import javax.swing.*;

public class Uno_CreandoMarcos {

	public static void main(String[] args) {

		miMarco marco1=new miMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

//++++++++++++Otra CLASEE+++++

class miMarco extends JFrame{
	
	public miMarco() {
		//setSize(500, 300); //de la ventana
		//setLocation(500, 300);	// colocacion de ventana
		setBounds(500, 300, 600, 400);//anteriores, pero en uno solo
		//setResizable(false);
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Pirrín de monoo!!!");
	}
}
