package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import modelo.Ejecuta_Consultas;
import vista.Marco_Aplicacion2;

public class Evento_Boton_Consulta implements ActionListener {
	
	public Evento_Boton_Consulta(Marco_Aplicacion2 elmarco) {
		this.elMarco = elmarco;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String seleccionSeccion = (String) elMarco.secciones.getSelectedItem();
		String seleccionPais = (String) elMarco.paises.getSelectedItem();
		
		rs = obj.filtraBBDD(seleccionSeccion, seleccionPais);//llama función que regresa datos dela BBDD(query), se almacena en RS
		
		try {
			
			elMarco.resultado.setText("");
			//System.out.println("aqui");
			if (rs.next()==false) {
				System.out.println("No trae nada");
				elMarco.resultado.setText("No hay resultados");
			} else {
				
				do{
					
					//System.out.println("puto");
					elMarco.resultado.append(rs.getString(1));
					elMarco.resultado.append(", ");
					
					elMarco.resultado.append(rs.getString(2));
					elMarco.resultado.append(", ");
					
					elMarco.resultado.append(rs.getString(3));
					elMarco.resultado.append(", ");
					
					elMarco.resultado.append(rs.getString(4));
					elMarco.resultado.append("\n");
				}while (rs.next());
			}
		}catch (Exception e2) {
			// TODO: handle exception
		}
	}

	private Marco_Aplicacion2 elMarco;
	Ejecuta_Consultas obj = new Ejecuta_Consultas();
	private ResultSet rs;
}
