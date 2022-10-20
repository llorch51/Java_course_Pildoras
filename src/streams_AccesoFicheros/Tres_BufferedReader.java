package streams_AccesoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Tres_BufferedReader {

	public static void main(String[] args) {

		Leer_Fichero_Buffered acceder = new Leer_Fichero_Buffered();
		acceder.lee();
	}

}

class Leer_Fichero_Buffered{
	
	
	public void lee() {
		
		try {
			//FileReader entrada = new FileReader("D:\\puto.txt");
			//BufferedReader miBuffer = new BufferedReader(entrada);//(Objeto tipo File)
			
			BufferedReader miBuffer = new BufferedReader(new FileReader("D:\\puto.txt"));
			String linea = miBuffer.readLine();
			
			
			while(linea != null) {
				
				
				System.out.println(linea);
				linea = miBuffer.readLine();
			}
			
			//entrada.close();
			miBuffer.close();
		} catch (IOException e) {//IOException es superclase de las excepciones
			// TODO Auto-generated catch block
			System.out.println("Algo salió mal, weeeyyy =(");
			System.out.println(e.getClass());
		}
	}
}