package graficosSWING;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class DiezyOcho_CuadrosTexto_Eventos {

	public static void main(String[] args) {
		MarcoPrueba miMarcoPrueba=new MarcoPrueba();
		miMarcoPrueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//+++++++++++++++++++++++++++

class MarcoPrueba extends JFrame{
	public MarcoPrueba() {
		setBounds(400, 300, 600, 400);
		
		
		add(new LaminaPrueba());
		
		setVisible(true);
	}
}

//++++++++++++++++++++++++++++++--

class LaminaPrueba extends JPanel{
	public LaminaPrueba() {
		
		JTextField miCampo1=new JTextField(25);
		Document miDoc=miCampo1.getDocument();//instancia de tipo Document
										//inicializada con objeto que implementa metodo
										// que devuelve objeto tipo Document
		
		EscuchaTexto textoListener=new EscuchaTexto();//instancia de clase que escucha
		miDoc.addDocumentListener(textoListener);//objeto tipo Document que podrá escuchar
		
		add(miCampo1);
	}
	
	//******Clase interna que manejará los eventos porque implementa DocumentListener
	private class EscuchaTexto implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			System.out.println("Has insertado texto");
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			System.out.println("Has borrado tessstttooo");
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}