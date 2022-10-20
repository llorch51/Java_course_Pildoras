package graficosSWING;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tres_Prueba_Dibujo {

	public static void main(String[] args) {

		MarcoConDibujos miMarco=new MarcoConDibujos();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

//+++++++++++++++++++CLASEEE++++++++++++++++++++++
//ventana
class MarcoConDibujos extends JFrame{
	
	public MarcoConDibujos() {
		
		setTitle("Prueba dibujo");
		setSize(400,400);
		Laminafiguras miLamina=new Laminafiguras();
		add(miLamina);
		
	}
}

//+++++++++++++++++++++CLASE++++++++++++++++++
//Layer sobre ventana
class Laminafiguras extends JPanel{
	
	//Sobreescritura de metodo paintComponent de clase JPanel
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//g.drawRect(50, 50, 200, 200);
		//g.drawLine(100, 100, 300, 200);
		//g.drawArc(50, 100, 100, 200, 120, 150);
		
		Graphics2D g2=(Graphics2D) g;//refundicion de objeto g pra utilizar Graphics2D
		g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)); //Antialiasing
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
		g2.draw(rectangulo);
		
		Ellipse2D elipse=new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.draw(elipse);
		g2.draw(new Line2D.Double(100,100,300,250));
		
		double CentroX =rectangulo.getCenterX();
		double CentroY =rectangulo.getCenterY();
		double radio=150;
		
		Ellipse2D circulo=new Ellipse2D.Double();
		circulo.setFrameFromCenter(CentroX, CentroY, CentroX+radio, CentroY+radio);
		g2.draw(circulo);
		


	}
}
