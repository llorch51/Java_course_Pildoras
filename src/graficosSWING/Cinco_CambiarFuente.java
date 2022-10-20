package graficosSWING;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cinco_CambiarFuente {

	public static void main(String[] args) {

		MarcoColor2 miMarco=new MarcoColor2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}

class MarcoColor2 extends JFrame{
	
	public MarcoColor2() {
		
		setTitle("Prueba con FUENTES");
		setSize(600, 400);
		setLocation(500, 300);
		
		LaminaColor2 miLamina=new LaminaColor2();
		add(miLamina);
		miLamina.setBackground(SystemColor.window);;
	}
}

class LaminaColor2 extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;//refundicion
		g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)); //Antialiasing
		
		Font miFont=new Font("Arial", Font.BOLD, 46);
		g2.setFont(miFont);
		g2.setColor(Color.red);
		g2.drawString("Pirrin de mono peludo", 50, 100);
		
		g2.setFont(new Font("Courier", Font.ITALIC, 18));
		g2.setColor(new Color(255,140,0));
		g2.drawString("Curso de Java", 400, 200);
	}
}
