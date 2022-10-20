package poo;
//Super Clase o Clase Padre

public class Uno_Coche_Clases {
	
	//PRIVATE-	Modificador de acceso/encapsulamiento
	//se modifica a traves de los metodos get/set
	private int ruedas;
	private double largo; 
	private double ancho;
	private int peso;
	private int peso_total;
	private String color;
	private boolean asientos_cuero,climatizador;

	//Metodo constructor de la clase
	//tiene el mismo nombre que la clase
	public Uno_Coche_Clases()
	{
		ruedas=4;
		largo=250;
		ancho=200;
		peso=600;
	}
	
	//++++++++++++++++++getters y setters++++++++++++++++++++++++
	//GET---se obtiene, se devuelve un dato/informacion
	//PUBLIC(modificador/limite de acceso) STRING(tipo de dato que se devuelve) GET_nombre(nombre del metodo)
	public String getDatosGenerales() {
		return "La plataforma tiene "+ruedas+" ruedas. "+largo/100+" metros de largo. "+ancho/100+
				" metros de ancho. Y pesa "+peso+" kilos";
	}//todo metodo GET debe llevar un RETURN(precisamente la instruccion que DEVUELVE la informacion)
	
	
	//*************************************
	
	//SET---pone/modifica una propiedad, pero no regresa informacion
	//PUBLIC(modificador de acceso) VOID(no regresa nada) SET_nombre(nombre del metodo)
	public void setColor(String _color) {
		color=_color;
		//color="Azul";
	}

	public String getColor() {
		return "El color del coche es: "+color;
	}
	//*****************************************
	public void setAsientos(String _asientos_cuero) {
		if(_asientos_cuero.equalsIgnoreCase("si")) {
			asientos_cuero=true;
		}else {
			asientos_cuero=false;
		}
	}
	public String getAsientos() {
		if(asientos_cuero==true) {
			return "El coche tiene asientos de cuero";
		}else {
			return "El coche tiene asientos de pobre tela";
		}
	}
	//********************************************
	public void setClima(String _climatizador) {
		if(_climatizador.equalsIgnoreCase("si")) {
			climatizador=true;
		}else {
			climatizador=false;
		}
	}
	public String getClima() {
		if(climatizador=true) {
			return "El coche SI tiene climatizador";
		}else {
			return "El coche SI tiene A/A";
		}
	}
}

