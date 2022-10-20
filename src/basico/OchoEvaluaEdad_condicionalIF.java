package basico;
import java.util.Scanner;

public class OchoEvaluaEdad_condicionalIF {

	public static void main(String[] args) {

		//construir objeto de clase Scanner
		//Clase  nombre   new Constructor fuente
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduce tu edad: ");
		//una variable donde guardar la entrada de dato
		int edad=entrada.nextInt();
		
		if(edad>=18)
		{
			System.out.println("Eres mayor de edad");
		}else
		{
			System.out.println("Eres menor de edad");
		}
		
	}

}
