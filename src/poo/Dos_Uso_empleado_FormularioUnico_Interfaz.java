//Un ���nico fichero para todas las clases
//S���lo una clase puede ser p���blica y debe ser la del main
package poo;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

//import org.omg.Messaging.SyncScopeHelper;

public class Dos_Uso_empleado_FormularioUnico_Interfaz {

	public static void main(String[] args) {

		/*
		Instancias de la clase Empleado
		Empleado empleado1=new Empleado("Chachita Perez",15000,1989,02,17);
		Empleado empleado2=new Empleado("Vana Flores",25030,1996,03,18);
		Empleado empleado3=new Empleado("PP Juarez",8000,1979,12,20);
		
		empleado1.setSubeSueldo(5);
		empleado2.setSubeSueldo(5);
		empleado3.setSubeSueldo(5);
		
		System.out.println("Nombre: "+empleado1.getNombre()+
				"\nSueldo: "+empleado1.getSueldo()+"\nFecha de alta: "+empleado1.getAltaContrato()+"\n");
		System.out.println("Nombre: "+empleado2.getNombre()+
				"\nSueldo: "+empleado2.getSueldo()+"\nFecha de alta: "+empleado2.getAltaContrato()+"\n");
		System.out.println("Nombre: "+empleado3.getNombre()+
				"\nSueldo: "+empleado3.getSueldo()+"\nFecha de alta: "+empleado3.getAltaContrato());
				*/
		
		//******************FORMA ALTERNATIVA***********
		Jefatura jefe_RRHH=new Jefatura("Jorge",5500,1989,2,14);
			jefe_RRHH.setIncentivo(2570);
		//mi clase[]||nombreDeMiObjeto||new||constructor[tama���oArray]
		Empleado[] misEmpleados=new Empleado[5];
		//							Par���metros del constructor(String,Double,int,int,int)
			misEmpleados[0]=new Empleado("Chachita Perez",15000,1989,2,17);
			misEmpleados[1]=new Empleado("Vana Flores",2530,1996,3,18);
			misEmpleados[2]=new Empleado("PP Juarez",8000,1979,12,20);
		
			misEmpleados[3]=jefe_RRHH;//Polimorfismo. Principio de Sustituci��n
		//Se usa un objeto de la subclase aunque el array espere un objeto
		//de la superclase
			misEmpleados[4]=new Jefatura("Maria",95000,1996,4,15);
		//*****CASTING DE OBJETOS********
		//convertir mi objeto de clase Empleado ubicado en array misEmpleados[4]
		//en un objeto de clase Jefatura
		
		//Clase a la que quiero convertir||nomVariable||=||(nuevamente clase alaque quiero convertir)||objeto a convertir
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[4];
			jefa_Finanzas.setIncentivo(99000);//como ya se casteó a objeto de clase Jefatura, ya se tiene acceso a su metodo setIncentivo
		
		//metodo de interfaz Trabajadores, por herencia en interfaz Jefes, en clase Jefatura
		System.out.println("Bonus de Jefa_finanzas: "+jefa_Finanzas.set_bonus(500));
		
		//metodo de interfaz Trabajadores por implementacion en clase Empleado
		System.out.println("Bonus de "+misEmpleados[1].getNombre()+" es de: "+misEmpleados[1].set_bonus(250));
		
		
		
		Empleado director_comercial=new Jefatura("Sandra",99000,2012,05,05);
		Comparable ejemplo=new Empleado("Elizabeth",33000,1969,22,06);//Crear objeto de tipo interfaz, pero instanciada de clase Empleado
		if(director_comercial instanceof Empleado) {
			System.out.println("Es de tipo jefatura");
		}
		if(ejemplo instanceof Comparable) {
			System.out.println("Implementa interfaz Comparable");
		}
		
		
		//ciclo FOR normal para aumentar porcentaje en sueldo
		/*for(int i=0;i<misEmpleados.length;i++) {
			misEmpleados[i].setSubeSueldo(5);
		}*/
		
		//ciclo FOR MEJORADO para aumentar porcentaje en sueldo
		//se crea variable del mismo tipo del array que se quiere recorrer
		//como el array fue hecho del tipo Empleado, se crea "e", del mismo tipo
		for(Empleado e: misEmpleados) {
			e.setSubeSueldo(5);
		}
		
		
		/*ciclo FOR normal para mostrar informacion del array
		for(int i=0;i<misEmpleados.length;i++) {
			System.out.println("Nombre: "+misEmpleados[i].getNombre()+
								" Sueldo: "+misEmpleados[i].getSueldo()+
								" Fecha de alta: "+misEmpleados[i].getAltaContrato());
		}*/
		
		
		//queremos ordenar por sueldo los objetos en el array misEmpleados
		Arrays.sort(misEmpleados);//hay que implementar interfaz predefinida(Comparable) a la clase
						//que da origen al array, esto es, Empleado
		
		
		//ciclo FOR MEJORADO para mostrar informaci���n
		for (Empleado e: misEmpleados) {
			System.out.println("Nombre: "+e.getNombre()+
					" Sueldo: "+e.getSueldo()+
					" Fecha de alta: "+e.getAltaContrato());
		}//Polimorfismo en variable |e|
		//se comporta como objeto de Empleado cuando muestra informaci��n
		//de objetos Empleados, pero tambi��n se comporta como objeto Jefatura
		//cuando debe mostrar informaci��n de objetos de Jefatura
		
	}//*****************ENLAZADO DINaMICO:
	//la JVM sabe a cual metodo de clase llamar segun la informacion del objeto que debe mostrar
	

}


