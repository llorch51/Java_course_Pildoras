package basico;
import java.util.Scanner;

public class Catorce_Arrays_ForEach {

	public static void main(String[] args) {

		
		//TipoDeDato+"[]"(determina que será matriz)|| nombreVariable||new||TipoDeDato con número de elementos
		String[] paises= new String[3];
		
		//String[] paises2= { "mexico", "brasil", "argentina"};
		//int[] mi_matriz= {3,4,76,23,88,99,64,234,51,11};
		
		Scanner entrada =new Scanner(System.in);
		
		for(int i=0;i<3;i++)
		{
			System.out.println("Introduce el país "+(i+1));
			paises[i]=entrada.nextLine();
		}
		
		//Para este For, se debe declarar un contador del mismo tipo que el array a contar
		//   String porque mi array es de Strings
		for(String elemento:paises)//él solo sabe hasta donde llegar
		{
			System.out.println("País: "+elemento);//Para mostrar, se debe poner el "contador" que recien creamos
		}
	}

}
