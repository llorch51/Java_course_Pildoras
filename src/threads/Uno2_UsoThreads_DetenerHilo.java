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

public class Uno2_UsoThreads_DetenerHilo {

	public static void main(String[] args) {
		MarcoRebote2 miMarco2 = new MarcoRebote2();
		miMarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco2.setVisible(true);

	}

}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
class PelotaHilos2 implements Runnable{
	
	public PelotaHilos2(Pelota2 unaPelota, Component unComponente) {
		pelota= unaPelota;
		componente = unComponente;
	}

	@Override
	public void run() {
		
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
	
	private Pelota2 pelota;
	private Component componente;
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
class Pelota2{
	
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

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
class LaminaPelota2 extends JPanel{//lamina donde se muestra la pelota
	
	public void add(Pelota2 b) {
		pelotas2.add(b);
	}
	
	public void paintComponent(Graphics g) {//se dibuja
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Pelota2 b: pelotas2) {
			g2.fill(b.getShape());
			revalidate();
		}
	}
	
	private ArrayList<Pelota2> pelotas2 = new ArrayList<>();//se guardan las diferentes instancias de pelota
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
class MarcoRebote2 extends JFrame{//marco donde se situará la lamina donde se dibuja la pelota y los botones necesarios
	
	public MarcoRebote2() {
		setBounds(300, 300, 600, 400);
		setTitle("Rebotes");
		
			lamina = new LaminaPelota2();
		
		JPanel laminaBotones = new JPanel();
		
			on1= new JButton("Hilo1");
			on1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					comienza_el_juego(e);
				}
			});
			
			on2= new JButton("Hilo2");
			on2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					comienza_el_juego(e);
				}
			});
			
			on3= new JButton("Hilo3");
			on3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					comienza_el_juego(e);
				}
			});
			
			off1= new JButton("DetenerHilo1");
			off1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					detener(e);
				}
			});
			
			off2= new JButton("DetenerHilo2");
			off2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					detener(e);
				}
			});
			
			off3= new JButton("DetenerHilo3");
			off3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					detener(e);
				}
			});
		
		laminaBotones.add(on1);
		laminaBotones.add(on2);
		laminaBotones.add(on3);
		laminaBotones.add(off1);
		laminaBotones.add(off2);
		laminaBotones.add(off3);
		
		add(lamina, BorderLayout.CENTER);
		add(laminaBotones, BorderLayout.SOUTH);
	}
	//+++++++++++++++++++++++++++++++++++funciones
	public void ponerBoton(Container c, String titulo, ActionListener oyente) {
		JButton boton = new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}
	
	public void comienza_el_juego(ActionEvent e) {
		Pelota2 pelota= new Pelota2();
		lamina.add(pelota);
		
		Runnable r = new PelotaHilos2(pelota, lamina);
		
		if (e.getSource().equals(on1)) {
			t1 = new Thread(r);
			t1.start();
		}else if (e.getSource().equals(on2)) {
			t2 = new Thread(r);
			t2.start();
		}else if (e.getSource().equals(on3)) {
			t3 = new Thread(r);
			t3.start();
		}
		
		
	}
	
	public void detener(ActionEvent e) {
		//t.stop(); metodo obsoleto
		if (e.getSource().equals(off1)) {
			t1.interrupt();
		}else if (e.getSource().equals(off2)) {
			t2.interrupt();
		}else if (e.getSource().equals(off3)) {
			t3.interrupt();
		}
		
	}
	
	private LaminaPelota2 lamina;
	private Thread t1, t2, t3;
	private JButton on1, on2, on3, off1, off2, off3;
}