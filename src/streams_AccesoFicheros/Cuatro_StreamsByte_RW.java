package streams_AccesoFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cuatro_StreamsByte_RW {

	public static void main(String[] args) throws IOException {
		
		
		
		int[] datos_entrada = new int[4619078];
		int contador = 0;
		
		try {
			FileInputStream archivo_lectura = new FileInputStream("D:\\StreamsByte\\gatos.png");
			
			boolean final_archivo = false;
			
			while(!final_archivo) {
				int byte_entrada = archivo_lectura.read();
				
				if(byte_entrada != -1) {
					datos_entrada[contador]=byte_entrada;
				}else {
					final_archivo=true;
					
				}
				//System.out.println(datos_entrada[contador]);
				contador++;
			}
			
			archivo_lectura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(contador);
		
		crea_fichero(datos_entrada);
	}
	
	
	static void crea_fichero(int[] datos_nuevo_fichero) {
		
		
		try {
			FileOutputStream fichero_nuevo = new FileOutputStream("D:\\StreamsByte\\gatosCopia3.png");
			
			for(int i=0; i<datos_nuevo_fichero.length;i++) {
				fichero_nuevo.write(datos_nuevo_fichero[i]);
			}
			
			fichero_nuevo.close();
			
		} catch (IOException e) {

			System.out.println("Nel pastel, no se pudo");
			e.printStackTrace();
		}
	}

}
