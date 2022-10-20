//++++++++++++++++++CLASE PRINCIPAL PORQUE TIENE METODO MAIN+++++++++++++++++
package poo;

public class Uno_UsoVehiculo_Clases {

	public static void main(String[] args) {

		/*
		Uno_Coche_Clases vocho =new Uno_Coche_Clases();//Instanciar una clase/ejemplarizar una clase
		
		Uno_Coche_Clases miCoche=new Uno_Coche_Clases();
		miCoche.setColor("Rojo");
		miCoche.setAsientos("�o");
		//System.out.println(vocho.getLargo());
		
		System.out.println(miCoche.getColor());
		System.out.println(miCoche.getDatosGenerales());
		System.out.println(miCoche.getAsientos());
		
		//System.out.println("El coche tiene "+vocho.ruedas+" ruedas.");
		 * 
		 */
		
		//CLASE			nombre	llamada 	CONSTRUCTOR
		Uno_Coche_Clases micoche1=new Uno_Coche_Clases();//llamada a constructor CLase COCHE, clase padre
			micoche1.setColor("rosita puton");
		Uno_Furgoneta_Herencia mifurgoneta1=new Uno_Furgoneta_Herencia(580,7);//llamada a constructor con dos parametros Clase Furgoneta
			mifurgoneta1.setColor("Azul");//metodos heredados de clase Coche, clase padre
			mifurgoneta1.setAsientos("si");
			mifurgoneta1.setClima("Si");
		System.out.println(micoche1.getDatosGenerales()+" "+micoche1.getColor());//metodos de clase Coche
		System.out.println(mifurgoneta1.getDatosGenerales()+" " + mifurgoneta1.getColor()+ " " + mifurgoneta1.getDatosFurgoneta());//metodos de Coche y Furgoneta
		
	}

}
