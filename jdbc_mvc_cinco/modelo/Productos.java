package modelo;

public class Productos {//Hay que encapsular los datos que se van a usar
						//crear los objetos donde guardaremos la informacion
						//que retornemos de la BBDD
	
	public Productos() {
		nombre_articulo = "";
		seccion = "";
		precio = "";
		pais_origen = "";
	}
	
	public String getNombre_articulo() {
		return nombre_articulo;
	}
	public String getSeccion() {
		return seccion;
	}
	public String getPrecio() {
		return precio;
	}
	public String getPais_origen() {
		return pais_origen;
	}
	public void setNombre_articulo(String nombre_articulo) {
		this.nombre_articulo = nombre_articulo;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public void setPais_origen(String pais_origen) {
		this.pais_origen = pais_origen;
	}

	private String nombre_articulo;
	private String seccion;
	private String precio;
	private String pais_origen;
}
