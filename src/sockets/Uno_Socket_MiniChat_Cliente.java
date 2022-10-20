package sockets;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Uno_Socket_MiniChat_Cliente {

	public static void main(String[] args) {
		
		MarcoCliente miMarco = new MarcoCliente();
			miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//*****************************************************
class MarcoCliente extends JFrame{
	public MarcoCliente() {
		setTitle("--Chat--");
		setBounds(300, 300, 275, 350);
		
		
		
		add(new LaminaCliente());
		setVisible(true);
		
		addWindowListener(new EventoOnline());//Mandará notificacion Online
	}
}
//***********************************************
class EventoOnline extends WindowAdapter{//Clase adaptadora-implementa todos los metodos de alguna interfaz, así solo
										//utilizamos los que necesitamos y NO TODOS los de la interfaz
	
	@Override
	public void windowOpened(WindowEvent e) {
		
		try {
			//*************Mandar notificacion de estar Online
			Socket miSocket = new Socket("192.168.0.20", 5000);
			PaqueteEnvio online = new PaqueteEnvio();
				online.setMensaje("online");
			ObjectOutputStream objOnline = new ObjectOutputStream(miSocket.getOutputStream());
				objOnline.writeObject(online);
				
				miSocket.close();
				
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
}

//******************************************************
class LaminaCliente extends JPanel implements Runnable{
	//constructor
	public LaminaCliente() {
		
		String nick_usuario= JOptionPane.showInputDialog("Nick: ");//Pedir nick al inicio
		
		JLabel texto = new JLabel("Online: ");
		JLabel n_nick= new JLabel("Nick: ");
			nick= new JLabel();
			nick.setText(nick_usuario);
			ipDestino= new JComboBox();
				//ipDestino.addItem("192.168.0.13");
				//ipDestino.addItem("192.168.0.14");
				//ipDestino.addItem("Usuario3");
			campo1= new JTextField(20);
			campoChat= new JTextArea(12, 20);
			miBoton= new JButton("Enviar");
			miBoton.addActionListener(new ActionListener() {//Poner a la escucha
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//System.out.println(campo1.getText());
					
					campoChat.append("\n Yo"+nick.getText()+ ":\t" + campo1.getText());
					
					try {
						Socket miSocket = new Socket("192.168.0.20", 5000 );//(IP servidor, puerto)
						PaqueteEnvio datos = new PaqueteEnvio();
							datos.setNick(nick.getText());//obtener el texto del JLabel 'nick'
							datos.setIp(ipDestino.getSelectedItem().toString());//Devuelve Objeto y hay que cambiarlo a String
							datos.setMensaje(campo1.getText());
							
						ObjectOutputStream paquete_datos = new ObjectOutputStream(miSocket.getOutputStream());
							paquete_datos.writeObject(datos);//El objeto de la clase que construimos para empaquetar
							
							miSocket.close();
						
						//DataOutputStream flujo_salida = new DataOutputStream(miSocket.getOutputStream());
							//flujo_salida.writeUTF(campo1.getText());
							//flujo_salida.close();
							
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println(e1.getMessage());
					}
					
				}
			});
			
		add(n_nick);
		add(nick);
		add(texto);
		add(ipDestino);
		add(campoChat);
		add(campo1);
		add(miBoton);
		
		
		Thread miHilo = new Thread(this);
			miHilo.start();
	}
	
	@Override
	public void run() {
		//***Para hacer las veces de Servidor tambien
		try {
			
			ServerSocket servidor_cliente = new ServerSocket(5000);
			//Socket cliente;
			PaqueteEnvio paquete_recibido;
			
			while(true) {
				Socket cliente = servidor_cliente.accept();
				ObjectInputStream paquete_datos = new ObjectInputStream(cliente.getInputStream());
					paquete_recibido=(PaqueteEnvio) paquete_datos.readObject();
				
				//qué mosttrar en campoChat
				if(!paquete_recibido.getMensaje().equals("online")) {//si NO has recibido el mensaje 'online'
					campoChat.append("\n"+paquete_recibido.getNick()+": \""+paquete_recibido.getMensaje());//muestra nick y mensaje
				}else {//si sí has recibido el mensaje 'online'
					
					//campoChat.append("\n" + paquete_recibido.getDireccionesIP());//muestra array de IPs
					
					ArrayList<String> ipComboBox = new ArrayList<>();
						ipComboBox=paquete_recibido.getDireccionesIP();//arrayList dond se guardarán las ip que traemos en paquete
					
					ipDestino.removeAllItems();//Elimina items existentes para evitar duplicidad de IPs
					for (String string : ipComboBox) {
						ipDestino.addItem(string);//agregamos al ComboBox cada elemento que recorremos del arrayList que trae las IPs
					}
				}
					
					
			}
			
		} catch (Exception e) {
			System.out.println("Valió pito la conexion");
		}
		
	}
	
	private JTextField campo1;
	private JComboBox ipDestino;
	private JLabel nick;
	private JTextArea campoChat;
	private JButton miBoton;
	
}

//**********************************************
//Clase en la que empaquetaremos nick, ip del cliente a mensajear y el mensaje en si.
//Se mandará objeto con esas tres propiedades. En vez de mandarlas por separado
class PaqueteEnvio implements Serializable{//Serializar la clase para poder mandar los objetos por la red
	
	
	public String getNick() {
		return nick;
	}

	public String getIp() {
		return ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public ArrayList<String> getDireccionesIP() {
		return DireccionesIP;
	}

	public void setDireccionesIP(ArrayList<String> direccionesIP) {
		DireccionesIP = direccionesIP;
	}

	//Propiedades
	private String nick, ip, mensaje;
	private ArrayList<String> DireccionesIP;
}