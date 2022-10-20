package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicBorders;

public class DiezyOcho2_CuadrosTexto_Password {

	public static void main(String[] args) {
		
		MarcoPassword miMarcoPassword= new MarcoPassword();
		miMarcoPassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}

}

//++++++++++++++++++++++++++++++++++

class MarcoPassword extends JFrame{
	public MarcoPassword() {
		setTitle("Password");
		setBounds(300, 300, 600, 400);
		
		add(new PasswordLayer());
		setVisible(true);
	}
}

//++++++++++++++++++++++++++++++++++++

class PasswordLayer extends JPanel{
	public PasswordLayer() {
		//Definir disposicion por defecto y caracteristicas de la capa
		setLayout(new BorderLayout());
		setBackground(SystemColor.window);
		
		//Construir elementos graficos y sus caracteristicas
		JPanel lamina_superior= new JPanel();
		lamina_superior.setLayout(new GridLayout(2,2));
		lamina_superior.setBackground(SystemColor.window);
		JLabel etiqueta1= new JLabel("Usuario: ");
		JLabel etiqueta2= new JLabel("Contraseña: ");
		JTextField c_usuario= new JTextField(15);
		c_contrasena= new JPasswordField(15);
		c_contrasena.setEchoChar('Ψ');
		JButton enviar= new JButton("Enviar");
		enviar.setBackground(new Color(232,17,35));
		enviar.setForeground(Color.WHITE);
		enviar.setFont(new Font("Arial",Font.PLAIN, 30));
		enviar.setPreferredSize(new Dimension(20,100));//(largoX,anchoY)
		
		//Poner a la escucha a los elementos deseados
		c_contrasena.getDocument().addDocumentListener(new CompruebaPass());
		
		//añadir los elementos a la capa respectiva
		lamina_superior.add(etiqueta1);
		lamina_superior.add(c_usuario);
		lamina_superior.add(etiqueta2);
		lamina_superior.add(c_contrasena);
		
		add(lamina_superior, BorderLayout.NORTH);
		add(enviar, BorderLayout.SOUTH);
		
	}
	
	//clase interna para gestionar los eventos
	private class CompruebaPass implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {//cada que se inserta un caracter
			char[] password;
			password=c_contrasena.getPassword();
			BasicBorders.FieldBorder bordeColor = new BasicBorders.FieldBorder(Color.red, Color.red, Color.red, Color.red);
			BasicBorders.FieldBorder bordeColor2 = new BasicBorders.FieldBorder(Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);
			
			if(password.length<8 || password.length>12) {
				c_contrasena.setBorder(bordeColor);
				//c_contrasena.setBackground(Color.RED);
			}else {
				c_contrasena.setBorder(bordeColor2);
				//c_contrasena.setBackground(Color.WHITE);
			}
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {//Cada que se borra un caracter
			char[] password;
			BasicBorders.FieldBorder bordeColor = new BasicBorders.FieldBorder(Color.red, Color.red, Color.red, Color.red);
			password=c_contrasena.getPassword();
			BasicBorders.FieldBorder bordeColor2 = new BasicBorders.FieldBorder(Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);
			
			if(password.length<8 || password.length>12) {
				c_contrasena.setBorder(bordeColor);
				//c_contrasena.setBackground(Color.RED);
			}else {
				c_contrasena.setBorder(bordeColor2);
				//c_contrasena.setBackground(Color.WHITE);
			}
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private JPasswordField c_contrasena;
}