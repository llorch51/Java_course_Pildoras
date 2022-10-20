package basico;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SieteAreas_Switch {

	public static void main(String[] args) {
		
		//construir objeto de clase Scanner
		//Clase  nombre   new Constructor fuente
		Scanner entrada=new Scanner(System.in);
		
		System.out.print("Elige una opción: \n1-Cuadrado \n2-Rectángulo \n3-Triángulo \n4-Círculo \n");
		int opcion=entrada.nextInt();
		
		switch(opcion)
		{
		case 1:
			//System.out.println("Introduce el lado:");
			//int lado=entrada.nextInt();
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			System.out.println("El área del cuadrado es: "+Math.pow(lado, 2));
			break;
		case 2:
			//System.out.println("introduce la base:");
			//int base=entrada.nextInt();
			//System.out.print("Introduce la altura:");
			//int h=entrada.nextInt();
			int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la Base"));
			int h=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			System.out.println("El área del rectángulo es: "+ base*h);
			break;
		case 3:
			//System.out.println("introduce la base:");
			//int base2=entrada.nextInt();
			//System.out.print("Introduce la altura:");
			//int h2=entrada.nextInt();
			int base2=Integer.parseInt(JOptionPane.showInputDialog("Introduce Base"));
			int h2=Integer.parseInt(JOptionPane.showInputDialog("Introduce Altura"));
			System.out.println("El área del triángulo es: "+(base2*h2)/2);
			break;
		case 4:
			//System.out.println("Introduce el radio:");
			//int radio=entrada.nextInt();
			int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
			System.out.print("El área del círculo es ");
			System.out.printf("%1.4f",Math.PI*Math.pow(radio, 2));
			break;
			default:
				System.out.println("Esa opción no es correcta");
			
		}
	}

}
