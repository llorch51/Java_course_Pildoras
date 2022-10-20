package basico;
import java.util.Scanner;

public class DiezAdivinaNumero_While2 {

	public static void main(String[] args) {

		//construir objeto de clase Scanner
		//Clase  nombre   new Constructor fuente
		Scanner entrada=new Scanner(System.in);
		
		//		refundici�n	|| Math.random devuelve un doble
		int aleatorio=(int)(Math.random()*100); // *100 da el l�mite 
		
		int num=0;
		
		int intentos=0;
		
		while(num!=aleatorio)
		{
			intentos++;
			System.out.println("Introduce un n�mero: ");
			num=entrada.nextInt();
			
			if(aleatorio<num)
			{
				System.out.println("M�s bajo");
			}else if (aleatorio>num)
			{
				System.out.println("M�s alto");
			}
			
		}
		
		System.out.println("Es corecto!!!");
		System.out.println("Lo has conseguido en "+intentos+" intentos");
		
	}

}
