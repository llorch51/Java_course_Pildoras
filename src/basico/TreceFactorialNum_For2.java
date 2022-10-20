package basico;
import java.util.Scanner;

public class TreceFactorialNum_For2 {

	public static void main(String[] args) {


		Scanner entrada=new Scanner(System.in);
		long resultado=1L;
		
		System.out.println("Introduce un número: ");
		int num=entrada.nextInt();
		
		for(int i=num;i>0;i--)
		{
			resultado=resultado*i;
		}
		System.out.println("El factorial de "+num+" es "+ resultado);
	}

}
