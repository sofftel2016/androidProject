/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radardgt.iteracion5.simulacionfuncionamientoradar.dominio;


import java.util.Random;

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
	
}