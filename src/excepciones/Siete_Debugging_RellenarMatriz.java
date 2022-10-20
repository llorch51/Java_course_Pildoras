package excepciones;

import javax.swing.JOptionPane;

public class Siete_Debugging_RellenarMatriz {

	public static void main(String[] args) {
		
		int numero_elementos = Integer.parseInt(JOptionPane.showInputDialog("Numero de elementos"));
		int[] numeros_aleatorios = new int[numero_elementos];
		
		//Rellenar cada posicion del array con un numero aleatorio casteado a int
		for(int i=0; i<numeros_aleatorios.length; i++) {
			numeros_aleatorios[i] = (int) (Math.random()*100);
		}
		
		//for mejorado para mostrar el array
		for(int elemento_temporal :  numeros_aleatorios) {
			System.out.println(elemento_temporal);
		}

	}

}
