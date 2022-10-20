package poo;

				//Jerarquia de interfaces*
public interface Dos_Jefes_Interfaz extends Dos_Trabajadores_Interfaz {
	//Método dentro de una Interfaz
	public abstract String tomarDecisiones(String decision);//Métodos se definen pero no se desarrollan/implementan

	
	//Toda clase que implemente la interfaz, deberá obligatoriamente desarrolar/sobreescribir el/los metodos que contiene la interfaz
	//tambien los heredados por otra interfaz*
}
