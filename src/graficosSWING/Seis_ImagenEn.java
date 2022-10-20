package graficosSWING;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Seis_ImagenEn {

	public static void main(String[] args) {

		MarcoImagen miMarco=new MarcoImagen();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}


class MarcoImagen extends JFrame{
	
	public MarcoImagen() {
		
		setTitle("Prueba con IMAGENES");
		setSize(600, 600);
		setLocation(500, 300);
		
		LaminaImagen miLamina=new LaminaImagen();
		add(miLamina);
		miLamina.setBackground(SystemColor.window);
	}
}

class LaminaImagen extends JPanel{
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//File miFile=new File("D:\\DescargasSSD\\Imagenes\\superllorch.jpg");
		File miFile=new File("F:\\Descargas\\Taza\\ra.jpg");
		
		try {
		imagen=ImageIO.read(miFile);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		//g.drawImage(imagen, 5, 5, null);
		g.drawImage(imagen.getScaledInstance(500, -1, Image. SCALE_SMOOTH), 10, 10, this);//Escalar imagen
		
		
	}
	
	private Image imagen;
}