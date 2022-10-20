package threads;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Uno_UsoThreads {

	public static void main(String[] args) {
		
		MarcoRebote miMarco = new MarcoRebote();
			miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			miMarco.setVisible(true);
	}

}

//**********************************************

class PelotaHilos implements Runnable{
	
	public PelotaHilos(Pelota unaPelota, Component unComponente) {
		pelota= unaPelota;
		componente = unComponente;
	}

	@Override
	public void run() {
		
//		for (int i = 1; i < 3000; i++) {
//			pelota.mueve_pelota(componente.getBounds());
//			//componente.paint(componente.getGraphics());
//			componente.repaint();
//			
//			try {
//				Thread.sleep(2);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
		System.out.println(Thread.currentThread().isInterrupted());
		
		while(!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());
			componente.repaint();
			
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.currentThread().isInterrupted();
			}
		}
		
		Thread.currentThread().isInterrupted();
	}
	
	private Pelota pelota;
	private Component componente;
}


//********************************************

class Pelota{
	
	 public void mueve_pelota(Rectangle2D limites) {//define los limites de la lamina en donde va a rebotar la pelota
		x+=dx;
		y+=dy;
		
		if (x<limites.getMinX()) {
			x=limites.getMinX();
			dx=-dx;
		}
		
		if (x + TAMX >= limites.getMaxX()) {
			x=limites.getMaxX()- TAMX;
			dx=-dx;
		}
		
		if (y<limites.getMinY()) {
			y=limites.getMinY();
			dy=-dy;
		}
		
		if (y + TAMY >= limites.getMaxY()) {
			y=limites.getMaxY()- TAMY;
			dy=-dy;
		}
		
	}
	 
	 public Ellipse2D getShape() {//contruye la bolita
		 return new Ellipse2D.Double(x,y,TAMX,TAMY);
	 }
	 
	 private static final int TAMX = 15;
	 private static final int TAMY = 15;
	 private double x = 0;
	 private double y = 0;
	 private double dx = 1;
	 private double dy = 1;
}

//*****************************************************************

class LaminaPelota extends JPanel{//lamina donde se muestra la pelota
	
	public void add(Pelota b) {
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g) {//se dibuja
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Pelota b: pelotas) {
			g2.fill(b.getShape());
			revalidate();
		}
	}
	
	private ArrayList<Pelota> pelotas = new ArrayList<>();//se guardan las diferentes instancias de pelota
}

//***************************************************************

class MarcoRebote extends JFrame{//marco donde se situará la lamina donde se dibuja la pelota y los botones necesarios
	
	public MarcoRebote() {
		setBounds(300, 300, 600, 400);
		setTitle("Rebotes");
		
		lamina = new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones = new JPanel();
		ponerBoton(laminaBotones, "Dale!", new ActionListener() {//botones con su escucha a la accion
			
			@Override
			public void actionPerformed(ActionEvent e) {

				comienza_el_juego();//llamada a funcion
			}
		});
		
		ponerBoton(laminaBotones, "Salir", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		ponerBoton(laminaBotones, "Detener", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				detener();
				
			}
		});
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	//+++++++++++++++++++++++++++++++++++funciones
	public void ponerBoton(Container c, String titulo, ActionListener oyente) {
		JButton boton = new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}
	
	public void comienza_el_juego() {
		Pelota pelota= new Pelota();
		lamina.add(pelota);
		
		Runnable r = new PelotaHilos(pelota, lamina);//Instanciar de clase que implemente interfaz Runnable
		t = new Thread(r);//instanciar Thread y pasar por parametro objeto de tipo Runnable
			t.start();
		
	}
	
	public void detener() {
		//t.stop(); metodo obsoleto
		
		t.interrupt();
	}
	
	private LaminaPelota lamina;
	private Thread t;
}