package basico;

public class Catorce_Arrays_ForEach2 {

	public static void main(String[] args) {

		int[] random=new int[150];
		
		//Ciclo para generar y rellenar la matriz
		for(int i=0;i<random.length;i++)
		{
			random[i]=(int)Math.round(Math.random()*100);
		}
		
		//ciclo ForEach para visualizarlos
		for(int num:random)
		{
			System.out.print(" "+num);
		}
	}
	

}
