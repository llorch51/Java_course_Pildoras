package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.Carga_Info;
import vista.Marco_Aplicacion2;

public class Evento_CargaInfo extends WindowAdapter{
	
	public Evento_CargaInfo(Marco_Aplicacion2 elMarco) {
		this.elMarco = elMarco;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		objCarga_Secciones.ejecutaConsultas();
		
		try {
			
			while (objCarga_Secciones.rs.next()){
				elMarco.secciones.addItem(objCarga_Secciones.rs.getString(1));
			}//next del ResultSet que se ejecuta por
												//por metodo 'ejecutaConsultas' del objeto
												//de clase 'CargaSecciones'
			
			while (objCarga_Secciones.rs2.next()) {
				elMarco.paises.addItem(objCarga_Secciones.rs2.getString(1));
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	Carga_Info objCarga_Secciones = new Carga_Info();//para acceder a metodo 'ejecutaConsultas'-Otra clase- paqete 'Evento_'
	private Marco_Aplicacion2 elMarco;//para acceder al comboBox de las secciones- Otra clase-paqete Vista
}
