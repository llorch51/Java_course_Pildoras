package poo;

import paquete_pruebas_poo.Cinco_clase3_ModACCESO;

public class Cinco_clase2_ModACCESO {

	public static void main(String[] args) {

		Cinco_clase1_ModACCESO miobj=new Cinco_clase1_ModACCESO();//java usa un constructor por defecto
		Cinco_clase3_ModACCESO miobj2=new Cinco_clase3_ModACCESO();//tiene propiedades y métodos de clase_3
						//y también los heredados de clase_1
		System.out.println(miobj2.miMetodo());
		//miobj2.miMetodo();
		
		//TODAS LAS CLASES HEREDAN DE 'OBJECT'
		//***********CLASE CÓSMICA**************
		
	}

}
