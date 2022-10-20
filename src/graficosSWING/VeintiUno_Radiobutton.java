package graficosSWING;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VeintiUno_Radiobutton {

	public static void main(String[] args) {
		MarcoRadios miMarcoRadios= new MarcoRadios();
		miMarcoRadios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

//+++++++++++++++++++++++

class MarcoRadios extends JFrame{
	public MarcoRadios() {
		setTitle("RadioButtons");
		setBounds(300, 300, 600, 400);
		
		
		
		add(new LaminaRadios());
		setVisible(true);
	}
}

//++++++++++++++++++
class LaminaRadios extends JPanel{
	public LaminaRadios() {
		ButtonGroup miButtonGroup= new ButtonGroup();
		ButtonGroup miButtonGroup2= new ButtonGroup();
		
		JRadioButton boton1= new JRadioButton("Azul", false);
		JRadioButton boton2= new JRadioButton("Rojo", true);
		JRadioButton boton3= new JRadioButton("Verde", false);
		
		JRadioButton boton4= new JRadioButton("Masculino", false);
		JRadioButton boton5= new JRadioButton("Femenino", false);
		
		miButtonGroup.add(boton1);
		miButtonGroup.add(boton2);
		miButtonGroup.add(boton3);
		
		miButtonGroup2.add(boton4);
		miButtonGroup2.add(boton5);
		//*****NO SE PUEDE AGREGAR EL OBJETO DE GRUPO DE BOTONES A LA CAPA****
		
		add(boton1);
		add(boton2);
		add(boton3);
		
		add(boton4);
		add(boton5);
		
	}
}