package basico;
/*	Ciclo WHILE
 * 
 * 	while(condiciones){
 * 		
 * 		conjunto de
 * 		intrucciones
 * 
 * 
 * }
 */




import java.util.Scanner;

public class NueveAccesoAplicacion_While {

	public static void main(String[] args) {

		Scanner entrada=new Scanner(System.in);
		
		String clave="juan";
		String pass="";
		
		
		//mientras la igualdad de clave y pass sea falsa
		while(clave.equals(pass)==false)
		{
			System.out.println("Introduce la contraseña: ");
			pass=entrada.nextLine();
			
			if(clave.equals(pass)==false)
					{
				System.out.println("Contraseña incorrecta");
				
					}
		}
		//si NO es falsa, esto es, que S� ES IGUAL y por lo tanto verdadera
		//salta hasta aqu�
		System.out.println("Contraseña correcta!!");
	}

}
