//++++++++++++++++++++++JAVA NO ADMITE HERENCIA MULTIPLE++++++++++++++++++++

package poo;
//SubClase o Clase Hija

//									extends--hereda
public class Uno_Furgoneta_Herencia extends Uno_Coche_Clases{//Uno_Coche_Clases---Super clase/clase padre
	
	private int capacidad_carga;
	private int plazas_extra;
	
	public Uno_Furgoneta_Herencia(int capacidad_carga,int plazas_extra) {
		super();//llama al constructor de la clase padre
		this.capacidad_carga=capacidad_carga;
		this.plazas_extra=plazas_extra;
	}
	
	public String getDatosFurgoneta() {
		return ". La capacidad de carga es: "+capacidad_carga+
				". Y las plazas son: "+plazas_extra;
	}

}
