package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DiezySiete_JTextField {

	public static void main(String[] args) {
		
		MarcoTexto miMarcoTexto= new MarcoTexto();
		miMarcoTexto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

//++++++++++++++++++++++++++++++
//Ventana-Marco
class MarcoTexto extends JFrame{

	public MarcoTexto() {
		setBounds(500, 300, 600, 400);
		
		
		TextLayer miLayer= new TextLayer();//generar instancia de clase Layer
		miLayer.setBackground(SystemColor.window);
		add(miLayer);//añadir layer recien creado||add() viene de JFrame
		
		setVisible(true);
	}
	
}

//+++++++++++++++++++++++++++++++++
//Layer-Capa donde se 'dibuja' los elementos graficos
class TextLayer extends JPanel{
	public TextLayer() {
		setLayout(new BorderLayout());//Disposicion de esta lamina principal
		
		//creamos una segunda lamina con sus caracteriusticas
		JPanel miLayer2=new JPanel();
		miLayer2.setLayout(new FlowLayout());//disposicion de esta segunda lamina
		miLayer2.setBackground(SystemColor.window);
		
		//Creamos elementos graficos que se necesitan
		campo1=new JTextField(20);
		resultado=new JLabel("", JLabel.CENTER);
		JButton myButton=new JButton("Comprobar");
		JLabel texto1=new JLabel("Email: ");
		
		//Instancia de clase con interfaz ActionListener(oyente)
		DameTexto miEvento= new DameTexto();
		myButton.addActionListener(miEvento);//Le añadimos al boto esa capacidad de escuchar
		
		//Los añadimos al panel correspondiente
		miLayer2.add(texto1);
		miLayer2.add(campo1);
		miLayer2.add(myButton);
		
		add(miLayer2, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		
	}
	
	//********Clase interna
	//que pone de 'oyente' y realiza funcion
	private class DameTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int correcto=0;
			String email=campo1.getText().trim();
			
			for(int i=0;i<email.length();i++) {
			if(email.charAt(i)=='@') {
				correcto++;
				}
			}
			
			if (correcto!=1) {
				resultado.setForeground(Color.RED);
				resultado.setText("Incorrecto");
				System.out.println("Incorrecto");
			}else {
				resultado.setForeground(Color.GREEN);
				resultado.setText("Correcto");
				System.out.println("Correcto");
			}
		
		}
	}
	private JTextField campo1;
	private JLabel resultado;
}