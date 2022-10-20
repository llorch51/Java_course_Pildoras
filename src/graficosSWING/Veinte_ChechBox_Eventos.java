package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Veinte_ChechBox_Eventos {

	public static void main(String[] args) {
		MarcoCheck miMarcoCheck= new MarcoCheck();
		miMarcoCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

//+++++++++++++++++++++++++++++++++++++
class MarcoCheck extends JFrame{
	public MarcoCheck() {
		setTitle("Prueba CheckBox");
		setBounds(300, 300, 600, 400);
		
		
		
		add(new ChecksLayer());
		
		setVisible(true);
	}
}

//+++++++++++++++++++

class ChecksLayer extends JPanel{
	public ChecksLayer() {
		setLayout(new BorderLayout());
		
		Font miLetra=new Font("Serif", Font.PLAIN,24);
		texto=new JLabel("Puro pito para todoosodoosososos..l.");
		texto.setFont(miLetra);//parametro Objeto de tipo Font
		check1= new JCheckBox("Negrita");
		check1.setBackground(new Color(216,67,21));
		check1.setForeground(Color.WHITE);
		check1.setFont(new Font("Arial",Font.PLAIN, 30));
		check2= new JCheckBox("Cursiva");
		check2.setBackground(new Color(216,67,21));
		check2.setForeground(Color.WHITE);
		check2.setFont(new Font("Arial",Font.PLAIN, 30));
		JPanel textLayer= new JPanel();
		textLayer.setBackground(SystemColor.window);
		JPanel checksLayer= new JPanel();
		checksLayer.setBackground(new Color(33,33,33));
		
		check1.addActionListener(new ManejaChecks());
		check2.addActionListener(new ManejaChecks());
		
		textLayer.add(texto);
		checksLayer.add(check1);
		checksLayer.add(check2);
		
		add(textLayer, BorderLayout.CENTER);
		add(checksLayer, BorderLayout.SOUTH);
	}
	
	//**************Clase Interna
	private class ManejaChecks implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int tipo=0;
			
			if(check1.isSelected()==true) {
				tipo=tipo+Font.BOLD;
			}
			
			if(check2.isSelected()==true) {
				tipo=tipo+Font.ITALIC;
			}
			
			texto.setFont(new Font("Serif", tipo, 24));
			
		}
		
	}
	
	private JLabel texto;
	private JCheckBox check1, check2;
}