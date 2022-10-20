package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;


public class VeintiOcho_BarraHerramientas {

	public static void main(String[] args) {
		Marco_tool miMarco = new Marco_tool();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco_tool extends JFrame{
	public Marco_tool() {
		setTitle("Barra de herramientas");
		setBounds(300, 300, 800, 400);
		
		
		add(new lamina_tool());
		setVisible(true);
	}
}

class lamina_tool extends JPanel{
	public lamina_tool() {
		setLayout(new BorderLayout());
		
		JPanel lamina_menu = new JPanel();
		lamina_menu.setLayout(new BorderLayout());
		
		ImageIcon amarilloIcon = new ImageIcon("src/cursoJava_graficosSWING/amarilloicon.png");
		ImageIcon redIcon = new ImageIcon("src/cursoJava_graficosSWING/rojoicon.png");
		ImageIcon azulIcon = new ImageIcon("src/cursoJava_graficosSWING/azulicon.png");
		ImageIcon exit = new ImageIcon("src/icon/exiticon.png");
		Action accionAmarillo=new AccionColor("Amarillo", 
				new ImageIcon(amarilloIcon.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)),
				new Color(255,185,0));
		Action accionAzul=new AccionColor("Azul", 
				new ImageIcon(azulIcon.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)),
				new Color(0,120,215));
		Action accionRojo=new AccionColor("Rojo", 
				new ImageIcon(redIcon.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)),
				new Color(232,17,35));
		
		Action accionSalir = new AbstractAction("Salir", new ImageIcon(exit.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT))) {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		};
		
		JMenuBar barra_menu = new JMenuBar();
		JMenu menu = new JMenu("Color");
			menu.add(accionRojo);
			menu.add(accionAmarillo);
			menu.add(accionAzul);
		barra_menu.add(menu);
		lamina_menu.add(barra_menu, BorderLayout.NORTH);
		
		//*****************JToolBar
		JToolBar barra = new JToolBar();
			barra.add(accionAmarillo);
			barra.add(accionRojo);
			barra.add(accionAzul);
			barra.addSeparator();
			barra.add(accionSalir);
		
		add(barra, BorderLayout.SOUTH);
		add(lamina_menu, BorderLayout.NORTH);
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