//							++++++++Clase creada en el mismo fichero+++++++++++

//se implementa la interfaz Comparable
//pero para que haga lo que debe hay que
//sobreescribir m�todo |compareTo|
class Empleado implements Comparable, Dos_Trabajadores_Interfaz {
	
	//Primer Constructor con mismo nombre que la clase
	//Public para que pueda ser accedido desde otros lados
	public Empleado(String _nombre,double _sueldo,int _anio,int _mes,int _dia) {
		nombre=_nombre;
		sueldo=_sueldo;
		//objeto de tipo GregorianCalendar para mandarselo a altaContrato
		GregorianCalendar calendario=new GregorianCalendar(_anio, _mes-1, _dia);//mes empieza en 0
		altaContrato=calendario.getTime();
		id=idSiguiente;
		idSiguiente++;
	}
	
	//SOBRECARGA DE CONSTRUCTORES
	//Segundo Constructor con parametro diferente que hara referencia a otro constructor
	public Empleado(String _nombre) {
		this(_nombre,8000,1996,03,18);//llama al constrcutor con mismo numero de parametros||se asignaran estos datos por defecto
		id=idSiguiente;
		idSiguiente++;
	}
	
	
	//************GETTERS
	public String getNombre() {
		return nombre + " Id: "+id;
	}
	public double getSueldo() {
		return sueldo;
	}
	public Date getAltaContrato() {
		return altaContrato;
	}
	//M��todo STATIC, pertenece a la clase
	public static int getIdSiguiente() {
		return idSiguiente;
	}
	//*************SETTERS
	public void setSubeSueldo(int porcentaje) {
		Double aumento=sueldo*(porcentaje/100);
		sueldo=sueldo+aumento;
	}
	
	
	//metodo necesario para interfaz Comparable
	public int compareTo(Object miObjeto) {
		//refundición de miObjeto Object en objeto Empleado
		//para poder comparar entre objetos de array de clase Empleado
		Empleado otroEmpleado=(Empleado) miObjeto;
		if(this.sueldo<otroEmpleado.sueldo) {	  
			return -1;
		}
		if(this.sueldo>otroEmpleado.sueldo) {
			return 1;
		}
		return 0;
	}
	
	//Desarrollo de metodo contenido en interfaz Trabajadores, pero NO por herencia con otra interfaz
	public double set_bonus(double gratificacion) {
		//No tiene prima
		return Dos_Trabajadores_Interfaz.bonus_base+gratificacion;
		//Puede ser diferente en su contenido al implementado en otra clase, segun convenga 
	}
	
	//Caracter���sticas---Propiedades Iniciales/Comunes para mis objetos
	private String nombre;
	private double sueldo;
	private Date altaContrato;	
	private static int idSiguiente=1;
	private int id;
}

//							+++++++++++++++++++++++Otra clase+++++++++++++++++++++++++
//Cuando implementamos una Interfaz estamos obligados a desarrollar todos los métodos
//que esa interfaz incluye
class Jefatura extends Empleado implements Dos_Jefes_Interfaz{
	
	private double incentivo;
	
	public Jefatura(String nombre,double sueldo,int anio,int mes,int dia) {
		super(nombre,sueldo,anio,mes,dia);//llama constructor de clase padre, que debe tener mismos parametros
	}
	
	
	//**********SETTERS Y GETTERS**************
	public void setIncentivo(double incentivo) {
		this.incentivo=incentivo;
	}
	//Sobreescribe al de la clase padre
	public double getSueldo() {
		double sueldoJefe=super.getSueldo();//llama al m��todo de la clase padre
		return sueldoJefe+incentivo;
	}

	//*****************************************************************
	//Desarrollo de método contenido en Interfaz Jefes_Interfaz
	public String tomarDecisiones(String decision) {
		return "Un miembro de la dirección ha tomado la decisión de: "+decision;
	}
	
	//Desarrollo de metodo contenido en interfaz Trabajadores, por herencia con interfaz Jefes
	public double set_bonus(double gratificacion) {
		double prima=2000;
		//Acceso a la propiedad bonus_base(Estatica y Final) contenido en la interfaz Trabajadores
		return Dos_Trabajadores_Interfaz.bonus_base+gratificacion+prima;
	}
}

//									+++++++++++++++++++Otra Clase++++++++++++++++++++++
class Director extends Jefatura{
	public Director(String nombre,double sueldo,int anio,int mes,int dia) {
		super(nombre,sueldo,anio,mes,dia);
	}
}
