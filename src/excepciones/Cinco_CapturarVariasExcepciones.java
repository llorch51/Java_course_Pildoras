package excepciones;

import javax.swing.JOptionPane;

public class Cinco_CapturarVariasExcepciones {

	public static void main(String[] args) {
		//++++mala practica rodear de Try-catch pedazos de codigo
		//de errores NO-COMPROBADOS, que dependen del programador
		
		try {
			division();
		} catch (ArithmeticException | NumberFormatException e) {//Varias Excepcions
		
			System.out.println(e.getMessage());
			System.out.println("Se ha generado un error de este tipo: " + e.getClass());
			
			//e.getMessage();
		}
		

	}
	
	
	static void division() {
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Dividendo"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Divisor"));
		
		System.out.println("El resultado es: "+ num1/num2);
	}

}
