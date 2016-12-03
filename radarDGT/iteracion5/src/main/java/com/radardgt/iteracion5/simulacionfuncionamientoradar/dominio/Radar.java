/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion5.simulacionfuncionamientoradar.dominio;

/*********************************************************************
* Class Name: Radar
* Author/s name: Virginia
* Release/Creation date: 6/11/2016
* Class version: 1.0.0
* Class description: Clase que va a representrar al objeto radar
**********************************************************************
*/

public class Radar {

	/**Atributo que va a contener el identificador de la BBDD**/
	private int id;
	private String localizacion;
	private int limiteExpedienteSancionador;
	
	///////////////////
	////Constructor////
	///////////////////
	
	public Radar(int id, String localizacion, int limiteExpedienteSancionador){
		this.id = id;
		this.localizacion= localizacion;
		this.limiteExpedienteSancionador=limiteExpedienteSancionador;
	}
	public Radar(String localizacion){
		this.localizacion = localizacion;
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
	
	/**Devuelve el valor del atributo localizacion**/
	
	public String getLocalizacion() {
		return localizacion;
	}
	
	/**Modifica el valor del atributo localizacion**/
	
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	/**Devuelve el valor del atributo limiteExpedienteSancionador**/
	
	public int getLimiteExpedienteSancionador() {
		return limiteExpedienteSancionador;
	}
	
	/**Modifica el valor del atributo limiteExpedienteSancionador**/
	
	public void setLimiteExpedienteSancionador(int limiteExpedienteSancionador) {
		this.limiteExpedienteSancionador = limiteExpedienteSancionador;
	}
	
}
