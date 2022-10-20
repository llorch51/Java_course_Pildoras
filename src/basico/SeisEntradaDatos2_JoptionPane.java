package basico;
import javax.swing.JOptionPane;

public class SeisEntradaDatos2_JoptionPane {

	public static void main(String[] args) {

		//                Como es static, hay que nombrar la clase a la q pertenece
		//                 		||           ||
		String nombreUsuario=JOptionPane.showInputDialog("Introduce tu nombre: ");
		
		String edad=JOptionPane.showInputDialog("Introduce tu edad: ");
		//Convertir de un String a Int
		int edad_usuario=Integer.parseInt(edad);
		
		System.out.println("Hola "+nombreUsuario+" tienes "+edad_usuario+" años");
	}

}
