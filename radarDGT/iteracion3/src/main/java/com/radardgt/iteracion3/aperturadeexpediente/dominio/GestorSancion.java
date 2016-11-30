/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion3.aperturadeexpediente.dominio;

import com.radardgt.iteracion3.aperturadeexpediente.persistencia.ConexionDB;

public class GestorSancion {

	/**
	 * Calcula el coste de la sancion transmitida
	 * @param radar
	 * @param sancion
	 * @return
	 */
	public int calcularCosteSancion(Radar radar,Expediente sancion){
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
	public int calcularPuntosSancion(Radar radar,Expediente sancion){
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
	public void CrearSancion(Sancion sancion, ConexionDB db){
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
}