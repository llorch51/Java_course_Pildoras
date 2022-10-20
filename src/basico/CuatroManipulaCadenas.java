package basico;
//*********clase STRING
//.length()
//-Devuelve el tamaÃ±o de la cadena

//.charAt(índice)
//-devuelve la letra contenida en esa posición de la cadena
public class CuatroManipulaCadenas {

	public static void main(String[] args) {
			
		String nombre="Nirvana Elizabeth";	
		
		int ultima_letra;
		ultima_letra=nombre.length();
		
		System.out.println("Mi nombre es "+nombre);
		System.out.println("Mi nombre tiene "+nombre.length()+" letras");
		System.out.println("La primera letra de "+nombre+" es "+nombre.charAt(0));
		//length() devuelve una posición empezando por 1
		//charAt()requiere de un índice (array), empezando en cero
		//por eso se resta 1
		System.out.println("Y la Ãºltima letra de tu nombre es "+nombre.charAt(ultima_letra-1));
		System.out.println("*****************************************");
		
		String frase="Hoy es un buen dÃ­a para morir";
		String frasesub=frase.substring(4, 18)+" para coger la mano de dios con "+nombre;
		
		System.out.println(frasesub);
		System.out.println("*****************************************");
		
		String nom1="Puto chupa pitos";
		String nom2="pUtO CHupa pIToS";
		
		System.out.println(nom1.equals(nom2));
		System.out.println("Es "+nom1.equalsIgnoreCase(nom2)+" Que dicen lo mismo");
		



	}

}
