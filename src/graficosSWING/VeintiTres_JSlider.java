package graficosSWING;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class VeintiTres_JSlider {

	public static void main(String[] args) {
		
		Marco_Slider miMarco = new Marco_Slider();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


//++++++++++++++++++++++++++++
class Marco_Slider extends JFrame{
	public Marco_Slider() {
		setTitle("Slider");
		setBounds(300, 300, 600, 400);
		
		
		add(new Lamina_Slider());
		setVisible(true);
	}
}

//++++++++++++++++++++++++++
class Lamina_Slider extends JPanel{
	public Lamina_Slider() {
		JSlider control = new JSlider(0,100,35);
		control.setMajorTickSpacing(25);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);
		control.setPaintLabels(true);
		//control.setSnapToTicks(true);
		add(control);
	}
}