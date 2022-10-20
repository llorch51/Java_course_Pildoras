package graficosSWING;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DiezyNueve2_TextAreas_Eventos {

	public static void main(String[] args) {
		Marco_Prueba2 miMarco=new Marco_Prueba2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//++++++++++++++++++++++++++++++
//************************SE HARÁ TODO EN UNA SOLA CLASE
class Marco_Prueba2 extends JFrame{
	public Marco_Prueba2() {
		setTitle("Area de Texto");
		setBounds(300, 300, 600, 400);
		
		ButtonsLayer=new JPanel();
		botonInsertar=new JButton("Insertar");
		botonSaltoLinea= new JButton("Salto Linea");
		areaTexto= new JTextArea(8,20);
		barraScrollPane= new JScrollPane(areaTexto);
		
		botonInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				areaTexto.append("Puro pito para todos, puttoooss!!");
				
			}
		});
		botonSaltoLinea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean saltaLinea= !areaTexto.getLineWrap();//lo contrario que regrese getLineWrap(booleano)
				areaTexto.setLineWrap(saltaLinea);
				/*
				if (saltaLinea==true) {
					botonSaltoLinea.setText("QUITAR Salto Linea");
				}else {
					botonSaltoLinea.setText("Salto Linea");
				}
				*/
				//					(condicion ?(separador)	QuéHacerSiTRUE : QuéHacerSiFALSE)
				botonSaltoLinea.setText(saltaLinea==true ? "Quitar Salto" : "Salto Linea");
			}
		});
		
		
		ButtonsLayer.add(botonSaltoLinea);
		ButtonsLayer.add(botonInsertar);
		add(barraScrollPane, BorderLayout.CENTER);
		add(ButtonsLayer, BorderLayout.SOUTH);
		setVisible(true);
	}
	private JPanel ButtonsLayer;
	private JButton botonInsertar, botonSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane barraScrollPane;
}