/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion1.cambiopropietariovehiculo.dominio;

import com.radardgt.iteracion1.cambiopropietariovehiculo.persistencia.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/*********************************************************************
* Class Name: GestorVehiculo
* Author/s name: Carlos
* Release/Creation date: 5/11/2016
* Class version: 1.0.0
* Class description: Clase que gestionara todas las acciones relacionadas
* 	con vehiculos
**********************************************************************
*/

public class GestorVehiculo {

	/**
	 * Metodo que actualizara la bbdd con el nuevo propietario del vehiculo pasado
	 * @param prop
	 * @param coche
	 * @param bd
	 */
	public void cambiarPropietario(Propietario prop, Vehiculo coche,ConexionDB bd){
		/*Estas variables seran sustituidas cuando se tenga la BBDD diseñada*/
		String nombreTabla="", columna ="";
		String sentencia="update "+nombreTabla+" set "+columna+"="+prop.getId()+
				" where id_vehiculo ="+coche.getId();
		bd.ejecutarConsulta(sentencia);
		bd.commit();
	}
	/**
	 * Metodo que devuelve un vehiculo segun la matricula pasada
	 * devuelve null en caso de error.
	 * @param matricula
	 * @param bd
	 * @return
	 */
	public Vehiculo obtenerVehiculo(String matricula, ConexionDB bd){
		Vehiculo coche = null;
		/*Estas variables seran sustituidas cuando se tenga la BBDD diseñada*/
		String nombretabla="", colmatricula ="";
		String sentencia ="select * from "+nombretabla+" where "+colmatricula+"="+matricula;
		bd.ejecutarConsulta(sentencia);
		ResultSet result = bd.getResultSet();
		try {
			result.next();
			coche = new Vehiculo(result.getInt(1),result.getString(2), result.getString(3).charAt(0));
		} catch (SQLException e) {
			System.out.println("ERROR --> "+e.getMessage());
		}
		return coche;
	}
}