package sockets;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Uno2_Socket_Minichat_Servidor {

	public static void main(String[] args) {
		MarcoServidor miServidor = new MarcoServidor();
			miServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//***************
class MarcoServidor extends JFrame implements Runnable{
	public MarcoServidor() {
		setBounds(600, 300, 400, 300);
		JPanel miLamina = new JPanel();
			miLamina.setLayout(new BorderLayout());
			areaTexto= new JTextArea();
			
			miLamina.add(areaTexto, BorderLayout.CENTER);
			
		Thread miHilo = new Thread(this);//'this' porque es esta misma instancia de MarcoServidor la que implementa Runnable
			miHilo.start();
		
		add(miLamina);
		setVisible(true);
	}
	
	@Override
	public void run() {
		System.out.println("putiiinn");
		
		try {
			ServerSocket miServidor = new ServerSocket(5000);//(puerto de comunicacion que pusimos en Cliente)
			String recibe_nick, recibe_ip, recibe_mensaje;//Aqui guardamos las  mismas propiedades que recibiremos en el paquete
			PaqueteEnvio paquete_recibido;//aqui guardaremos el paquete, de la misma clase, que se recibe
			
			ArrayList<String> listaIP = new ArrayList<>();//para guardar las ips que se vayan conectando
			
			while(true) {
				Socket miSocket = miServidor.accept();//que acepte las conexiones
				
				
				//****Instancias para ser receptor del paquete que llega
				ObjectInputStream paquete_datos = new ObjectInputStream(miSocket.getInputStream());//Objeto Stream que se recibe
					paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();//casteamos el objeto recien recibido
																			//para guardarlo en instancia de 'PaqueteEnvio'
					//Sacar los campos de 'paquete_recibido'
					recibe_nick=paquete_recibido.getNick();//sacar el nick
					recibe_ip=paquete_recibido.getIp();
					recibe_mensaje=paquete_recibido.getMensaje();
					
				if (!recibe_mensaje.equals("online")) {
					
				
					//Mostrar los campos en areatexto
					areaTexto.append("\n"+recibe_nick+": \""+recibe_mensaje+"\".\t\tPara: "+recibe_ip);
					
				//****Además de ser receptor, tambien tiene que ser emisor, hay que instanciar socket que mande
				Socket enviaDestinatario = new Socket(recibe_ip, 5000);//(IP destino, puerto)
				ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());//Objeto Stream para enviar
					paqueteReenvio.writeObject(paquete_recibido);//escribe dentro del objeto stream (lo que está en 'paquete_recibido')
				
					
				//**********Cerrar conexiones
					enviaDestinatario.close();
					paqueteReenvio.close();
					miSocket.close();
					
				}else {
					//*****Detectar usuarios online
					InetAddress online = miSocket.getInetAddress();
					String ip_remota = online.getHostAddress();
					System.out.println(ip_remota);
					
						listaIP.add(ip_remota);//añadir al arrayList las ip que se van conectando
					
						paquete_recibido.setDireccionesIP(listaIP);//Añadimos el array de listaIP, ala propiedad 'DireccionesIP' del paquete q enviamos
					
					for (String string : listaIP) {//Para ir mostrando las ip del arrayList
						System.out.println("ArrayList: "+string);
						
						//Abrirá socket, para mandar el arrayList de ip a cada vuelta de bucle
						Socket enviaIP = new Socket(string, 5000);//(ip del elemento en turno, 5000)
						ObjectOutputStream paqueteEnvioIP = new ObjectOutputStream(enviaIP.getOutputStream());
							paqueteEnvioIP.writeObject(paquete_recibido);
							
							paqueteEnvioIP.close();
							enviaIP.close();
							miSocket.close();
					}
				}
			}
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private JTextArea areaTexto;
}