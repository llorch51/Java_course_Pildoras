package graficosSWING;

import java.awt.BorderLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;

public class VeintiSiete_JPopupMenu {

	public static void main(String[] args) {
		Marco_JPopup miMarco = new Marco_JPopup();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco_JPopup extends JFrame{
	public Marco_JPopup() {
		setTitle("JPopupMenu");
		setBounds(300, 300, 600, 400);
		
		
		add(new Lamina_JPopup());
		setVisible(true);
	}
}

class Lamina_JPopup extends JPanel{
	public Lamina_JPopup() {
		setLayout(new BorderLayout());
		setBackground(SystemColor.window);
		
		JPanel lamina_menu = new JPanel();
			lamina_menu.setLayout(new BorderLayout());
		JMenuBar barraMenu = new JMenuBar();
			JMenu fuente = new JMenu("Fuente");
			JMenu estilo = new JMenu("Estilo");
			JMenu tamano = new JMenu("Tamaño");
		barraMenu.add(fuente);
		barraMenu.add(estilo);
		barraMenu.add(tamano);
		lamina_menu.add(barraMenu, BorderLayout.NORTH);
		
		JPopupMenu emergente = new JPopupMenu();
		JMenu opcion = new JMenu("Estilo");
			JMenuItem negrita = new JMenuItem("Negrita");
			JMenuItem cursiva = new JMenuItem("Cursiva");
		opcion.add(negrita);
		opcion.add(cursiva);
		emergente.add(opcion);
		//emergente.add(negrita);
		//emergente.add(cursiva);
		
		JTextPane miArea = new JTextPane();
		miArea.setComponentPopupMenu(emergente);//Sobre cual elemento funcionará el menu
		
		add(miArea, BorderLayout.CENTER);
		add(lamina_menu, BorderLayout.NORTH);
	}
}