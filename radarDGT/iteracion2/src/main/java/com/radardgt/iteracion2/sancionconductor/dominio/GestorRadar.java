/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion2.sancionconductor.dominio;


import com.radardgt.iteracion2.sancionconductor.persistencia.*;

/*********************************************************************
* Class Name: GestorRadar
* Author/s name: Virginia
* Release/Creation date: 7/11/2016
* Class version: 1.0.0
* Class description: Clase que va a gestionar la sanción del conductor
**********************************************************************
*/

public class GestorRadar {

	public Sancion crearSancion(Vehiculo vehic, Radar radar, ConexionDB db){
		
		Sancion sancion =null;
		String nombreTabla="", columnavehi="",columnaradar="";
		String sentencia="INSERT INTO "+nombreTabla+" set "+ columnavehi+","+columnaradar+
				" VALUES ="+sancion.getMatricula()+","+ sancion.getRadar();
		db.ejecutarConsulta(sentencia);
		db.commit();
		
		return sancion;
	}
	
}