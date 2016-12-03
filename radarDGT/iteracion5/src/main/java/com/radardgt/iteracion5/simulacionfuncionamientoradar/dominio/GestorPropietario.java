package com.radardgt.iteracion5.simulacionfuncionamientoradar.dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.radardgt.iteracion5.simulacionfuncionamientoradar.persistencia.ConexionDB;

/*********************************************************************
* Class Name: GestorPropietario_version1.2
* Se ha añadido un nuevo método a esta clase
* Author/s name: Luis
* Release/Creation date: 21/11/2016
* Class version: 1.3.0
* Class description: Clase que gestiona los objetos propietario
**********************************************************************
*/
public class GestorPropietario {

	/**
	 * Devuelve el Propietario solicitado de la BBDD
	 * @param sentencia
	 * @param bd
	 * @return
	 */
	public Propietario buscarProp(String sentencia, ConexionDB bd){
		bd.ejecutarConsulta(sentencia);
		ResultSet result = bd.getResultSet();
		Propietario prop=null;
		try {
			result.next();
			prop = new Propietario(result.getInt(1), result.getString(2),
					result.getString(3), result.getString(4), result.getString(5),
					result.getInt(6), result.getInt(7));
		} catch (SQLException e) {
			System.out.println("ERROR --> "+e.getMessage());
		}
		return prop;
	}
	/**
	 * En base a un vehiculo dado obtiene de la bbdd el propietario
	 * de dicho vehiculo
	 * @param v
	 * @param bd
	 * @return
	 */
	public Propietario DevolverPropietario(Vehiculo v,ConexionDB bd){
        Propietario propietario = null;
		String nombretabla="PROPIETARIO", id ="id";
		String sentencia ="select * from "+nombretabla+" where "+id+"=(select DNI_PROPIETARIO from PROPIETARIOS_VEHICULOS where MATRICULA_VEHICULO='"+v.getMatricula()+"')";
                bd.ejecutarConsulta(sentencia);
		ResultSet result = bd.getResultSet();
		try {
			result.next();
			propietario = new Propietario(result.getInt(1),result.getString(2), result.getString(3),
                                result.getString(4),result.getString(5),result.getInt(6),result.getInt(7));
		}catch (SQLException e) {
			System.out.println("ERROR --> "+e.getMessage());
		}
		return propietario;
	}
	/**
	 * actualiza los puntos del propietario en la bbdd
	 * @param prop
	 * @param puntos
	 */
	public void modificarPuntos(Propietario prop, int puntos, ConexionDB db){
		String nombreTabla="PROPIETARIOS", columna ="Puntos";
		String sentencia="update "+nombreTabla+" set "+columna+" = "+puntos+
				" where id ="+prop.getId();
		db.ejecutarConsulta(sentencia);
		db.commit();
	}
	
	public void PagarSancion(Sancion sancion, int pagado){
		sancion.setPagada(pagado);	
	}
        
	
        
}