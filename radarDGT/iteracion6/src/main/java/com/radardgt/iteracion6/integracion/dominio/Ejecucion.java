/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion6.integracion.dominio;


import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import com.radardgt.iteracion6.integracion.persistencia.*;

/*********************************************************************
* Class Name: GestorPropietario_version1.2
* Se ha añadido un nuevo método a esta clase
* Author/s name: Luis
* Release/Creation date: 21/11/2016
* Class version: 1.1.0
* Class description: Clase que CREA LA EJECUCION
**********************************************************************
*/
public class Ejecucion {
    /**
     * Inicio la conexion
     */
    ConexionDB bbdd;
    GestorRadar radar;
    GestorVehiculo gv;
    GestorPropietario gp;
    GestorSancion gs;
    // Creo radares
    // Creo Vehiculos
    // Compruebo
    public Ejecucion(){
        // Crear Conexion bd
        bbdd=new ConexionDB("Oracle","localhost","oradev","LUIS","3907");
        radar=new GestorRadar();
        gv=new GestorVehiculo();
        gs=new GestorSancion();
        Vehiculo[] v;
        Radar[] r;
        boolean terminar=false;
        r=radar.iniciarRadares();
        while(!terminar){
            v=gv.crearVehiculos(bbdd);
            GenerarSanciones(r,v);
        }
        
        
    }
    
    public void GenerarSanciones(Radar[] radares, Vehiculo[] vehiculos){
        // Comprobar coche
        for(int i=0; i<radares.length;i++){
            for (int j=0; j<radares.length;j++){
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(radares[i].getLimiteExpedienteSancionador()>vehiculos[j].getVelocidad()){
                	int fecha=0;
                    Expediente e=new Expediente(bbdd.proximoIDDisponible("id","EXPEDIENTES"),vehiculos[j].getMatricula(),radares[i],vehiculos[j].getVelocidad());
                    Sancion s=new Sancion(bbdd.proximoIDDisponible("id","SANCIONES"),e,gp.DevolverPropietario(vehiculos[j], bbdd),vehiculos[j],fecha,0,0,0);
                    int coste=gs.calcularCosteSancion(e);
                    int puntos=gs.calcularPuntosSancion(e);
                    s.setCoste_sancion(coste);
                    if((s.getPropietario().getPuntos()-puntos)<0) {
                        JOptionPane.showMessageDialog(null, "Error al restar puntos", "Restar Puntos", JOptionPane.ERROR_MESSAGE);
                    }
                    gs.restarPuntosConductor(s, gp, bbdd);
                    gs.CrearSancion(s, bbdd);
                }
            }
        }
    }
}
