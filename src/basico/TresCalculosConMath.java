package basico;

public class TresCalculosConMath {

	public static void main(String[] args) {
		
		double num1=5.85;
		
		//************REFUNDICIÓN:
		//convertir a webo el resultado dado, en otro tipo de dato
		//Ã‰ste resultado de Math.round devuelve naturalmente un Long
		//Pero para convertirlo en Int, a la fuerza, se antepone Int
		//             int            (Long)Resultado natural
		int resultado=(int)Math.round(num1);
		
		double base=5;
		double exp=3;
		
		int resultado2=(int)Math.pow(base, exp);
		
		System.out.println("El redondeo de "+num1+" es: "+resultado);
		System.out.println(""+base+" elevado a la potencia "+exp+" es igual a: "+resultado2);
		
		

	}

}
