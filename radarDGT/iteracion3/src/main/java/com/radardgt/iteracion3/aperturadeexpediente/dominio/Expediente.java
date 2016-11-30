/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion3.aperturadeexpediente.dominio;

/*********************************************************************
* Class Name: Sancion
* Author/s name: Virginia
* Release/Creation date: 6/11/2016
* Class version: 1.0.0
* Class description: Clase que va a representrar al objeto sancion
**********************************************************************
*/

public class Expediente {

	private int id;
	private String matricula;
	private Radar radar;
	private int velocidad_coche;
	
	///////////////////
	////Constructor////
	///////////////////
	
	public Expediente(int id, String matricula, Radar radar, int velocidad){
		
		this.id=id;
		this.matricula=matricula;
		this.radar=radar;
		this.velocidad_coche = velocidad;
	}

	/////////////////////////
	////Metodos Get-Set ////
	/////////////////////////
	
	/**Devuelve el valor del atributo id**/
	public int getId() {
		return id;
	}

	/**Modifica el valor del atributo id**/
	public void setId(int id) {
		this.id = id;
	}

	/**Devuelve el valor del atributo matricula**/
	public String getMatricula() {
		return matricula;
	}

	/**Modifica el valor del atributo matricula**/
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**Devuelve el valor del atributo radar**/
	public Radar getRadar() {
		return radar;
	}

	/**Modifica el valor del atributo radar**/
	public void setRadar(Radar radar) {
		this.radar = radar;
	}

	public int getVelocidad() {
		return velocidad_coche;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad_coche = velocidad;
	}
	
}
