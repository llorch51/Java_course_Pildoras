package poo;

public class Mio_Ejercicio2_FormularioUnico {

	public static void main(String[] args) {

		//Putas jeni;
		Teibol jeni=new Teibol(true,15,3);//Constructor en clase Teibol
		jeni.setNombre("Jennifer");//Método de clase Putas
		jeni.setEdad(19);//Método de clase Putas
		jeni.setSecu("Ignacio M Altamirano");//Método de clase Teibol
		
		System.out.println(jeni.getDatos());//GET sobreescrito en clase Teibol
		System.out.println(jeni.getHijos());
		
		jeni.setTangas(8);//Método SET en clase Teibol
		System.out.println(jeni.getDatos());
		
		Putas dubraska;//Espacio reservado por clase Putas
						//pero instanciado con clase Teibol
		dubraska=new Teibol("Dubraska",25,false,17,10);//Constructor de clase Teibol
		
		//*******************************************************************
		//***************************************************************
		//dubraska.setTangas(4);//se reservó en clase Putas, ahí no existe método setTangas
		System.out.println(dubraska.getDatos());
		//***************************************************************
		//******************************************************************
		//Si reservo de Clase Abstracta(padre), sólo puedo acceder a sus métodos,
		//no a los de las clases hijas???
		
		Putas malavida;
		malavida=new Teibol();
		
	}

}
//****************************************************************************
abstract class Putas{
	//Propiedades iniciales comunes a todos los objetos creados
	private String nombre;
	private int edad;
	//Constructor que dará estado inicial a los objetos(con sus propiedades)
	public Putas() {
		
	}
	public Putas(String _nombre,int edad) {
		nombre=_nombre;
		this.edad=edad;
	}
	//SETTERS Y GETTERS para poner y obtener valores de propiedades
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setEdad(int edad) {
		this.edad=edad;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public String getDatos() {
		return "Nombre: "+nombre+" Edad: "+edad;
	}
	
}
//***************************************************************************
class Teibol extends Putas{
	private boolean hijos=false;
	private int numtangas;
	private int numtacones;
	private String secundaria;
	
	public Teibol() {
		
	}
	public Teibol(String nombre,int edad,boolean _hijos,int _numtangas,int numtacones) {
		super(nombre,edad);
		hijos=_hijos;
		numtangas=_numtangas;
		this.numtacones=numtacones;
	}
	public Teibol(boolean _hijos,int _numtangas,int numtacones) {
		hijos=_hijos;
		numtangas=_numtangas;
		this.numtacones=numtacones;
		//this.secundaria=secundaria;
	}
	//SETTERS Y GETTERS 
	public void setTangas(int _numtangas) {
		numtangas=_numtangas;
	}
	public void setSecu(String secundaria) {
		this.secundaria=secundaria;
	}
	public boolean getHijos() {
		return hijos;
	}
	public String getDatos() {
		return "Nombre: "+super.getNombre()+" Edad: "+super.getEdad()+
				" Tangas: "+numtangas+" Tacones: "+numtacones+
				" Secundaria: "+secundaria;
	}
	
}
