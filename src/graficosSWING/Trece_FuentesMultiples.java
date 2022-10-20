package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

//BOTON Y TECLADO COMO FUENTES
//LAMINA COMO OYENTE
public class Trece_FuentesMultiples {

	public static void main(String[] args) {
		MarcoAccion miMarcoAccion=new MarcoAccion();
		miMarcoAccion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoAccion.setVisible(true);
	}

}

//++++++++++++++++++++++++++++++++++++
//Marco
class MarcoAccion extends JFrame{
	
	public MarcoAccion() {
		setTitle("Prueba Acciones");
		setBounds(300, 300, 1000, 600);
		
		LaminaAccion lamina=new LaminaAccion();
		add(lamina);
		lamina.setBackground(SystemColor.window);
		
		
	}
}

//++++++++++++++++++++++++++++++++
//Lamina donde se construyen los elementos||fuente de los eventos
class LaminaAccion extends JPanel{
	//constructor
	public LaminaAccion() {
		
		/*
		JButton amarilloButton= new JButton("Amarillo");
		JButton rojoButton= new JButton("Rojo");
		JButton azulButton= new JButton("Azul");
		
		add(amarilloButton);
		add(rojoButton);
		add(azulButton);
		*/
		
		AccionColor accionAmarillo=new AccionColor("Amarillo", 
				new ImageIcon("src/cursoJava_graficosSWING/amarilloicon.png"),
				new Color(255,185,0));//rgb(0,120,215)azul, rgb(232,17,35)rojo
		AccionColor accionAzul=new AccionColor("Azul", 
				new ImageIcon("src/cursoJava_graficosSWING/azulicon.png"),
				new Color(0,120,215));
		AccionColor accionRojo=new AccionColor("Rojo", 
				new ImageIcon("src/cursoJava_graficosSWING/rojoicon.png"),
				new Color(232,17,35));
		
		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));
		
		//********Hacer combinacion de teclas para desencadenar evento*****
		//Mapa de entrada
		InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");//combinacion de teclas
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl Y"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");//(combinacion de teclas, objeto asociado)
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
		ActionMap mapaAccion=getActionMap();
		mapaAccion.put("fondo_amarillo", accionAmarillo);//(objeto, accion asociada)
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
	}
	
	//++++++++++++++++++++++++++++CLASE INTERNA
	//lamina que escuchara/hara eventos
	private class AccionColor extends AbstractAction{
		
		//constructor
		//putValue almacena la informacion de los elementos en valores pares
		public AccionColor(String nombre, Icon icono, Color color_boton) {
			putValue(Action.NAME, nombre);//campos estaticos de interfaz Action
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color "+nombre);
			putValue("color_de_fondo", color_boton);//(Clave, valor)
		}

		@Override
		public void actionPerformed(ActionEvent e) {//qué hacer cuando sean pulsados
			Color c=(Color) getValue("color_de_fondo");
			setBackground(c);//al ser clase interna, ya reconoce SetBackground de Jpanel
			
			System.out.println("Nombre: "+getValue(Action.NAME)+ ". Descripcion: "+getValue(Action.SHORT_DESCRIPTION));
		}
		
	}
}


