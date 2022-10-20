package basico;
/* ciclo DO WHILE
 * 
 * 	do{
 * 
 * 		conjunto de
 * 		instrucciones
 * 
 * 		}while(condición);
 * 
 */



import java.util.Scanner;

public class OncePesoIdeal_DoWhile {

	public static void main(String[] args) {

		Scanner entrada=new Scanner(System.in);
		String genero="";
		
		
		do {
		System.out.println("Introduce tu gÃ©nero H/M");
		genero=entrada.nextLine();
		
		}while(genero.equalsIgnoreCase("H")==false && genero.equalsIgnoreCase("M")==false);
		
		System.out.println("Introduce tu altura en cm: ");
		int altura=entrada.nextInt();
		
		int pesoIdeal=0;
		
		if(genero.equalsIgnoreCase("H"))
		{
			pesoIdeal=altura-110;
		}else if (genero.equalsIgnoreCase("M"))
		{
			pesoIdeal=altura-120;
		}
		System.out.println("Tu peso ideal es "+pesoIdeal+ "kg");
			
			
			
	}

}
