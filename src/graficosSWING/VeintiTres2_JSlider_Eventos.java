package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VeintiTres2_JSlider_Eventos {

	public static void main(String[] args) {
		Marco_Slider2 miMarco = new Marco_Slider2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//+++++++++++++++++++++++
class Marco_Slider2 extends JFrame{
	public Marco_Slider2() {
		setTitle("SliderEventos");
		setBounds(300, 300, 600, 400);
		
		
		add(new Slider_Layer2());
		setVisible(true);
	}
}

//+++++++++++++++++++++++++++++++++++
class Slider_Layer2 extends JPanel{
	public Slider_Layer2() {
		setLayout(new BorderLayout());
		
		texto1 = new JLabel("En algun lugar de la amncha de cuyo nombre...");
		control1 = new JSlider(8,50,12);//lo que serán tamaños de letra (min, max, comienzo)
		control1.setMajorTickSpacing(20);
		control1.setMinorTickSpacing(5);
		control1.setPaintTicks(true);
		control1.setPaintLabels(true);
		control1.setFont(new Font("Serif", Font.ITALIC, 18));
		
		JPanel nueva_lamina = new JPanel();
		nueva_lamina.add(control1);
		
		control1.addChangeListener(new EventoSlider());
		
		add(nueva_lamina, BorderLayout.NORTH);
		add(texto1, BorderLayout.CENTER);
	}
	
	//*****Clase interna para gestion de ventos
	private class EventoSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			texto1.setFont(new Font("Serif", Font.PLAIN, control1.getValue()));
			
		}
		
	}
	
	private JLabel texto1;
	private JSlider control1;
}