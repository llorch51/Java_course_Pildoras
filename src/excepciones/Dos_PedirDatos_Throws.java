package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dos_PedirDatos_Throws {

	public static void main(String[] args) {
		
		System.out.println("¿Qué deseas hacer?");
		System.out.println("1: Introducir  Datos.");
		System.out.println("2: Salor del programa");
		
		Scanner entrada = new Scanner(System.in);
		int opcion = entrada.nextInt();
		
		if (opcion == 1) {
			
			try {
				pedirDatos();
			} catch (InputMismatchException e) {//cuando el tipo de dato introducido es distinto al esperado
				
				//e.getStackTrace();
				System.out.println("¿Qué pedo, putooo??");
			}
			
		}else {
			System.out.println("Adios");
			
			System.exit(0);
		}

	}
	

	//Preveer que pueda haber un error y se pone en Try-Catch
	static void pedirDatos() throws RuntimeException {
		
		//try {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Introduce nombre");
			String nombre = entrada.nextLine();
			
			System.out.println("Introduce Edad");//aquí se espera el error
			byte edad = entrada.nextByte();
			
			System.out.println("Hola "+ nombre + ". El año que viene tendrás "+ (edad+1) + " años") ;
			
			entrada.close();
		//} catch (Exception e) {
			//System.out.println("¿Qué pedo, putooo??");
		//}
		
		System.out.println("Hemos terminado");
	}

}
