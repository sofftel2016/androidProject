/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion6.integracion.dominio;


import static java.lang.Thread.sleep;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.radardgt.iteracion6.integracion.persistencia.ConexionDB;

/*********************************************************************
* Class Name: GestorRadar
* se ha añadido un nuevo metodo
* Author/s name: Luis
* Release/Creation date: 21/11/2016
* Class version: 1.2.0
* Class description: Clase que va a gestionar el radar de nuestro sistema
**********************************************************************
*/

public class GestorRadar {
        public GestorRadar(){
        	
        }
        
        public Radar[] iniciarRadares(){
            Random rd=new Random();
            Radar[] radares= new Radar[9];
            int[] limites={30,40,50,60,70,80,90,100,110,120};
            String[] localizacion={"Poblacion","Carretera Nacional", "Autovia"};
            // Llenar vector
            for (int i=0; i<radares.length; i++){
                int n=rd.nextInt(limites.length-1);
                if(n<=2){
                    radares[i]=new Radar(i,localizacion[0],limites[n]);
                }else if(n>=3 && n<=6){
                    radares[i]=new Radar(i,localizacion[1],limites[n]);
                }else if(n>=7){
                    radares[i]=new Radar(i,localizacion[2],limites[n]);
                }
            }
                
            return radares;
        }
        
        public void GenerarSanciones(ConexionDB bbdd,Radar[] radares, Vehiculo[] vehiculos, GestorSancion gs,GestorPropietario gp, DefaultTableModel tabla){
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
                        Expediente e=new Expediente(bbdd.proximoIDDisponible("ID","SANCIONES"),vehiculos[j].getMatricula(),radares[i],vehiculos[j].getVelocidad());
                        Sancion s=new Sancion(bbdd.proximoIDDisponible("ID","SANCIONES"),e,gp.DevolverPropietario(vehiculos[j], bbdd),vehiculos[j],fecha,0,0,0);
                        System.out.println("Hola");
                        int coste=gs.calcularCosteSancion(e);
                        int puntos=gs.calcularPuntosSancion(e);
                        s.setCoste_sancion(coste);
                       // if((s.getPropietario().getPuntos()-puntos)<0) {
                         //   JOptionPane.showMessageDialog(null, "Error al restar puntos", "Restar Puntos", JOptionPane.ERROR_MESSAGE);
                        //}
                        String rowData[]=new String[3];
                        rowData[0]=e.getMatricula();
                        rowData[1]=e.getVelocidad()+"";
                        rowData[2]=s.getPropietario().getNombre();
                        gs.restarPuntosConductor(s, gp, bbdd);
                        gs.CrearSancion(s, bbdd);
                        tabla.addRow(rowData);
                    }
                }
            }
        }
	
}