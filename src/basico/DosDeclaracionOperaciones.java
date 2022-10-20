package basico;

public class DosDeclaracionOperaciones {

	public static void main (String args[])
	{
		
		//final declara constante
		final float a_pulgadas= 2.54F;
		
		int a=5;
		int b;
		b=7;
		int c=b+a;
		
		float resultado=b/a_pulgadas;
		
		System.out.println(""+c);
		c+=5;
		System.out.println(""+c);
		c-=10;
		System.out.println(""+c);
		System.out.println("En "+b+"cm hay "+resultado+" pulgadas" );
		
		
		//*****La diferencia entre print y println es un salto de línea****
	}
}
