/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion6.integracion.dominio;

/*********************************************************************
* Class Name: Propietario
* Author/s name: Carlos
* Release/Creation date: 4/11/2016
* Class version: 1.0.0
* Class description: Clase que va a representrar al objeto vehiculo
**********************************************************************
*/
public class Vehiculo {

	/**Atributo que almacenara el identificador de la BBDD**/
	private int id;
	private String matricula;
	private char tipovehiculo;
	private int velocidad;
	
	///////////////////
	////Constructor////
	///////////////////
	
	public Vehiculo(int id, String matricula, char tipovehiculo){
		this.id = id;
		this.matricula = matricula;
		this.tipovehiculo = tipovehiculo;
		this.setVelocidad(0);
	}
	public Vehiculo(int id, String matricula, char tipovehiculo, int velocidad){
		this.id = id;
		this.matricula = matricula;
		this.tipovehiculo = tipovehiculo;
		this.setVelocidad(velocidad);
	}

	////////////////////////
	//// Metodo Get-Set ////
	////////////////////////
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public char getTipovehiculo() {
		return tipovehiculo;
	}

	public void setTipovehiculo(char tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
}
