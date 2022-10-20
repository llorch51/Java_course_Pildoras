package programacion_generica;

public class Cuatro_HerenciaGenericos_tiposComodin {

	public static void main(String[] args) {
		Empleado2 administrativa = new Empleado2("Helena", 45, 1500);
		Jefe2 DirectoraComercial = new Jefe2("Ana", 27, 3500);
		
		Empleado2 nuevoEmpleado = DirectoraComercial;//principio 'Es un...'
								//dado que un jefe siempre será a su vez, un empleado, es que se puede almacenar la variable
								//DirectoraComercial en variable nuevoEmpleado de tipo Empleado
		
		Pareja2<Empleado2> administrativa2 = new Pareja2<>();
		Pareja2<Jefe2> DirectoraComercial2 = new Pareja2<>();
		
		//Pareja2<Empleado2> nuevoEmpleado2 = DirectoraComercial2; //al manejar clases genericas no se aplica el principio 'es un...'
																//para poder intercambiar variables o heredar
		
		Pareja2.imprimirTrabajador(administrativa2);
		Pareja2.imprimirTrabajador(DirectoraComercial2); //Manda error porque espera objeto de tipo Empleado2 de generica Pareja2, y es Jefe2

	}

}

//*******************************************

class Pareja2<T> {
	
	public Pareja2() {
		primerCampo=null;
	}
	
	public void setPrimer(T nuevoValor) {
		primerCampo = nuevoValor;
	}
	
	public T getPrimer() {
		return primerCampo;
	}
	
	//******************************			COMODÍN, Empleado2 es el limite superior.
	public static void imprimirTrabajador(Pareja2<? extends Empleado2> p) {//aceptará toda subclase que herede de Empleado2 y ella misma
		Empleado2 primero = p.getPrimer();
		System.out.println(primero);
	}
	
	private T primerCampo;
}

//************************************************
class Empleado2{
	
	public Empleado2(String nombre, int edad, double salario) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Empleado2 [nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + "]";
	}

	private String nombre;
	private int edad;
	private double salario;
}

//***********************************************************

class Jefe2 extends Empleado2{
	
	public Jefe2(String nombre, int edad, double salario) {
		super(nombre, edad, salario);
	}
	
	public double incentivo(double incentivo) {
		return incentivo;
	}
}