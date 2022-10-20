package streams_AccesoFicheros;

import java.io.FileWriter;
import java.io.IOException;

public class Dos_Writer_EscribirFichero {

	public static void main(String[] args) {
		
		Escribiendo escribe_archivo = new Escribiendo();
		escribe_archivo.escribir();

	}

}

class Escribiendo {
	public void escribir () {
		
		String frase = "\nEsto es una prueba de escritura, putoooo3333!!";
		
		try {
			FileWriter escritura = new FileWriter("D:\\putines2.txt", true);//True, para que lo añada si ya existe, y no que lo sobreescriba
			
			//for(int i=0; i < frase.length(); i++) {
				//escritura.write(frase.charAt(i));//escribe mientras posiciones tiene 'frase'
			//}
			
			escritura.write(frase);
			escritura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}