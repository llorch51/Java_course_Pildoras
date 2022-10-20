package graficosSWING;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Seis2_ImagenEn {

	public static void main(String[] args) {

		MarcoImagen2 miMarco=new MarcoImagen2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}


class MarcoImagen2 extends JFrame{
	
	public MarcoImagen2() {
		
		setTitle("Prueba con IMAGENES");
		setSize(600, 600);
		setLocation(500, 300);
		
		LaminaImagen2 miLamina=new LaminaImagen2();
		add(miLamina);
		miLamina.setBackground(SystemColor.window);;
	}
}


class LaminaImagen2 extends JPanel{
	
	public LaminaImagen2() {
		try {
			imagen=ImageIO.read(new File("F:\\Descargas\\pepa.jpg"));
			}
			catch (IOException e) {
				System.out.println(e);
			}
	}
	//metodo
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//File miFile=new File("D:\\DescargasSSD\\Imagenes\\superllorch.jpg");
		//File miFile=new File("F:\\Descargas\\pepa.jpg");
		
		int anchuraImagen=imagen.getWidth(this);
		int alturaImagen=imagen.getHeight(this);
		g.drawImage(imagen, 5, 5, null);
		//Para repetir imagen
		for(int i=0;i<600;i++) {
			for(int j=0;j<600;j++) {
				g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
			}
		}
		
		//g.drawImage(imagen.getScaledInstance(500, -1, Image. SCALE_SMOOTH), 10, 10, this);
	}
	private Image imagen;
}