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
			System.out.println("Introduce la contrase√±a: ");
			pass=entrada.nextLine();
			
			if(clave.equals(pass)==false)
					{
				System.out.println("Contrase√±a incorrecta");
				
					}
		}
		//si NO es falsa, esto es, que SÕ ES IGUAL y por lo tanto verdadera
		//salta hasta aquÌ
		System.out.println("Contrase√±a correcta!!");
	}

}
