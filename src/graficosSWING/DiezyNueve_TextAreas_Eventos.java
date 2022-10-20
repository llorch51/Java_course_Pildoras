package graficosSWING;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;

public class DiezyNueve_TextAreas_Eventos {

	public static void main(String[] args) {
		
		FrameArea miMarco=new FrameArea();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

//++++++++++++++++++++++++++++++-
class FrameArea extends JFrame{
	public FrameArea() {
		setTitle("TextArea");
		setBounds(300, 300, 600, 400);
		//setBackground(SystemColor.window);
		
		add(new LayerArea());
		setVisible(true);
	}
}

//+++++++++++++++++++++++++++++

class LayerArea extends JPanel{
	public LayerArea() {
		//setBackground(SystemColor.window);
		
		//elementos graficos
		miArea= new JTextArea(8,15);
		miArea.setBorder(new BasicBorders.FieldBorder(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		miArea.setLineWrap(true);
		JScrollPane myScroll= new JScrollPane(miArea);//capa con barras de desplazamiento
		JButton myButton= new JButton("Dale un poco más");
		
		//poner a la escucha los elementos deseados
		myButton.addActionListener(new GestionArea());
		
		//añadir a la capa en el orden deseado
		add(myScroll);//añadir esa capa en vez del JTextArea
		add(myButton);
	}
	//CLASE INTERNA para gestion de eventos
	private class GestionArea implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(miArea.getText().trim());
			
		}
		
	}
	
	//Propiedades
	private JTextArea miArea;
}
