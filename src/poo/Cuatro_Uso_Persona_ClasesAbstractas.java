package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Cuatro_Uso_Persona_ClasesAbstractas {

	public static void main(String[] args) {

		Persona[] lasPersonas=new Persona[2];
		lasPersonas[0]=new Empleado3("José Gorostiza",50666,1988,2,15);
		lasPersonas[1]=new Alumno("Ana Lopéz","Sociología");
		
		for(Persona p:lasPersonas) {
			System.out.println(p.getNombre()+" "+p.getDescripcion());
		}
		
	}

}

//++++++++++++++++++++++++++++++++++++++CLASE+++++++++++++++++++++++++++

abstract class Persona{//si la clase contiene un metodo abstracto, esta deber� ser
						//tambien abstracta
	String nombre;
	
	public Persona(String _nombre){
		nombre=_nombre;
		
	}
	
	//GET
	public String getNombre() {
		return nombre;
	}
	public abstract String getDescripcion();//metodo abstracto, solo se define
											/*deber� implementarse/sobreescribirse en cada clase
											 * que herede de esta clase en donde se esta definiendo
											 * */
}

//++++++++++++++++++++++++++++++++OTRA CLASE+++++++++++++++++++++++++++
class Empleado2 extends Persona{
	
	public Empleado2(String nombre,double _sueldo,int _anio,int _mes,int _dia) {
		super(nombre);//llamada a constructor de clase padre(Persona) con el parametro que utiliza
		sueldo=_sueldo;
		GregorianCalendar calendario=new GregorianCalendar(_anio, _mes-1, _dia);
		altaContrato=calendario.getTime();
		id=idSiguiente;
		idSiguiente++;
	}
	//************GETTERS
	public String getDescripcion() {//implementacion de metodo abstracto por herencia de clase
		return "Este empleado tiene un Id: "+id+" con un sueldo: "+sueldo;
	}
	public double getSueldo() {
		return sueldo;
	}
	public Date getAltaContrato() {
		return altaContrato;
	}
	//Metodo STATIC, pertenece a la clase
	public static int getIdSiguiente() {
		return idSiguiente;
	}
	//*************SETTERS
	public void setSubeSueldo(int porcentaje) {
		Double aumento=sueldo*(porcentaje/100);
		sueldo=sueldo+aumento;
	}
	
	//Caracteristicas---Propiedades Iniciales/Comunes para mis objetos
	private double sueldo;
	private Date altaContrato;	
	private static int idSiguiente=1;
	private int id;
}

//+++++++++++++++++++++++++++Otra CLASE+++++++++++++++++++++++++++++++++++
class Alumno extends Persona{
	private String carrera;
	
	public Alumno(String nombre,String carrera) {
		super(nombre);//llamada a constuctor de clase padre
		this.carrera=carrera;
		
	}
	public String getDescripcion() {//implementacion de metodo abstracto por herencia de clase
		return "Este alumno está estudiando la carrera de: "+carrera;
	}
}