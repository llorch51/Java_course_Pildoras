package graficosSWING;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VeintiCinco_JMenu {

	public static void main(String[] args) {
		MarcoJMenu miMarco = new MarcoJMenu();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoJMenu extends JFrame{
	public MarcoJMenu() {
		setTitle("JMenu");
		setBounds(300, 300, 600, 400);
		
		add(new MenuLayer());
		setVisible(true);
	}
}

class MenuLayer extends JPanel{
	public MenuLayer() {
		setLayout(new BorderLayout());
		
		JMenuBar miMenuBar = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardarComo = new JMenuItem("Guardar Como...");
		archivo.add(guardar);
		archivo.add(guardarComo);
		
		JMenu edicion = new JMenu("Edicion");
		JMenuItem cortar = new JMenuItem("Cortar", 
				new ImageIcon("src\\icon\\cut.png"));
		JMenuItem copiar = new JMenuItem("Copiar",
				new ImageIcon("src\\icon\\copy.png"));
		JMenuItem pegar = new JMenuItem("Pegar",
				new ImageIcon("src\\icon\\paste.png"));
		JMenu opcion = new JMenu("Opciones");
		JMenuItem pito = new JMenuItem("Pito");
		JMenuItem conio = new JMenuItem("Coño");
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.addSeparator();
		edicion.add(opcion);
		opcion.add(pito);
		opcion.add(conio);
		
		JMenu herramientas = new JMenu("Herramientas");
		JMenuItem generales = new JMenuItem("Generales");
		herramientas.add(generales);
		
		miMenuBar.add(archivo);
		miMenuBar.add(edicion);
		miMenuBar.add(herramientas);
		
		add(miMenuBar, BorderLayout.NORTH);
		
	}
}
