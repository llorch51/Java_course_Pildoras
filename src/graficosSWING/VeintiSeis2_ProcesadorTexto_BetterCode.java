package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class VeintiSeis2_ProcesadorTexto_BetterCode {

	public static void main(String[] args) {
		Marco_Procesador2 miMarco = new Marco_Procesador2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//+++++++++++++++++++++++++++++++++
//Marco comun y corriente
class Marco_Procesador2 extends JFrame{
	public Marco_Procesador2() {
		setTitle("Pocesador de texto con mejor Código");
		setBounds(300, 300, 600, 400);
		
		
		add(new Lamina_Procesador2());
		setVisible(true);
	}
}
//++++++++++++++++++++++++++

class Lamina_Procesador2 extends JPanel{
	public Lamina_Procesador2() {
		//disposicion por defecto de lamina principal
		setLayout(new BorderLayout());
		setBackground(SystemColor.window);
		
		//se crea una segunda lamina y se pone una disposicion
		JPanel lamina_menu = new JPanel();
		lamina_menu.setLayout(new BorderLayout());
		
		//inicializar textArea
		miArea = new JTextPane();
		
		//iniciar y construir menu
		JMenuBar menuBar = new JMenuBar();
		fuente = new JMenu("Fuente");
		//metodo para construir, añadir y poner a la escucha a los elementos
		//		(nombre variable String, menú al que irá, tipo de letra en SetFont, estilo de letra Font.ESTILO, tamaño de letra)
			configura_menu("Arial", "Fuente", "Arial", 9, 10,"");
			configura_menu("Courier", "Fuente", "Courier", 9, 10,"");
			configura_menu("Verdana", "Fuente", "Verdana", 9, 10,"");
		estilo = new JMenu("Estilo");
			//configura_menu("Negrita", "Estilo", " ", Font.BOLD, 1, "src\\icon\\bold.png");
			//configura_menu("Cursiva", "Estilo", " ", Font.ITALIC, 1, "src\\icon\\italic.png");
				JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("src\\icon\\bold.png"));
				JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("src\\icon\\italic.png"));
				negrita.addActionListener(new StyledEditorKit.BoldAction());
				cursiva.addActionListener(new StyledEditorKit.ItalicAction());
				negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));//Atajos de teclado
				cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));//atajos de teclado
			estilo.add(negrita);
			estilo.add(cursiva);
		tamano = new JMenu("Tamaño");
			//configura_menu("12", "tamaño", " ", 9, 12,"");
			//configura_menu("16", "tamaño", " ", 9, 16,"");
			//configura_menu("20", "tamaño", " ", 9, 20,"");
			//configura_menu("24", "tamaño", " ", 9, 24,"");
			ButtonGroup tamano_letra = new ButtonGroup();
				JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12", new ImageIcon("src\\icon\\fontsize.png"));
				JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16", new ImageIcon("src\\icon\\fontsize.png"));
				JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20", new ImageIcon("src\\icon\\fontsize.png"));
				JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24", new ImageIcon("src\\icon\\fontsize.png"));
				doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano", 12));
				dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano", 16));
				veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano", 20));
				veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano", 24));
				//veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
			tamano_letra.add(doce);
			tamano_letra.add(dieciseis);
			tamano_letra.add(veinte);
			tamano_letra.add(veinticuatro);
			tamano.add(doce);
			tamano.add(dieciseis);
			tamano.add(veinte);
			tamano.add(veinticuatro);
		//añadir elementos al MenuBar
		menuBar.add(fuente); menuBar.add(estilo); menuBar.add(tamano);
		
		//Elemento de menu emergente
		JPopupMenu emergente = new JPopupMenu();
		JMenu opcion1 = new JMenu("Estilo");
			JMenuItem negrita_E = new JMenuItem("Negrita");
			JMenuItem cursiva_E = new JMenuItem("Cursiva");
			negrita_E.addActionListener(new StyledEditorKit.BoldAction());
			cursiva_E.addActionListener(new StyledEditorKit.ItalicAction());
		opcion1.add(negrita_E);
		opcion1.add(cursiva_E);
		JMenu opcion2 = new JMenu("Tamaño");
			JMenuItem _12 = new JMenuItem("12");
			JMenuItem _16 = new JMenuItem("16");
			JMenuItem _20 = new JMenuItem("20");
			JMenuItem _24 = new JMenuItem("24");
			_12.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano", 12));
			_16.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano", 16));
			_20.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano", 20));
			_24.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano", 24));
		opcion2.add(_12);
		opcion2.add(_16);
		opcion2.add(_20);
		opcion2.add(_24);
		emergente.add(opcion1);
		emergente.add(opcion2);
		
		miArea.setComponentPopupMenu(emergente);
		
		//añadir menuBar a la lamina para el menu
		lamina_menu.add(menuBar, BorderLayout.NORTH);
		
		
		//*************JToolBar
		//JToolBar barra2 =new JToolBar();
		ImageIcon icono_negrita= new ImageIcon("src\\icon\\bold.png");
		ImageIcon icono_cursiva= new ImageIcon("src\\icon\\italic.png");
		ImageIcon icono_under = new ImageIcon("src\\icon\\under.png");
		ImageIcon icono_azul = new ImageIcon("src\\cursoJava_graficosSWING\\azulicon.png");
		ImageIcon icono_rojo = new ImageIcon("src\\cursoJava_graficosSWING\\rojoicon.png");
		ImageIcon icono_amarillo = new ImageIcon("src\\cursoJava_graficosSWING\\amarilloicon.png");
		ImageIcon icono_centrado = new ImageIcon("src\\icon\\center.png");
		ImageIcon icono_izq = new ImageIcon("src\\icon\\left.png");
		ImageIcon icono_der = new ImageIcon("src\\icon\\right.png");
		ImageIcon icono_justi = new ImageIcon("src\\icon\\justify.png");
		/*
		JButton underline_barra = new JButton(new ImageIcon(icono_under.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		JButton negrita_barra = new JButton(new ImageIcon(icono_negrita.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		JButton cursiva_barra = new JButton(new ImageIcon(icono_cursiva.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		JButton azul_barra = new JButton(new ImageIcon(icono_azul.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
			azul_barra.setToolTipText("Pone el texto color Azul");
		JButton rojo_barra = new JButton(new ImageIcon(icono_rojo.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		JButton amarillo_barra = new JButton(new ImageIcon(icono_amarillo.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		JButton centrado_barra = new JButton(new ImageIcon(icono_centrado.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		JButton izq_barra = new JButton(new ImageIcon(icono_izq.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		JButton der_barra = new JButton(new ImageIcon(icono_der.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		JButton justi_barra = new JButton(new ImageIcon(icono_justi.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		
			underline_barra.addActionListener(new StyledEditorKit.UnderlineAction());
			negrita_barra.addActionListener(new StyledEditorKit.BoldAction());//poner a la escucha y accion
			cursiva_barra.addActionListener(new StyledEditorKit.ItalicAction());//poner a la escucha y acccion
			azul_barra.addActionListener(new StyledEditorKit.ForegroundAction("texto_azul", new Color(0,120,215)));
			rojo_barra.addActionListener(new StyledEditorKit.ForegroundAction("texto_rojo", new Color(232,17,35)));
			amarillo_barra.addActionListener(new StyledEditorKit.ForegroundAction("texto_amarillo", new Color(255,185,0)));
			centrado_barra.addActionListener(new StyledEditorKit.AlignmentAction("texto_centrado", 1));
			izq_barra.addActionListener(new StyledEditorKit.AlignmentAction("texto_izq", 0));
			der_barra.addActionListener(new StyledEditorKit.AlignmentAction("texto_der", 2));
			justi_barra.addActionListener(new StyledEditorKit.AlignmentAction("texto_justi", 3));
			
		barra2.add(negrita_barra);
		barra2.add(cursiva_barra);
		barra2.add(underline_barra);
		barra2.addSeparator();
		barra2.add(azul_barra);
		barra2.add(rojo_barra);
		barra2.add(amarillo_barra);
		barra2.addSeparator();
		barra2.add(centrado_barra);
		barra2.add(izq_barra);
		barra2.add(der_barra);
		barra2.add(justi_barra);
		*/
		barra = new JToolBar();
		configura_barra(icono_negrita).addActionListener(new StyledEditorKit.BoldAction());
		configura_barra(icono_cursiva).addActionListener(new StyledEditorKit.ItalicAction());
		configura_barra(icono_under).addActionListener(new StyledEditorKit.UnderlineAction());
		barra.addSeparator();
		configura_barra(icono_amarillo).addActionListener(new StyledEditorKit.ForegroundAction("texto_amarillo", new Color(255,185,0)));
		configura_barra(icono_rojo).addActionListener(new StyledEditorKit.ForegroundAction("texto_rojo", new Color(232,17,35)));
		configura_barra(icono_azul).addActionListener(new StyledEditorKit.ForegroundAction("texto_azul", new Color(0,120,215)));
		barra.addSeparator();
		configura_barra(icono_justi).addActionListener(new StyledEditorKit.AlignmentAction("texto_justi", 3));
		configura_barra(icono_centrado).addActionListener(new StyledEditorKit.AlignmentAction("texto_centrado", 1));
		configura_barra(icono_izq).addActionListener(new StyledEditorKit.AlignmentAction("texto_izq", 0));
		configura_barra(icono_der).addActionListener(new StyledEditorKit.AlignmentAction("texto_der", 2));
		barra.setOrientation(1);// barra vertical
		
		//***********añadir a laminas correspondientes
		add(barra, BorderLayout.WEST);
		add(miArea, BorderLayout.CENTER);
		add(lamina_menu, BorderLayout.NORTH);
	}
	
	public JButton configura_barra(ImageIcon icono) {
		JButton boton = new JButton(new ImageIcon(icono.getImage().getScaledInstance(15, 15, java.awt.Image.SCALE_DEFAULT)));
		barra.add(boton);
		return boton;
	}
	
	
	//Metodo para crear y poner a la escucha los elementos
	//				(nombre variable String, menú al que irá, tipo de letra en SetFont, estilo de letra Font.ESTILO, tamaño de letra)
	public void configura_menu(String rotulo_boton, String menu_opcion, String tipo_letra,
			int estilo_letra, int tamano_letra, String ruta_icono) {
		
		//construccion del menuItem, cada elemento
		JMenuItem elemento_menu = new JMenuItem(rotulo_boton, new ImageIcon(ruta_icono));//String que llevará cada boton, el que se ve en el boton
		
		//añadir cada elemento creado a su respectivo menu, ponerlos a la escucha y acciones que harán
		if(menu_opcion.equalsIgnoreCase("fuente")) {
			fuente.add(elemento_menu);
			if (tipo_letra=="Arial") {
				elemento_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));//(" ", "TipoDeFuente")
			}else if (tipo_letra=="Courier") {
				elemento_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Courier"));
			}else if (tipo_letra=="Verdana") {
				elemento_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));
			}
			
		}
		/*
		else if (menu_opcion.equalsIgnoreCase("estilo")) {
			estilo.add(elemento_menu);
			if (estilo_letra==Font.BOLD) {
				elemento_menu.addActionListener(new StyledEditorKit.BoldAction());
			}else if (estilo_letra==Font.ITALIC) {
				elemento_menu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		}
		
		else if (menu_opcion.equalsIgnoreCase("tamaño")) {
			tamano.add(elemento_menu);
			elemento_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamano", tamano_letra));
		}
		*/
	}
	
	
	//propiedades
	private JTextPane miArea;
	private JMenu fuente, estilo, tamano;
	private JButton negrita_barra, cursiva_barra, sub_barra, azul_barra, 
	rojo_barra, amarillo_barra, centrado_barra, izq_barra, der_barra, justi_barra;
	private JToolBar barra;
}