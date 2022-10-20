package excepciones;

import javax.swing.JOptionPane;

public class Tres_Email_Throw {

	public static void main(String[] args) {
		
		String email = JOptionPane.showInputDialog("Introduce mail");
		examina_email(email);
		

	}

	//									qué tipo de excepcion puede haber
	static void examina_email(String mail) throws ArrayIndexOutOfBoundsException {
		
		int arroba = 0;
		boolean punto = false;
		
		//Lanzar una Excepcion de forma MANUAL en un punto en concreto
		//aunque no es la indicada
		if (mail.length() <= 3 ) {
			ArrayIndexOutOfBoundsException mi_excepcion = new ArrayIndexOutOfBoundsException();
			throw mi_excepcion;//THROW
		}else {
			for (int i = 0; i < mail.length(); i++) {
				if (mail.charAt(i) == '@') {
					arroba++;
				}
				if (mail.charAt(i) == '.') {
					punto = true;
				}
			}
		}
		
		
		if (arroba == 1 && punto == true) {
			System.out.println("Es correcto");
		} else {
			System.out.println("NO es correcto");

		}
	}
}

