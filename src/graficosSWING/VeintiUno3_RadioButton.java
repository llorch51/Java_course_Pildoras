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

public class VeintiUno3_RadioButton {

	public static void main(String[] args) {
		Marco_Radio3 miMarco= new Marco_Radio3();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
//+++++++++++++++++++++++
class Marco_Radio3 extends JFrame{
	public Marco_Radio3() {
		setTitle("RadioButton2");
		setBounds(300, 300, 600, 400);
		
		
		add(new Lamina_Radio3());
		setVisible(true);
	}
}

//++++++++++++++++++++++++++
class Lamina_Radio3 extends JPanel{
	public Lamina_Radio3() {
		//Disposicion por defecto
		setLayout(new BorderLayout());
		setBackground(SystemColor.window);
		
		//elementos graficos
		texto1=new JLabel("En algun lugar de la mancha de cuyo nombre...");
		texto1.setFont(new Font("Serif", Font.PLAIN, 16));
		lamina_radios=new JPanel();
		miButtonGroup= new ButtonGroup();
		
		//metodo para construir radios
		colocarRadio("Pequeño", false, 10);
		colocarRadio("Mediano", true, 16);
		colocarRadio("Grande", false, 24);
		colocarRadio("Muy Grande", false, 30);
		
		//añadir elementos a la lamina correspondiente
		add(lamina_radios, BorderLayout.SOUTH);
		add(texto1, BorderLayout.CENTER);
	}
	
	//metodo
	public void colocarRadio(String nombre, boolean seleccionado, int fontSize) {
		JRadioButton boton= new JRadioButton(nombre, seleccionado);
		miButtonGroup.add(boton);
		lamina_radios.add(boton);
		/*
		ActionListener miEvento= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				texto1.setFont(new Font("Serif", Font.PLAIN, fontSize));
				
			}
		};
		*/
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				texto1.setFont(new Font("Serif", Font.PLAIN, fontSize));
				
			}
		});//añadir al boton la capacidad de escuchar
		//instanciando directamente en el parametro un objeto de tipo ActionListener
	}
	//Propiedades
	private JLabel texto1;
	private JPanel lamina_radios;
	private ButtonGroup miButtonGroup;
}