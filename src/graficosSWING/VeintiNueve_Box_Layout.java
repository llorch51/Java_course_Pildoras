package graficosSWING;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VeintiNueve_Box_Layout {

	public static void main(String[] args) {

		Marco_box miMarco = new Marco_box();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class Marco_box extends JFrame{
	public Marco_box() {
		
		setTitle("disposicion BOX");
		setBounds(300, 300, 600, 400);
	
		JLabel rotulo1 = new JLabel("Nombre:");
		JTextField texto1 = new JTextField(10);
			texto1.setMaximumSize(texto1.getPreferredSize());
		Box cajaH1 = Box.createHorizontalBox();
			cajaH1.add(rotulo1);
			cajaH1.add(Box.createHorizontalStrut(15));
			cajaH1.add(texto1);
		JLabel rotulo2 = new JLabel("contraseña");
		JPasswordField texto2 = new JPasswordField(10);
			texto2.setMaximumSize(texto2.getPreferredSize());
			texto2.setEchoChar('+');//cambiar caracter que aparecerá en password
		Box cajaH2 = Box.createHorizontalBox();
			cajaH2.add(rotulo2);
			cajaH2.add(Box.createHorizontalStrut(10));
			cajaH2.add(texto2);
		
		JButton boton1 = new JButton("OK");
		JButton boton2 = new JButton("Cancelar");
		boton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		Box cajaH3 = Box.createHorizontalBox();
			cajaH3.add(boton1);
			cajaH3.add(Box.createGlue());
			cajaH3.add(boton2);
			
		Box cajaVertical = Box.createVerticalBox();
		cajaVertical.add(cajaH1);
		cajaVertical.add(cajaH2);
		cajaVertical.add(cajaH3);
		
		
		add(cajaVertical, BorderLayout.CENTER);
		setVisible(true);
	}
}


