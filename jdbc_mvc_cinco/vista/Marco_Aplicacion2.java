package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.Evento_Boton_Consulta;
import controlador.Evento_CargaInfo;

public class Marco_Aplicacion2 extends JFrame{

	public Marco_Aplicacion2() {
		
		setTitle("Consulta JDBC MVC");
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JButton btnConsulta = new JButton("Consulta");
			btnConsulta.addActionListener(new Evento_Boton_Consulta(this));
			
		JPanel menus = new JPanel();
			menus.setLayout(new FlowLayout());
			
			secciones=new JComboBox();
			secciones.setEditable(false);
			secciones.addItem("Todos");
			
			paises = new JComboBox();
			paises.setEditable(false);
			paises.addItem("Todos");
			
			resultado = new JTextArea(4,50);
			resultado.setEditable(false);
			
			menus.add(secciones);
			menus.add(paises);
			
		
		add(menus, BorderLayout.NORTH);
		//add(resultado);	
		add(resultado, BorderLayout.CENTER);
		add(btnConsulta, BorderLayout.SOUTH);
		
		setVisible(true);
		
		addWindowListener(new Evento_CargaInfo(this));//Poner a la escucha a la ventana
												//con una instancia de 'Evento_' que trae por herencia
												//el 'windowOpened'
	
	}
	
	public JComboBox secciones;
	public JComboBox paises;
	public JTextArea resultado;
}
