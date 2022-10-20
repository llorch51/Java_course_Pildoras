package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VeintiUno2_RadioButton {

	public static void main(String[] args) {
		MarcoRadios2 miMarco=new MarcoRadios2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//++++++++++++++++++++++++++
class MarcoRadios2 extends JFrame{
	public MarcoRadios2() {
		setTitle("RadioButton2");
		setBounds(300, 300, 600, 400);
		
		
		
		add(new Lamina_Radio2());
		
		setVisible(true);
	}
}

//+++++++++++++++++++++++++++++++++++
class Lamina_Radio2 extends JPanel{
	public Lamina_Radio2() {
		setLayout(new BorderLayout());
		setBackground(SystemColor.window);
		
		texto1=new JLabel("En un lugar de la mancha de cuyo nombre...");
		ButtonGroup miButtonGroup= new ButtonGroup();
		boton1= new JRadioButton("Pequeño", false);
		boton2= new JRadioButton("Mediano", true);
		boton3= new JRadioButton("Grande", false);
		boton4= new JRadioButton("Muy Grande", false);
		
		miButtonGroup.add(boton1);
		miButtonGroup.add(boton2);
		miButtonGroup.add(boton3);
		miButtonGroup.add(boton4);
		
		JPanel laminaRadioPanel= new JPanel();
		laminaRadioPanel.add(boton1);
		laminaRadioPanel.add(boton2);
		laminaRadioPanel.add(boton3);
		laminaRadioPanel.add(boton4);
		
		boton1.addActionListener(new Evento_Radios());
		boton2.addActionListener(new Evento_Radios());
		boton3.addActionListener(new Evento_Radios());
		boton4.addActionListener(new Evento_Radios());
		
		add(texto1, BorderLayout.CENTER);
		add(laminaRadioPanel, BorderLayout.SOUTH);
	}
	
	//Clase interna para manejar los eventos
	private class Evento_Radios implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==boton1) {
				texto1.setFont(new Font("Serif", Font.PLAIN, 10));
			}else if (e.getSource()==boton2) {
				texto1.setFont(new Font("Serif", Font.PLAIN, 14));
			}else if (e.getSource()==boton3) {
				texto1.setFont(new Font("Serif", Font.PLAIN, 20));
			}else if (e.getSource()==boton4) {
				texto1.setFont(new Font("Serif", Font.PLAIN, 32));
			}
			
		}
		
	}
	
	//propiedades
	private JLabel texto1;
	private JRadioButton boton1, boton2, boton3, boton4;
}