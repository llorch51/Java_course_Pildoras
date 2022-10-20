package graficosSWING;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Catorce_OyentesMultiples {

	public static void main(String[] args) {
		MarcoPrincipal miMarco= new MarcoPrincipal();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}
//++++++++++++++++++++++++++++++
//la primera ventana que se ejecuta
//mandará llamar clase lámina que contruirá los elementos
class MarcoPrincipal extends JFrame{
	
	//constructor del marco
	public MarcoPrincipal() {
		setTitle("Prueba Varios Oyentes");
		setBounds(200, 200, 300, 200);
		
		LaminaPrincipal lamina=new LaminaPrincipal();
		add(lamina);
	}
	
	
}

//+++++++++++++++++++++++++++++++++++
//contruye los elemtos boton y sus acciones
class LaminaPrincipal extends JPanel{
	//constructor
	public LaminaPrincipal() {
		JButton botonNuevo=new JButton("Nuevo");//objeto fuente de evento
		add(botonNuevo);
		botonCerrar=new JButton("Cerrar todo alv");
		add(botonCerrar);
		
		OyenteAbre miOyenteAbre=new OyenteAbre();//instancia a la escucha de evento/que algo pase 
		botonNuevo.addActionListener(miOyenteAbre);//objeto fuente(instancia que escucha por evento)
	}
	//CLASE INTERNA OYENTE para abrir las demas ventanas
	private class OyenteAbre implements ActionListener{

		@Override
		/*En cada ventana nueva q se crea le añadimos, por parametro,
		 * el objeto que escuchará cuando se invoque "cerrar todo alv" por el botonCerrar*/
		public void actionPerformed(ActionEvent e) {
			Marco_Emergente marco_Emergente= new Marco_Emergente(botonCerrar);//instancia de Marco_emergente
			marco_Emergente.setVisible(true);
			
		}
		
	}
	JButton botonCerrar;//se usará fuera del constructor
}

//+++++++++++++++++++++++++
 class Marco_Emergente extends JFrame{
	//constructor
	public Marco_Emergente(JButton boton_cierre_principal) {/*pasar por parametro el boton
	 														del marco principal porque
	 														será el desencadenante de la accion
	 														de cerrar todo alv*/
		contador++;
		setTitle("Ventana "+ contador);
		setBounds(40*contador, 40*contador, 300, 200);
		
		OyenteCierra oyenteCerrar= new OyenteCierra();/*instancia de clase OyenteCierra
													con metodo que cierra todo*/
		boton_cierre_principal.addActionListener(oyenteCerrar);/*objeto fuente de evento(instancia de clase que cierra ventana)
		 								*/
		
	}
	
	//CLASE INTERNA oyente de Marco_Emergente
	private class OyenteCierra implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();//cierra todo
			
		}
		
	}
	private static int contador=0; //Estatica para que sea compartida por todas las instancias q creamos
									// y no que cada una tenga una copia
}