package graficosSWING;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Siete_Botones_Eventos {

	public static void main(String[] args) {

		MarcoBotones miMarco=new MarcoBotones();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}

//+++++++++++++CLASEE++++++++++++++++

class MarcoBotones extends JFrame{
	
	public MarcoBotones() {
		setTitle("Botones y Eventos");
		setBounds(700, 300, 500, 300);
		
		LaminaBotones miLamina=new LaminaBotones();
		add(miLamina);
		miLamina.setBackground(SystemColor.window);
	}
}

//+++++++++++++++++++++CLASEE++++++++++++++++++++++

class LaminaBotones extends JPanel implements ActionListener{
	
	JButton azulButton=new JButton("Azul");
	JButton redButton=new JButton("Red");
	JButton yellowButton= new JButton("Yellow");
	//constructor
	public LaminaBotones() {
		add(azulButton);
		add(redButton);
		add(yellowButton);
		//ObjetoDesencadenante.metodo(sobre cual objeto actuará)
		azulButton.addActionListener(this);//QUIEN||(this)listener, la misma lamina, SOBRE QUIEN
		redButton.addActionListener(this);
		yellowButton.addActionListener(this);
	}
	
	//Metodo obligado de la interfaz ActionListener
	public void actionPerformed(ActionEvent e) {//objeto de tipo ActionEvent como parametro
		Object botonPulsado= e.getSource();//objeto de tipo Object para saber la fuente del evento(quien desencadena el evento)
		
		if(botonPulsado==azulButton) {
			setBackground(new Color(0,120,215));
		}
		else if(botonPulsado==redButton) {
			setBackground(new Color(232,17,35));
		}
		else {
			setBackground(new Color(255,185,0));
		}
		
	}
	
}
