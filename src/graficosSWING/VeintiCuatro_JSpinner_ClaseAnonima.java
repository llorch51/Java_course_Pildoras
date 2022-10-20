package graficosSWING;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class VeintiCuatro_JSpinner_ClaseAnonima {

	public static void main(String[] args) {
		Marco_Spinner miMarco = new Marco_Spinner();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Marco_Spinner extends JFrame{
	public Marco_Spinner() {
		setTitle("JSpinner");
		setBounds(300, 300, 600, 400);
		
		
		add(new Spinner_Layer());
		setVisible(true);
	}
}

class Spinner_Layer extends JPanel{
	public Spinner_Layer() {
		//String[] listaStrings = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		Dimension dimension = new Dimension(200, 20);
		
		//Clase Interma ANONIMA
		//código dentro del constructor de SpinnerNumberModel, NO como parámetro
		JSpinner control = new JSpinner(new SpinnerNumberModel(5,0,10,1) {
			
			public Object getNextValue() {
				return super.getPreviousValue();
			}
			
			public Object getPreviousValue() {
				return super.getNextValue();
			}
			
	
		});
		//JSpinner control = new JSpinner(new MiModeloSpinner());//Ponerlo al revez
		control.setPreferredSize(dimension);
		
		
		add(control);
	}
	
	//******Clase Internaaa para modificar aumento/decremento en numeracion de JSpinnner
	/*
	private class MiModeloSpinner extends SpinnerNumberModel{
		public MiModeloSpinner(){
			super(5,0,10,1);//llamada a constructor de clase padre heredada SpinnerNumberModel()
			
		}
		
		//sobreescribimos los metodos para decirle que nos regresen lo contrario
		public Object getNextValue() {
			return super.getPreviousValue();
		}
		
		public Object getPreviousValue() {
			return super.getNextValue();
		}
	}*/
}