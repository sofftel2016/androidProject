package com.radardgt.iteracion5.simulacionfuncionamientoradar.dominio;

import com.radardgt.iteracion5.simulacionfuncionamientoradar.persistencia.ConexionDB;

public class GestorExpediente {

	/**
	 * Crea un expediente en la bbdd datos ademas de devolverlo.
	 * @param radar
	 * @param v
	 * @param velocidad
	 * @param bbdd
	 * @return
	 */
	public Expediente crearExpediente(Radar radar, Vehiculo v, int velocidad, ConexionDB bbdd){
		String nombreTabla="EXPEDIENTES", columnaid="id",colmatricula="matricula",colRadar="id_radar";
		String col_velcoche="Velocidad_coche";
		int id = bbdd.proximoIDDisponible("id","EXPEDIENTES");
		String sentencia="INSERT INTO "+nombreTabla+" set "+ columnaid+","+colmatricula+","+colRadar+
				","+col_velcoche+" VALUES ="+id+","+ v.getMatricula()+
				","+radar.getId()+","+velocidad;
		bbdd.ejecutarConsulta(sentencia);
		bbdd.commit();
		return new Expediente(id,v.getMatricula(),radar,velocidad);
	}
	/**
	 * Crea un expediente pasado en la bbdd
	 * @param e
	 * @param bbdd
	 */
	public void crearExpediente(Expediente e, ConexionDB bbdd){
		String nombreTabla="EXPEDIENTES", columnaid="id",colmatricula="matricula",colRadar="id_radar";
		String col_velcoche="Velocidad_coche";
		String sentencia="INSERT INTO "+nombreTabla+" set "+ columnaid+","+colmatricula+","+colRadar+
				","+col_velcoche+" VALUES ="+e.getId()+","+ e.getMatricula()+
				","+e.getRadar().getId()+","+e.getVelocidad();
		bbdd.ejecutarConsulta(sentencia);
		bbdd.commit();
	}
}
