package graficosSWING;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DiezySeis_Layouts_Calculadora {

	public static void main(String[] args) {
		
		Marco_Calculadora miMarco=new Marco_Calculadora();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
		

	}

}
//+++++++++++++++++++++++++++++++++
//ventana
class Marco_Calculadora extends JFrame{
	public Marco_Calculadora() {
		setTitle("Calculadora");
		setBounds(400, 400, 600, 400);
		
		Lamina_Calculadora lamina_display=new Lamina_Calculadora();
		add(lamina_display);
		
	}
}
//++++++++++++++++++++++++++++++
//layers
class Lamina_Calculadora extends JPanel{
	//constructor
	public Lamina_Calculadora() {
		principio=true;
		setLayout(new BorderLayout());//Layout de la lamina1 en general
		pantallaButton=new JButton("0");//
		pantallaButton.setBackground(new Color(33,33,33));
		pantallaButton.setForeground(Color.WHITE);
		pantallaButton.setFont(new Font("Arial",Font.PLAIN, 30));
		pantallaButton.setEnabled(false);
		add(pantallaButton,BorderLayout.NORTH);//boton en la parte norte del layout general
		
		miLamina2= new JPanel();
		miLamina2.setLayout(new GridLayout(4,4));//Layout interno de la lamina2 que estoy creando
		
		ActionListener insertar=new InsertaNumero();//objeto de tipo ActionListener
												//creado con clase que implementa interfaz ActionListener
		ActionListener operacion=new OperacionMath();
		
		crearBoton("7", new InsertaNumero());//insertar
		crearBoton("8", new InsertaNumero());
		crearBoton("9", new InsertaNumero());
		crearBoton("/", new OperacionMath());//operacion
		crearBoton("4", new InsertaNumero());
		crearBoton("5", new InsertaNumero());
		crearBoton("6", new InsertaNumero());
		crearBoton("*", new OperacionMath());
		crearBoton("1", new InsertaNumero());
		crearBoton("2", new InsertaNumero());
		crearBoton("3", new InsertaNumero());
		crearBoton("-", new OperacionMath());
		crearBoton("0", new InsertaNumero());
		crearBoton(".", new InsertaNumero());
		crearBoton("=", new OperacionMath());
		crearBoton("+", new OperacionMath());
		
		add(miLamina2, BorderLayout.CENTER);//posicion de la lamina2 sobre la lamina1(la general)
		ultimaOperacion="=";
	}
	
	
	//metodo para crear botones y ponerlos a la escucha
	//					(Nombre del boton, objeto de tipo ActionListener)
	private void crearBoton(String nombre, ActionListener oyente) {
		JButton boton=new JButton(nombre);//se crea el boton
		boton.setBackground(new Color(232,17,35));
		boton.setForeground(Color.WHITE);
		boton.setFont(new Font("Arial",Font.PLAIN, 30));
		boton.addActionListener(oyente);//añade la capacidad de oir al boton
		miLamina2.add(boton);//se añade a la lamina
	}
	
	
	//********Clase interna encargada de gestionar los eventos en botones numericos
	private class InsertaNumero implements ActionListener{//interfaz
		@Override
		public void actionPerformed(ActionEvent e) {//metodo que gestiona los eventos
			
			String entrada = e.getActionCommand();//captura texto del boton pulsado
			if(principio==true) {
				pantallaButton.setText("");
				principio=false;
			}
			pantallaButton.setText(pantallaButton.getText() + entrada);//
		}
		
	}
	//******Otra clase interna que gestione los eventos de las operaciones matematicas en botones
	private class OperacionMath implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String operacion=e.getActionCommand();//almacenar String q es el texto del boton
			calcular(Double.parseDouble(pantallaButton.getText()));
			ultimaOperacion=operacion;
			principio=true;
			
		}
		//método para hacer las operaciones
		public void calcular(double x) {
			if(ultimaOperacion.equals("+")) {
				resultado= resultado + x;
			}
			else if(ultimaOperacion.equals("-")) {
				resultado=resultado-x;
			}
			else if (ultimaOperacion.equals("*")) {
				resultado=resultado*x;
			}
			else if (ultimaOperacion.equals("/")) {
				resultado=resultado/x;
			}
			else if(ultimaOperacion.equals("=")) {
				resultado=x;
			}
			
			pantallaButton.setText(Double.toString(resultado));
		}
		
	}
	
	//propiedades
	private JPanel miLamina2;
	private JButton pantallaButton;
	private boolean principio;//valor por defecto es FALSE
	private double resultado;
	private String ultimaOperacion;
}