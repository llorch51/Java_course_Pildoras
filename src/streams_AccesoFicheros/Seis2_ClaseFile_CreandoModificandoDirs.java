package streams_AccesoFicheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Seis2_ClaseFile_CreandoModificandoDirs {

	public static void main(String[] args) {

		File ruta = new File("C:\\Users\\Thomas Anderson\\Pictures\\Vivaldi Captures\\prueba222");//ruta y nombre del nuevo directorio
			ruta.mkdir();//crea el nuevo directorio
			
		File ruta2 = new File("C:\\Users\\Thomas Anderson\\Pictures\\Vivaldi Captures\\prueba222\\texto_puerco.txt");//ruta y nombre del nuevo archivo
		String archivo_destino = ruta2.getAbsolutePath();
			try {
				ruta2.createNewFile();//lanza excepcion
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//escribiendo dentro del archivo creado
		Escribiendo2 accede_es = new Escribiendo2();
		accede_es.esribir(archivo_destino);
		
		
		File ruta3 = new File("C:\\Users\\Thomas Anderson\\Pictures\\Vivaldi Captures\\prueba222\\texto_puercoDosDosDos.txt");
			try {
				ruta3.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ruta3.delete();
	}

}

class Escribiendo2 {

	public void esribir(String archivo_destino) {
		
		String frase = "Esto es un ajemplo, putooosss";
		
		try {
			FileWriter escritura = new FileWriter(archivo_destino);
			escritura.write(frase);
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}