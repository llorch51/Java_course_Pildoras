package excepciones;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Uno_FallosGeneral_IOExce_y_Runtime {

	public static void main(String[] args) {
		Marco_Imagen mi_marco = new Marco_Imagen();
		mi_marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}

class Marco_Imagen extends JFrame{
	public Marco_Imagen() {
		setTitle("Fallos IOException");
		setBounds(300, 300, 600, 400);
		
		add(new Lamina_Imagen());
		setVisible(true);
	}
}

class Lamina_Imagen extends JPanel{
	public Lamina_Imagen() {
		
		//Excepcion comprobada, que ya hay formas designadas por si algo sale mal
		//ImageIO.read
		//IOException -- obligan a implementar el Try-Catch
		//Errores Comprobados
		try {
			imagen = ImageIO.read(new File("src/icon9/italic.png"));//ruta equivocada para hacer ejemplo
		} catch (IOException e) {
			System.out.println("Imagen No se Encuentra");
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		
		//RuntimeException
		//No comprobado
		//Errores que devienen de la falta de pericia al programar
		//*****Si la imagen no se encuentra ¿qué va a cargar el metodo?+++
		//está en nuestra mano mejorar el código para preveer estos errores 
		if (imagen == null) {
			g.drawString("No se ha podido cargar la imagen", 15	, 15);
		}else {
			
			int anchuraImagen = imagen.getWidth(this);
			int alturaImagen = imagen.getHeight(this);
			
			g.drawImage(imagen, 0, 0, null);
			
			for (int i = 0; i < 300; i++) {
				for (int j = 0; j < 200; j++) {
					if (i+j > 0) {
						g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i , alturaImagen * j);
					}
				}
			}
		}
		
	}
	
	private Image imagen;
}