package poo;

//como con toda interfaz, cada Clase que la implemente, aunque sea por herencia de otra interfaz, deberá desarrollar sus metodos 
public interface Dos_Trabajadores_Interfaz {
	
	public abstract double set_bonus(double gratificacion);
	
	double bonus_base=1500; //Propiedades de las interfaces siempre son Publicas, Estaticas y Constantes(Final) 
							//se implica, aunque no se pongan
							//public static final double bonus_base=1500;

}
