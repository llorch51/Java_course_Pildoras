package basico;
//*********clase STRING
//.length()
//-Devuelve el tamaño de la cadena

//.charAt(�ndice)
//-devuelve la letra contenida en esa posici�n de la cadena
public class CuatroManipulaCadenas {

	public static void main(String[] args) {
			
		String nombre="Nirvana Elizabeth";	
		
		int ultima_letra;
		ultima_letra=nombre.length();
		
		System.out.println("Mi nombre es "+nombre);
		System.out.println("Mi nombre tiene "+nombre.length()+" letras");
		System.out.println("La primera letra de "+nombre+" es "+nombre.charAt(0));
		//length() devuelve una posici�n empezando por 1
		//charAt()requiere de un �ndice (array), empezando en cero
		//por eso se resta 1
		System.out.println("Y la última letra de tu nombre es "+nombre.charAt(ultima_letra-1));
		System.out.println("*****************************************");
		
		String frase="Hoy es un buen día para morir";
		String frasesub=frase.substring(4, 18)+" para coger la mano de dios con "+nombre;
		
		System.out.println(frasesub);
		System.out.println("*****************************************");
		
		String nom1="Puto chupa pitos";
		String nom2="pUtO CHupa pIToS";
		
		System.out.println(nom1.equals(nom2));
		System.out.println("Es "+nom1.equalsIgnoreCase(nom2)+" Que dicen lo mismo");
		



	}

}
