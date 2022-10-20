package basico;
/*
 * Ciclo FOR
 * 
 * 	for(inicio blucle;condición;contador bucle){
 * 
 * 		conjunto de
 * 			instrucciones
 * 
 * }
 * 
 * 
 */

import java.util.Scanner;

public class DoceCompruebaEmail_For {

	public static void main(String[] args) {

		//construir objeto de clase Scanner
		//Clase  nombre new Constructor fuente
		Scanner entrada=new Scanner(System.in);
		int arroba=0;
		boolean punto=false;
		
		System.out.println("Escribe tu Email: ");
		String mail=entrada.nextLine();
		
		// inicio ||condición||	contador
		for(int i=0;i<mail.length();i++)
		{
			if(mail.charAt(i)=='@')
			{
				arroba++;
			}
			
			if(mail.charAt(i)=='.')
			{
				punto=true;
			}
		}
		
		if(arroba==1 && punto==true)
		{
			System.out.println("Tu Email es válido");
		}
		else
		{
			System.out.println("Tu Email NO es válido");
		}
		
	}

}
