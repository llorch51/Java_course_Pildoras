package poo;

import java.util.Scanner;

public class Seis_Tallas_usoENUM {
	
	//enum define los valores que podrán ser usados en el objeto
	//enum Talla{MINI, MEDIANO, GRANDE, MUY_GRANDE};
	
	enum Talla{
		
		MINI("S"),MEDIANO("M"),GRANDE("L"),EXTRA_GRANDE("XL");
		
		private Talla(String abreviatura) {
			this.abreviatura=abreviatura;
		}
		
		
		public String getAbreviatura() {
			return abreviatura;
		}
		
		private String abreviatura;
	}

	public static void main(String[] args) {

		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Escribe una talla: MINI,MEDIANO,GRANDE,EXTRA_GRANDE");
		String respuesta=entrada.nextLine().toUpperCase();
		
		Talla laTalla=Enum.valueOf(Talla.class, respuesta);//devuelve nombre de constante a 
														//la que pertence la respuesta capturada
		System.out.println("Talla: "+laTalla);
		System.out.println("Abreviatura: "+laTalla.getAbreviatura());
		
		
	}

}
