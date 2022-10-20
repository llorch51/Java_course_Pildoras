package graficosSWING;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.AcceptPendingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TreintayDos_VentanaEmergente_JOptionPane {

	public static void main(String[] args) {
		MarcoDialogo miMarco = new MarcoDialogo();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoDialogo extends JFrame{
	public MarcoDialogo() {
		setTitle("JOptionPane");
		setBounds(300, 300, 600, 400);
		
		
		add(new Lamina_Dialogo());
		setVisible(true);
	}
}

class Lamina_Dialogo extends JPanel{
	public Lamina_Dialogo() {
		
		boton1 = new JButton("Boton 1");
		boton2 = new JButton("Boton 2");
		boton3 = new JButton("Boton 3");
		boton4 = new JButton("Boton 4");
		
		boton1.addActionListener(new Accion_Botones());
		boton2.addActionListener(new Accion_Botones());
		boton3.addActionListener(new Accion_Botones());
		boton4.addActionListener(new Accion_Botones());
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		
	}
	
	//clase interna para eventos
	private class Accion_Botones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == boton1) {
				//System.out.println("");
				//JOptionPane.showMessageDialog(Lamina_Dialogo.this, "Botón 1");
				JOptionPane.showMessageDialog(Lamina_Dialogo.this, "Mensaje Prueba", "titulo de Ventana", 1);
			}else if (e.getSource() == boton2) {
				JOptionPane.showInputDialog(Lamina_Dialogo.this, "Introduce Nombre", "titulo de Ventana", 2);
			}else if (e.getSource() == boton3) {
				JOptionPane.showConfirmDialog(Lamina_Dialogo.this, "elije opción", "Barra de titulo", 1);
			}else if (e.getSource() == boton4) {
				JOptionPane.showOptionDialog(Lamina_Dialogo.this, "Elige", "Titulo en Ventana", 1, 1, null, null, null);
			}
			
		}
		
	}
	
	JButton boton1, boton2, boton3, boton4;
}