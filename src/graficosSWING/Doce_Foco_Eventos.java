package graficosSWING;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Doce_Foco_Eventos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoFoco miMarcoFoco=new MarcoFoco();
	}

}
//+++++++++++++++++++++++++++++++++

class MarcoFoco extends JFrame{
	
	public MarcoFoco() {
		setTitle("Foco");
		setVisible(true);
		setBounds(300, 300, 600, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LaminaFoco());
	}
}
//+++++++++++++++++++++++++++++++++++

class LaminaFoco extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLayout(null);//acomodo de los elementos por defecto
		cuadro1=new JTextField();
		cuadro2=new JTextField();
		
		cuadro1.setBounds(120, 10, 150, 20);
		cuadro2.setBounds(120, 50, 150, 20);
		
		add(cuadro1);
		add(cuadro2);
		
		LanzaFoco foco=new LanzaFoco();
		cuadro1.addFocusListener(foco);//poner a la escucha
	}
	//******************CLASEE INTERNAA
	//para poder acceder a propiedades JTextfield
	private class LanzaFoco implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {

			
		}

		@Override
		public void focusLost(FocusEvent e) {
			String email=cuadro1.getText();
			boolean comprobar=false;
			
			for(int i=0; i<email.length();i++) {
				if(email.charAt(i)=='@') {
					comprobar=true;
				}
			}
			if(comprobar) {
				System.out.println("Correcto");
			}else {
				System.out.println("Incorrecto");
			}
		}
		
	}
	
	JTextField cuadro1, cuadro2;
}

//+++++++++++++++++++++++
