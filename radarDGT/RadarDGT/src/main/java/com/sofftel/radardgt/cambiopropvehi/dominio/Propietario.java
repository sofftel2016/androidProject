/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofftel.radardgt.cambiopropvehi.dominio;

/*********************************************************************
* Class Name: Propietario
* Author/s name: Carlos
* Release/Creation date: 8/11/2016
* Class version: 1.1.0
* Class description: Clase que va a representrar al objeto propietario
**********************************************************************
*/
public class Propietario {
	/**Atributo que va a contener el identificador de la BBDD**/
	private int id;
	private String dni;
	private String nombre;
	private String apellido1;
	private String direccion;
	private int telefono;
	private int puntos;
	
	///////////////////
	////Constructor////
	///////////////////
	
	public Propietario(int id, String dni, String nombre, String apellido1, String direccion, int telefono, int puntos){
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.direccion = direccion;
		this.telefono = telefono;
		this.puntos = puntos;
	}
	
	/////////////////////////
	//// Metodos Get-Set ////
	/////////////////////////
	/**
	 * Devuelve el valor del atributo id
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Modifica el valor del atributo id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Devuelve el valor del atributo dni
	 * @return
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Modifica el valor del atributo DNI
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Devuelve el valor del atributo nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Modifica el valor del atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve el valor del atributo apellido1
	 * @return
	 */
	public String getApellido1() {
		return apellido1;
	}
	/**
	 * Modifica el valor del atributo apellido1
	 * @param apellido1
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	/**
	 * Devuelve el valor del atributo direccion
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Modifica el valor del atributo direccion
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Devuelve el valor del atributo telefono
	 * @return
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * Modifica el valor del atributo telefono
	 * @param telefono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * Devuelve el valor del atributo puntos
	 * @return
	 */
	public int getPuntos(){
		return this.puntos;
	}
	/**
	 * Modifica el valor del atributo telefono
	 * @param telefono
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
