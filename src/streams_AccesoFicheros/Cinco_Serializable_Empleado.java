package streams_AccesoFicheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cinco_Serializable_Empleado {

	public static void main(String[] args) {
		Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
			jefe.setIncentivo(5000);
		
		Empleado[] personal = new Empleado[3];
			personal[0] =jefe;
			personal[1]= new Empleado("Ana", 2500, 2008, 10, 11);
			personal[2] = new Empleado("Luis", 1800, 2012, 9, 15);
			
			//Crear flujo de datos
			try {
				//sacar datos a archivo
				ObjectOutputStream escribiendo_fichero= new ObjectOutputStream(new FileOutputStream("D:\\Empleado.txt"));//direccion donde se sacarán los datos
					escribiendo_fichero.writeObject(personal);//se escribe en el archivo el array de empleados
					escribiendo_fichero.close();
					
				//Recuperar datos del archivo sacado
				ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("D:\\Empleado.txt"));//direccion donde está al archivo a leer
				Empleado[] personal_recuperado = (Empleado[]) recuperando_fichero.readObject();//como sabemos que el archivo a leer es un array y su naturaleza(clase),
																					//instanciamos un array, casteandolo a la clase de la que sabemos es
																					//
					recuperando_fichero.close();
					
			for(Empleado e: personal_recuperado) {//for para sacar a consola los datos recuperados del archivo
				System.out.println(e);
			}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
//***************************************************************************************
class Empleado implements Serializable {//Se debe indicar que la clase implementa interfaz Serialiable
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6035004184997293712L;//SerialVersionUID
	
	private String nombre;
	private double sueldo;
	private Date fechaContrato;
	//int anio, mes, dia;
	
	public Empleado(String nombre, double sueldo, int anio, int mes, int dia) {
		this.nombre= nombre;
		this.sueldo=sueldo;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1,dia);
		fechaContrato= calendario.getTime();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	
	public void subirSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje/100;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre= "+ nombre + ", sueldo=  "+sueldo+ ", fecha de contrato= "+fechaContrato;
	}
}

//**********************************************************************************************
class Administrador extends Empleado{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5626391395785418326L;//SerialVersionUID
	private double incentivo;
	
	public Administrador(String nombre, double sueldo, int anio, int mes, int dia) {
		super(nombre, sueldo, anio, mes, dia);
		incentivo=0;
	}
	
	public double getSueldo() {
		double sueldoBase = super.getSueldo();
		return sueldoBase + incentivo;
	}
	
	public void setIncentivo(double incentivo) {
		this.incentivo=incentivo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ". Incentivo= "+ incentivo;
	}
}