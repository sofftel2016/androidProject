/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion4.pagosancion.dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.radardgt.iteracion4.pagosancion.persistencia.ConexionDB;

public class GestorSancion {

	/**
	 * Busca la sancion correspondiente al propietario suministrado
	 * @param prop
	 * @param bd
	 * @return
	 */
	public static Sancion buscarSancion(Propietario prop, ConexionDB bd){
		String tabla = "SANCIONES", condicion= "id_propietario_vehiculo";
		String sentencia = "SELECT * FROM "+tabla+" WHERE "+condicion+" = "+prop.getId();
		bd.ejecutarConsulta(sentencia);
		ResultSet result = bd.getResultSet();
		Sancion sancion = null;
		try {
			result.next();
			sancion = new Sancion(result.getInt(1),new Expediente(new Radar(result.getString(2))), prop,
					GestorVehiculo.obtenerVehiculo(prop, bd),result.getInt(5),result.getInt(6),result.getInt(7),result.getInt(8));
		} catch (SQLException e) {
			System.out.println("ERROR --> "+e.getMessage());
		}
		return sancion;
	}
	/**
	 * Calcula el coste de la sancion transmitida
	 * @param radar
	 * @param sancion
	 * @return
	 */
	public static int calcularCosteSancion(Radar radar,Expediente sancion){
		int multa=0;
		if(sancion.getVelocidad()<70){
			if(radar.getLimiteExpedienteSancionador()+1<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+20>= sancion.getVelocidad())
				multa=100;
			if(radar.getLimiteExpedienteSancionador()+21<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+30>= sancion.getVelocidad())
				multa=300;
			if(radar.getLimiteExpedienteSancionador()+31<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+40>= sancion.getVelocidad())
				multa=400;
			if(radar.getLimiteExpedienteSancionador()+41<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+50>= sancion.getVelocidad())
				multa=500;
			if(radar.getLimiteExpedienteSancionador()+50< sancion.getVelocidad())
				multa=600;
		}else{
			if(radar.getLimiteExpedienteSancionador()+1<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+30>= sancion.getVelocidad())
				multa=100;
			if(radar.getLimiteExpedienteSancionador()+31<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+50>= sancion.getVelocidad())
				multa=300;
			if(radar.getLimiteExpedienteSancionador()+51<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+60>= sancion.getVelocidad())
				multa=400;
			if(radar.getLimiteExpedienteSancionador()+61<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+70>= sancion.getVelocidad())
				multa=500;
			if(radar.getLimiteExpedienteSancionador()+70< sancion.getVelocidad())
				multa=600;
		}
		return multa;
	}
	/**
	 * Calcula los puntos correspondientes a la sanción pasada
	 * @param radar
	 * @param sancion
	 * @return
	 */
	public static int calcularPuntosSancion(Radar radar,Expediente sancion){
		int puntos = 0;
		if(sancion.getVelocidad()<70){
			if(radar.getLimiteExpedienteSancionador()+21<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+30>= sancion.getVelocidad())
				puntos=2;
			if(radar.getLimiteExpedienteSancionador()+31<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+40>= sancion.getVelocidad())
				puntos=4;
			if(radar.getLimiteExpedienteSancionador()+41<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+50>= sancion.getVelocidad())
				puntos=6;
			if(radar.getLimiteExpedienteSancionador()+50< sancion.getVelocidad())
				puntos=6;
		}else{
			if(radar.getLimiteExpedienteSancionador()+31<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+50>= sancion.getVelocidad())
				puntos=2;
			if(radar.getLimiteExpedienteSancionador()+51<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+60>= sancion.getVelocidad())
				puntos=4;
			if(radar.getLimiteExpedienteSancionador()+61<= sancion.getVelocidad() && radar.getLimiteExpedienteSancionador()+70>= sancion.getVelocidad())
				puntos=6;
			if(radar.getLimiteExpedienteSancionador()+70< sancion.getVelocidad())
				puntos=6;
		}
		return puntos;
	}
	/**
	 * Pasa el expediente a la BBDD
	 * @param sancion
	 * @param db
	 */
	public static void CrearSancion(Sancion sancion, ConexionDB db){
		String nombreTabla="SANCIONES", columnaid="id",colLocRadar="Localizacion_Radar",colPropVehi="id_propietario_vehiculo";
		String col_velsancion="Velocidad_sancion", colfecha="Fecha", colcoste_sanc="Coste_sancion",colpunt_san="puntos_sancion";
		String col_pagada="pagada";
		String sentencia="INSERT INTO "+nombreTabla+" set "+ columnaid+","+colLocRadar+","+colPropVehi+
				","+col_velsancion+","+colfecha+","+colcoste_sanc+","+colpunt_san+","+col_pagada+
				" VALUES ="+sancion.getId()+","+ sancion.getExpediente().getRadar().getLocalizacion()+
				","+sancion.getPropietario().getId()+","+sancion.getExpediente().getVelocidad()+","+
				sancion.getFecha()+","+sancion.getCoste_sancion()+","+sancion.getPuntos_sancion()+","+
				sancion.getPagada();
		db.ejecutarConsulta(sentencia);
		db.commit();
	}

	/**
	 * Actualizaz en la bbdd el pago de la sancion
	 * @param sancion
	 * @param db
	 */
	public static void pagarSancion(Sancion sancion, ConexionDB db){
		sancion.setPagada(1);
		String nombreTabla="SANCIONES", columna ="pagada";
		String sentencia="update "+nombreTabla+" set "+columna+"= 1"+
				" where id ="+sancion.getId();
		db.ejecutarConsulta(sentencia);
		db.commit();
	}
	/**
	 * Resta los puntos del propietario y lo actualiza en la BBDD
	 * @param sancion
	 * @param prop
	 * @param db
	 */
	public static void restarPuntosConductor(Sancion sancion, Propietario prop, ConexionDB db){
		int puntosrestantes = prop.getPuntos()-sancion.getPuntos_sancion();
		prop.setPuntos(puntosrestantes);
		GestorPropietario.modificarPuntos(prop, puntosrestantes, db);
	}
}