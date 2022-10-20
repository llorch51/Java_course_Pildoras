package poo;

public class Tres_Prueba_UsoFINAL_FormularioUnico {

	//Public-para que se pueda acceder a el desde fuera
	//Static-porque le pertenece a la clase, no a un objeto
	//void-no devuelve nada
	//main-principal, java sabe que debe arrancar aqui
	public static void main(String[] args) {

		Empleados trabajador1=new Empleados("Paco");
		Empleados trabajador2=new Empleados("Jorge");
		Empleados trabajador3=new Empleados("Chucho");
		//Saco datos con estado inicial
		System.out.println(trabajador1.getDatos());
		System.out.println(trabajador2.getDatos());
		//Cambio la seccion de mis objetos construidos
		trabajador1.setSeccion("Mantenimiento");
		trabajador2.setSeccion("Jefazo, el mas vergas!");
		//vuelvo a sacar con datos ya modificados
		System.out.println(trabajador1.getDatos());
		System.out.println(trabajador2.getDatos());
		System.out.println(trabajador3.getDatos());
		
		System.out.println(Empleados.getIdSiguiente());//Se llama al metodo estatico
		
	}

}


//+++++++++++++++++++++++++++++++++++++	Clase ++++++++++++++++++++++++++++++++++++++
class Empleados {
	//propiedades
	private final String nombre;//FINAL evita que se pueda modificar un valor
	private String seccion;
	private int id; //cada obj tendrá su copia de ID
	
	//******STATIC*******
	private static int idSiguiente=1;//static sustrae la propiedad del objeto y la hace de la clase
									//Asi todos los objetos creados comparten una sola copia
	
	
	//Constructor. Da un estado inicial a los objetos
	public Empleados(String _nombre) {
		nombre=_nombre;
		seccion="Administracion";
		id=idSiguiente;
		idSiguiente++;
	}
	
	//**************SETTERS
	public void setSeccion(String _seccion) {
		seccion=_seccion; //this.    se utiliza para diferenciar el campo de clase
						//de un argumento o parametro
	}
	
	//Como usamos FINAL en la propiedad 'nombre', este metodo no se puede usar, pues el nombre no se puede cambiar, al ser final
	/*
	public void setNombre(String _nombre) {
		nombre=_nombre;
	}*/
	
	//************GETTERS
	public String getDatos() {
		return "El nombre es "+nombre+" y la seccion es "+seccion+" Id: "+id;
	}
	
	//ejemplo de metodo ESTATICO***
	//pertenece a la clase. Se llama haciendo referencia a la clase. no a los objetos
	public static String getIdSiguiente() {
		return "El Id siguiente es: "+idSiguiente;
	}//no puede acceder a propiedades de clase que no sean tambien static
	
	
}
