package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import org.omg.CORBA.PRIVATE_MEMBER;

public class VeintiSeis_ProcesadorTexto_Practica {

	public static void main(String[] args) {
		Marco_Procesador miMarco = new Marco_Procesador();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

//+++++++++++++++++++++++++++++++++

class Marco_Procesador extends JFrame{
	public Marco_Procesador() {
		setTitle("Pocesador de texto");
		setBounds(300, 300, 600, 400);
		
		
		add(new Lamina_Procesador());
		setVisible(true);
	}
}

//++++++++++++++++++++++++++
class Lamina_Procesador extends JPanel{
	public Lamina_Procesador() {
		setLayout(new BorderLayout());
		setBackground(SystemColor.window);
		
		JPanel lamina_menu = new JPanel();
		lamina_menu.setLayout(new BorderLayout());
		
		miArea = new JTextPane();
		
		JMenuBar menuBar = new JMenuBar();
		fuente = new JMenu("Fuente");
		//		(nombre variable String, menú al que irá, tipo de letra en SetFont, estilo de letra Font.ESTILO, tamaño de letra)
			configura_menu("Arial", "Fuente", "Arial", 9, 10);
			configura_menu("Courier", "Fuente", "Courier", 9, 10);
			configura_menu("Verdana", "Fuente", "Verdana", 9, 10);
		estilo = new JMenu("Estilo");
			configura_menu("Negrita", "Estilo", " ", Font.BOLD, 1);
			configura_menu("Cursiva", "Estilo", " ", Font.ITALIC, 1);
		tamano = new JMenu("Tamaño");
			configura_menu("12", "tamaño", " ", 9, 12);
			configura_menu("16", "tamaño", " ", 9, 16);
			configura_menu("20", "tamaño", " ", 9, 20);
			configura_menu("24", "tamaño", " ", 9, 24);
			
			
		menuBar.add(fuente); menuBar.add(estilo); menuBar.add(tamano);
		lamina_menu.add(menuBar, BorderLayout.NORTH);

		//***********añadir a laminas correspondientes
		add(miArea, BorderLayout.CENTER);
		add(lamina_menu, BorderLayout.NORTH);
	}
	//Metodo para crear y poner a la escucha los elementos
	public void configura_menu(String rotulo_boton, String menu_opcion, String tipo_letra,
			int estilo_letra, int tamano_letra) {
		
		JMenuItem elemento_menu = new JMenuItem(rotulo_boton);
		
		if(menu_opcion.equalsIgnoreCase("fuente")) {
			fuente.add(elemento_menu);
		}else if (menu_opcion.equalsIgnoreCase("estilo")) {
			estilo.add(elemento_menu);
		}else if (menu_opcion.equalsIgnoreCase("tamaño")) {
			tamano.add(elemento_menu);
		}
		
		elemento_menu.addActionListener(new Gestiona_Eventos(rotulo_boton, tipo_letra, estilo_letra, tamano_letra));
	}
	
	//Clase interna gestiona eventos
	private class Gestiona_Eventos implements ActionListener{

		String tipo_letra2, elemento_menu2;
		int estilo_letra2=0, tamano_letra2=0;
		
		public Gestiona_Eventos(String elemento_menu2, String tipo_letra2, int estilo_letra2, int tamano_letra2) {
			this.tipo_letra2=tipo_letra2;
			this.estilo_letra2= estilo_letra2;
			this.tamano_letra2= tamano_letra2;
			this.elemento_menu2=elemento_menu2;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			letras=miArea.getFont();
			
			if(elemento_menu2=="Arial" || elemento_menu2=="Courier" || elemento_menu2=="Verdana") {
				estilo_letra2=letras.getStyle();
				tamano_letra2=letras.getSize();
				
			}else if (elemento_menu2=="Cursiva" || elemento_menu2=="Negrita") {
				
				if(letras.getStyle()==1 || letras.getStyle()==2) {
					estilo_letra2=3;
				}
				tipo_letra2=letras.getFontName();
				tamano_letra2=letras.getSize();
				
			}else if (elemento_menu2=="12" || elemento_menu2=="16" || elemento_menu2=="20" || elemento_menu2=="24") {
				estilo_letra2=letras.getStyle();
				tipo_letra2=letras.getFontName();
			}
			miArea.setFont(new Font(tipo_letra2, estilo_letra2, tamano_letra2));
			System.out.println("Tipo: "+ tipo_letra2+ " Estilo: "+estilo_letra2+" Tamaño: "+tamano_letra2);
		}
		
	}
	//propiedades
	private JTextPane miArea;
	private JMenu fuente, estilo, tamano;
	private Font letras;
}