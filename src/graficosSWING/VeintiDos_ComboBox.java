package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VeintiDos_ComboBox {

	public static void main(String[] args) {
		Marco_ComboBox miMarco=new Marco_ComboBox();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//+++++++++++++++++++++++++++++
class Marco_ComboBox extends JFrame{
	public Marco_ComboBox() {
		setTitle("ComboBox");
		setBounds(300, 300, 600, 400);
		
		
		
		add(new Combo_Layer());
		setVisible(true);
	}
}

//+++++++++++++++++++++++++++-
 class Combo_Layer extends JPanel{
	public Combo_Layer() {
		setLayout(new BorderLayout());
		texto1=new JLabel("En algun lugar de la mancha de cuyo nombre...");
		texto1.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JPanel lamina_norte= new JPanel();
		miComboBox= new JComboBox();
		miComboBox.addItem("Serif");
		miComboBox.addItem("Courier");
		miComboBox.addItem("Dialog");
		miComboBox.addItem("Monospaced");
		
		
		miComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				texto1.setFont(new Font((String)miComboBox.getSelectedItem(), Font.PLAIN, 20));
				
			}
		});
		
		lamina_norte.add(miComboBox);
		add(lamina_norte, BorderLayout.NORTH);
		add(texto1, BorderLayout.CENTER);
	}
	
	//Clase interna para manejar evento
	private class ComboBox_Evento implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private JLabel texto1;
	private JComboBox miComboBox; 
}