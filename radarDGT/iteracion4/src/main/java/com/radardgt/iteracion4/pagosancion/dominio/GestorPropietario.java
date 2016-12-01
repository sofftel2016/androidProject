/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion4.pagosancion.dominio;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.radardgt.iteracion4.pagosancion.persistencia.ConexionDB;

/*********************************************************************
* Class Name: GestorPropietario
* Author/s name: Carlos
* Release/Creation date: 8/11/2016
* Class version: 1.0.0
* Class description: Clase que gestiona los objetos propietario
**********************************************************************
*/
public class GestorPropietario {

	/**
	 * actualiza los puntos del propietario en la bbdd
	 * @param prop
	 * @param puntos
	 */
	public static void modificarPuntos(Propietario prop, int puntos, ConexionDB db){
		String nombreTabla="PROPIETARIOS", columna ="Puntos";
		String sentencia="update "+nombreTabla+" set "+columna+" = "+puntos+
				" where id ="+prop.getId();
		db.ejecutarConsulta(sentencia);
		db.commit();
	}
	/**
	 * Devuelve el Propietario solicitado de la BBDD
	 * @param sentencia
	 * @param bd
	 * @return
	 */
	public static Propietario buscarProp(String sentencia, ConexionDB bd){
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
}
