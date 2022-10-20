package poo;

import java.util.Scanner;

public class Seis2_Tallas_ENUM {
	
	 enum Talla{//ENUM no admite crear instancias/objetos de clase
		 
		 MINI("S"), MEDIANO("M"), GRANDE("L"), EXTRA_GRANDE("XL");
		 
		 
		 private Talla(String abreviatura) {
			 this.abreviatura=abreviatura;
		 }
		 
		 public String getAbreviatura() {
			 return abreviatura;
		 }
		 
		 private String abreviatura;
		 
	 }

	public static void main(String[] args) {

		
		Scanner in=new Scanner(System.in);
		System.out.println("Escribe una talla: MINI, MEDIANO, GRANDE, EXTRA");
		String entrada=in.next().toUpperCase();
		
		Talla la_Talla=Enum.valueOf(Talla.class, entrada);//variable de enum Talla que se inicializa con metodo estatico de clase Enum
		System.out.println("Talla: "+la_Talla);
		//System.out.println("Abreviatura: "+la_Talla.getAbreviatura());
	}

}
