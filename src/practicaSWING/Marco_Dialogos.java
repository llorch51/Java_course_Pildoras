package practicaSWING;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Marco_Dialogos extends JFrame{
	
	public Marco_Dialogos() {
		setTitle("Prueba de Diálogos");
		setBounds(300, 300, 600, 400);
		setLayout(new BorderLayout());
		
		JPanel lamina_cuadricula = new JPanel();
			lamina_cuadricula.setLayout(new GridLayout(2, 3));//(filas, columnas)
			
			
		String[] primeraCaja = {"Mensaje", "Confirmar", "Opción", "entrada"};
		tipo =new Lamina_Botones("Tipo", primeraCaja);
		lamina_tipo_mensajes = new Lamina_Botones("tipo Mensaje", new String[] {
			"ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"
		});
		lamina_mensaje = new Lamina_Botones("Mensaje", new String[] {
			"Cadena", "Icono", "Componente", "Otros", "Object[]"	
		});
		lamina_tipo_opcion = new Lamina_Botones("Confirmar", new String[] {
				"DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTTION"
		});
		lamina_opciones = new Lamina_Botones("Opcion", new String[] {
				"String[]", "Icon[]", "Object[]"
		});
		lamina_entrada = new Lamina_Botones("Entrada", new String[] {
				"Campo de texto", "Combo"
		});
		lamina_cuadricula.add(tipo);
		lamina_cuadricula.add(lamina_tipo_mensajes);
		lamina_cuadricula.add(lamina_mensaje);
		lamina_cuadricula.add(lamina_tipo_opcion);
		lamina_cuadricula.add(lamina_opciones);
		lamina_cuadricula.add(lamina_entrada);
		
		//Lamina inferior
		JPanel lamina_mostrar = new JPanel();
		JButton boton_mostrar = new JButton("Mostrar");
			boton_mostrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(tipo.dameSeleccion());
					
					if (tipo.dameSeleccion().equalsIgnoreCase("Mensaje")) {
						JOptionPane.showMessageDialog(Marco_Dialogos.this, dameMensaje(), "Titulo de Ventana", dameIconoYbotones(lamina_tipo_mensajes));
					}else if (tipo.dameSeleccion().equalsIgnoreCase("Confirmar")) {
						JOptionPane.showConfirmDialog(Marco_Dialogos.this, dameMensaje(), "Titulo de Ventana", dameIconoYbotones(lamina_tipo_opcion), dameIconoYbotones(lamina_tipo_mensajes));
					}else if (tipo.dameSeleccion().equalsIgnoreCase("Entrada")) {
						
						if (lamina_entrada.dameSeleccion().equalsIgnoreCase("campo de texto")) {
							JOptionPane.showInputDialog(Marco_Dialogos.this, dameMensaje(), "Titulo Ventana", dameIconoYbotones(lamina_tipo_mensajes));
						}else {
							JOptionPane.showInputDialog(Marco_Dialogos.this, dameMensaje(), "Pinche titulo", dameIconoYbotones(lamina_tipo_mensajes), iconoMensaje, new String[] {"Amarillo", "Azul", "Rojo"}, "Azul");
						}
					}else if (tipo.dameSeleccion().equalsIgnoreCase("Opción")) {
						JOptionPane.showOptionDialog(Marco_Dialogos.this, dameMensaje(), "titulo Ventana", 1, dameIconoYbotones(lamina_tipo_mensajes), null, dameOpciones(lamina_opciones), null);
					}
				}
			});
		
		lamina_mostrar.add(boton_mostrar);
		
		add(lamina_cuadricula, BorderLayout.CENTER);
		add(lamina_mostrar, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	//Metodo para regresar el mensaje de cada opcion
	public Object dameMensaje() {
		String opcion_Seleccionada = lamina_mensaje.dameSeleccion();//guardamos en variable el string del nombre del radioButton seleccionado
		
		if (opcion_Seleccionada.equalsIgnoreCase("Cadena")) {
			return cadenaMensaje;
		}else if (opcion_Seleccionada.equalsIgnoreCase("Icono")) {
			return iconoMensaje;
		}else if (opcion_Seleccionada.equalsIgnoreCase("Componente")) {
			return componenteMensaje;
		}else if (opcion_Seleccionada.equalsIgnoreCase("Otros")) {
			return objetoMensaje;
		}else if (opcion_Seleccionada.equalsIgnoreCase("Object[]")) {
			return new Object[] {
					cadenaMensaje,
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
			};
		}
		return "";
	}
	
	//Metodo para regrear el tipo de icono y tipo de botones en  ventana que será
	//misma logica que el anterior
	public int dameIconoYbotones(Lamina_Botones lamina) {
		
		String opcion_Seleccionada = lamina.dameSeleccion();
		if (opcion_Seleccionada.equalsIgnoreCase("ERROR_MESSAGE") || opcion_Seleccionada.equalsIgnoreCase("yes_no_option")) {
			return 0;
		}else if (opcion_Seleccionada.equalsIgnoreCase("information_message") || opcion_Seleccionada.equalsIgnoreCase("yes_no_cancel_option")) {
			return 1;
		}else if (opcion_Seleccionada.equalsIgnoreCase("warning_message") || opcion_Seleccionada.equalsIgnoreCase("ok_cancel_option")) {
			return 2;
		}else if (opcion_Seleccionada.equalsIgnoreCase("question_message")) {
			return 3;
		}else if (opcion_Seleccionada.equalsIgnoreCase("plain_message") || opcion_Seleccionada.equalsIgnoreCase("default_option")) {
			return -1;
		}
		return 0;
	}
	
	//Metodo para opciones de botones en ventana emergente
	public Object[] dameOpciones(Lamina_Botones lamina) {
		
		String opcion_seleccionada = lamina.dameSeleccion();
		
		if (opcion_seleccionada.equalsIgnoreCase("String[]")) {
			return new String[] {"amarillo", "azul", "rojo"};
		}else if (opcion_seleccionada.equalsIgnoreCase("Icon[]")) {
			return new Object[] {new ImageIcon("src/icon/bold.png"), 
					new ImageIcon("src/icon/italic.png"), 
					new ImageIcon("src/icon/under.png")};
		}else if (opcion_seleccionada.equalsIgnoreCase("Object[]")) {
			return new Object[] {
					cadenaMensaje,
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
			};
		}
		
		
		
		return null;
	}
	
	//Propiedades
	private Lamina_Botones tipo, lamina_tipo_mensajes, lamina_mensaje, lamina_tipo_opcion, 
							lamina_opciones, lamina_entrada;
	private String cadenaMensaje = "Puto Mensaje";
	private Icon iconoMensaje = new ImageIcon("src/icon/bold.png");
	private Object objetoMensaje = new Date();
	private Component componenteMensaje = new Lamina_ejemplo_color();
}


class Lamina_ejemplo_color extends JPanel{
	public Lamina_ejemplo_color() {
		
	}
	
	public void paintComponent(Graphics g) {//dibujar la figura
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D) g;
		Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		g2.setPaint(Color.YELLOW);
		g2.fill(rectangulo);
	}
}
