package com.radardgt.iteracion5.simulacionfuncionamientoradar.dominio;




/*********************************************************************
* Class Name: Expediente
* Author/s name: Carlos
* Release/Creation date: 8/11/2016
* Class version: 1.0.0
* Class description: Clase que almacenara los datos de los expedientes
**********************************************************************
*/
public class Sancion {

	private int id;
	private Expediente expediente;
	private Propietario propietario;
	private Vehiculo vehiculo;
	private int fecha;
	private int coste_sancion;
	private int puntos_sancion;
	/**Donde 0 significa que no esta pagada
	 * y 1 que esta pagada*/
	private int pagada;
	
	///////////////////
	////Constructor////
	///////////////////
	
	public Sancion(int id, Expediente expediente, Propietario propietario, Vehiculo vehiculo, int fecha,
			int coste_sancion, int puntos_sancion, int pagada) {
		this.id = id;
		this.expediente = expediente;
		this.propietario = propietario;
		this.vehiculo = vehiculo;
		this.fecha = fecha;
		this.coste_sancion = coste_sancion;
		this.puntos_sancion = puntos_sancion;
		this.setPagada(pagada);
	}
	
	///////////////////////
	////Metodos get-set////
	///////////////////////
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public int getCoste_sancion() {
		return coste_sancion;
	}
	public void setCoste_sancion(int coste_sancion) {
		this.coste_sancion = coste_sancion;
	}
	public int getPuntos_sancion() {
		return puntos_sancion;
	}
	public void setPuntos_sancion(int puntos_sancion) {
		this.puntos_sancion = puntos_sancion;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public int getPagada() {
		return pagada;
	}

	public void setPagada(int pagada) {
		this.pagada = pagada;
	}
	
}
