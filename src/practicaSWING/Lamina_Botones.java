package practicaSWING;

import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Lamina_Botones extends JPanel {
	
	public Lamina_Botones(String titulo, String[] opciones ) {//(titulo de la caja, opciones de radioButton)
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));//Bordes para las cajas
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//(sobre cual componente, disposicion vertical)
		
		grupo = new ButtonGroup();//Grupo parabotones
		
		for (int i = 0; i < opciones.length; i++) {//se crearán el numero de botones que elementos haya en el array
			JRadioButton boton = new JRadioButton(opciones[i]);//llevarán por nombre el string que encuentre en cada posicion
			boton.setActionCommand(opciones[i]);
			add(boton);//se añaden a la lamina
			
			grupo.add(boton);// se añaden al grupo de botones
			
			boton.setSelected(i == 0);//para que quede seleccionado el primero por defecto
		}
		
	}
	
	public String dameSeleccion() {
		
		ButtonModel miBoton = grupo.getSelection();//se almacena el radioButton que tenemos seleccionado, con metodo getSelection()
		String miOpcionSeleccionada = miBoton.getActionCommand();//devuelve el String del boton que tenemos seleccionado
		
		return miOpcionSeleccionada;
	}
	
	ButtonGroup grupo;
}
