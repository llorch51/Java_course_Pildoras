package poo;

//modificador de acceso por defecto NO PERMITE heredar
//métodos y propiedades a subclases
public class Cinco_clase1_ModACCESO {
//se pone PUBLIC o PROTECTED para heredarlos
	protected int mivar=5;
	protected int mivar2=2;
	
	protected String miMetodo() {
		return "El valor de mivar2 es : "+mivar2;
	}
}
