package streams_AccesoFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Uno_AccesoFichero {

	public static void main(String[] args) {
		
		Leer_Fichero acceder = new Leer_Fichero();
		acceder.lee();

	}

}

class Leer_Fichero{
	
	
	public void lee() {
		
		try {
			FileReader entrada = new FileReader("D:\\puto.txt");
			int contenido_entrada = entrada.read();
			
			while(contenido_entrada != -1) {//mientras no sea -1(o sea, que llegó la final de la lectura del archivo)
				
				char letras_archivo = (char) contenido_entrada;//casting para que nos muestre los caracteres y NO los codigos de los caracteres
				System.out.print(letras_archivo);
				contenido_entrada=entrada.read();//códigos de los caracteres, NO los caracteres
			}
			
			entrada.close();
		} catch (IOException e) {//IOException es superclase de las excepciones
			// TODO Auto-generated catch block
			System.out.println("Algo salió mal, weeeyyy =(");
			System.out.println(e.getClass());
		}
	}
}