package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ejecuta_Consultas {
	
	public Ejecuta_Consultas() {
		miConexion = new Conexion();
	}
	
	public ResultSet filtraBBDD(String seccion, String pais) {//regrer� RS(tabla) con los datos del query 
		//pruebas = "";
		rs = null;
		Connection conecta = miConexion.dameConexion();
		
		try {
		
			if (!seccion.equals("Todos") && pais.equals("Todos")) {
				//pruebas = "seccion";
				enviaConsultaPS = conecta.prepareStatement(querySeccion);
				enviaConsultaPS.setString(1, seccion);
				
				rs = enviaConsultaPS.executeQuery();
				
			}else if (seccion.equals("Todos") && !pais.equals("Todos")) {
				//pruebas = "pais";
				enviaConsultaPS = conecta.prepareStatement(queryPais);
				enviaConsultaPS.setString(1, pais);
				
				rs = enviaConsultaPS.executeQuery();
				
			}else if (!seccion.equals("Todos") && !pais.equals("Todos")) {
				//pruebas = "ambas";
				enviaConsultaPS = conecta.prepareStatement(queryAmbos);
				enviaConsultaPS.setString(1, seccion);
				enviaConsultaPS.setString(2, pais);
				
				rs = enviaConsultaPS.executeQuery();
				
			}else if (seccion.equals("Todos") && pais.equals("Todos")) {
				//pruebas = "No has escogido";
				enviaConsultaPS = conecta.prepareStatement(queryFull);
				
				rs = enviaConsultaPS.executeQuery();
			}
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}
	
	
	//private String pruebas;
	private Conexion miConexion;
	private ResultSet rs;
	private PreparedStatement enviaConsultaPS;
	private final String querySeccion = "SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS"
			+ " WHERE SECCI�N=?";//***AGUAS CON LOS ESPACIOS EN EL QUERY**** 
	private final String queryPais = "SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS"
			+ " WHERE PA�SDEORIGEN=?";
	private final String queryAmbos = "SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS"
			+ " WHERE SECCI�N=? AND PA�SDEORIGEN=?";
	
	private final String queryFull = "SELECT NOMBREART�CULO, SECCI�N, PRECIO, PA�SDEORIGEN FROM PRODUCTOS"
			+ " ORDER BY PA�SDEORIGEN";

}
