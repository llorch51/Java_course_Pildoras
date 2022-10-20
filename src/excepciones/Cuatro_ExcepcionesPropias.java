package excepciones;

import javax.swing.JOptionPane;

public class Cuatro_ExcepcionesPropias {

	public static void main(String[] args) {

		String email2 = JOptionPane.showInputDialog("Introduce mail");
		try {
			examina_email2(email2);//se rodea de Try-Catch porque el metodo arroja(throws) de clase propia que extiende de 'Exception'
		} catch (Excepcion_Propia e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	qué tipo de excepcion puede haber
	static void examina_email2(String mail) throws Excepcion_Propia{

		int arroba = 0;
		boolean punto = false;

//Lanzar una Excepcion de forma MANUAL en un punto en concreto
//aunque no es la indicada
		if (mail.length() <= 3) {
			throw new Excepcion_Propia("El mail es demasiado corto");//constructor con parametro de clase de Excepciones Propia
		} else {
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
//+++++++++++++++++++Clase para construirnuestras excepciones propias+++++++++++++++
//Dos constructores
//1-sin parametro
//2-con parametro String
//extenderá de la clase de error apropiado a nuestro programa
class Excepcion_Propia extends Exception{
	
	public Excepcion_Propia() {
		
	}
	
	public Excepcion_Propia(String error) {
		super(error);
	}
}
