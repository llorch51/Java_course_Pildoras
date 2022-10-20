package streams_AccesoFicheros;

import java.io.File;

public class Seis_ClaseFile_AccesoFicheros {

	public static void main(String[] args) {
		
		File ruta = new File("C:\\Users\\Thomas Anderson\\Pictures\\Vivaldi Captures");
		
		System.out.println(ruta.getAbsolutePath());
		System.out.println(ruta.exists());
		
		String[] nombres_archivos = ruta.list();//devuelve array de String con los elementos que haya en la ruta
		
		for(String e:nombres_archivos) {//mostrar los elementos
			System.out.println(e);
			File f = new File(ruta.getAbsolutePath(), e);//se instancia nuevamente File para poder acceder a archivos en subcarpetas
			if (f.isDirectory()) {//si F es directorio
				String[] archivos_subcarpeta = f.list();//haz otro array donde gaurdar los archivos que haya
				
				for(String j: archivos_subcarpeta) {//nuevo for para mostrar los elemeentos que haya en esa subcarpeta
											//La carpeta encontrada y sus subelementos se mostraran al final en la consola
					System.out.println(j);
				}
			}
		}
		
	}

}
