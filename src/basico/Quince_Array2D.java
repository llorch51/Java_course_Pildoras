package basico;

public class Quince_Array2D {

	public static void main(String[] args) {

		//                  filas||columnas 
		int[][] matrix= new int[3][4];
		
		matrix[0][0]=2;
		matrix[0][1]=43;
		matrix[0][2]=55;
		matrix[0][3]=7;
		
		matrix[1][0]=75;
		matrix[1][1]=6;
		matrix[1][2]=2;
		matrix[1][3]=34;
		
		matrix[2][0]=34;
		matrix[2][1]=-55;
		matrix[2][2]=-5;
		matrix[2][3]=-98;
		
		//            filas
		/*for(int i=0;i<3;i++)
		{
			System.out.println();
			        //columnas
			for(int j=0;j<4;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
		}*/
		
		for(int[] pilin:matrix)
		{
			System.out.println();
			for(int z:pilin)
			{
				System.out.print(z+" ");
			}
		}
		
	}

}
