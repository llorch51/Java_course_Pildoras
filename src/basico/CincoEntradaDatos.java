package basico;

import java.util.Scanner;

public class CincoEntradaDatos {

	public static void main(String[] args) {

		//Creamos un objeto de la clase Scanner llamado "entrada"
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Introduce tu nombre");
		//            usamos el objeto Scanner creado, que es "entrada"
		//            puesto que Scanner no es static
		String nombreUsuario=entrada.nextLine();
		System.out.println("Introduce tu edad");
		int edad=entrada.nextInt();
		System.out.println("Hola "+nombreUsuario+" el siguiente a��o tendr��s "+ (edad+1) +" a��os");
	}

}
