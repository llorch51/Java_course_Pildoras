package poo;

				//Jerarquia de interfaces*
public interface Dos_Jefes_Interfaz extends Dos_Trabajadores_Interfaz {
	//M�todo dentro de una Interfaz
	public abstract String tomarDecisiones(String decision);//M�todos se definen pero no se desarrollan/implementan

	
	//Toda clase que implemente la interfaz, deber� obligatoriamente desarrolar/sobreescribir el/los metodos que contiene la interfaz
	//tambien los heredados por otra interfaz*
}
