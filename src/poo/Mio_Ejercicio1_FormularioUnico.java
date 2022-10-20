package poo;

public class Mio_Ejercicio1_FormularioUnico {

	public static void main(String[] args) {

		CaballerosZodiaco caballero1=new CaballerosZodiaco("Seiya", "Pegaso", "Meteoro Pegaso");
		CaballerosZodiaco caballero2=new CaballerosZodiaco("Shiryu", "Dragón", "Dragón Naciente");
		
		System.out.println(caballero1.getDatos());
		System.out.println(caballero2.getDatos());
		
		caballero1.setEdad(15);
		caballero2.setEdad(22);
		
		System.out.println("");
		System.out.println(caballero1.getDatos()+" Años: "+caballero1.getEdad());
		System.out.println(caballero2.getDatos()+" Años: "+caballero2.getEdad());
	}

}

//*****************************************************
class CaballerosZodiaco{
	private String nombre;
	private String signo;
	private int edad;
	private String ataque;
	
	public CaballerosZodiaco(String _nombre,String _signo,String ataque) {
		nombre=_nombre;
		signo=_signo;
		this.ataque=ataque;
		
	}
	//***********SETTERS
	public void setEdad(int edad) {
		this.edad=edad;
	}
	//***********GETTERS
	public String getDatos() {
		return "Nombre: "+nombre+
				" Signo: "+signo+
				" Ataque: "+ataque;
	}
	public int getEdad() {
		return edad;
	}
}