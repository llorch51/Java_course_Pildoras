package graficosSWING;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cuatro_Colores {

	public static void main(String[] args) {

		
		MarcoColor miMarco=new MarcoColor();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		
	}

}

//++++++++++++CLASEE++++++++++++++

class MarcoColor extends JFrame{
	
	public MarcoColor() {
		
		setTitle("Prueba con colores");
		setSize(600, 600);
		setLocation(500, 300);
		
		LaminaColor miLamina=new LaminaColor();
		add(miLamina);
		miLamina.setBackground(SystemColor.window);;
	}
}

class LaminaColor extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;//refundicion
		g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)); //Antialiasing
		
		Rectangle2D rectangle2d=new Rectangle2D.Double(100, 100, 400, 350);//(ubicacionX,UbicacionY, tamanoX, tamanoY)
		g2.setPaint(new Color(52,73,94).darker());
		g2.fill(rectangle2d);
		
		Ellipse2D ellipse2d=new Ellipse2D.Double();
		ellipse2d.setFrame(rectangle2d);
		g2.setPaint(new Color(192,57,43).brighter());
		g2.fill(ellipse2d);
		
	}
}
