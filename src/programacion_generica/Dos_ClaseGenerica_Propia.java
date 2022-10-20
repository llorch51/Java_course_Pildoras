package programacion_generica;

public class Dos_ClaseGenerica_Propia {

	public static void main(String[] args) {
		
		Pareja<String> uno = new Pareja<>();
			uno.setPrimer("juan perez");//Espera un parametro de tipo String porque definimos Pareja<String>, 
										//a pesar de que Pareja es generica
		System.out.println(uno.getPrimer()+ "---" + uno.getClass());//regresa String, a pesar de ser metodo de clase generica
			
		Persona persona1 = new Persona("Guadalupe");
		Pareja<Persona> dos = new Pareja<>();
			dos.setPrimer(persona1);//pasamos por parametro un objeto tipo Persona porque definimos variable de clase Pareja como tipo Persona
			
		System.out.println(dos.getPrimer().toString()+ "---" + dos.getClass());
		
		
		//CLASE GENERICA SE ADAPTA AL TIPO  QUE DEFINIMOS EN SU DECLARACION ClaseGenerica<Tipo> nombreInstancia
	}

}
//*********************************************

class Pareja<T> {
	
	public Pareja() {
		primerCampo=null;
	}
	
	public void setPrimer(T nuevoValor) {
		primerCampo = nuevoValor;
	}
	
	public T getPrimer() {
		return primerCampo;
	}
	
	private T primerCampo;
}



//*******************************************************
class Persona {
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	private String nombre;
}