/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.auto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Catalogo {

    protected List<Auto> vehiculosStock   = new ArrayList<>();;
    protected List<SolicitudRebajaCommand> solicitudes
            = new ArrayList<>();


    
    public void ejecutaSolicitudRebaja(SolicitudRebajaCommand solicitud) {
        solicitudes.add(0, solicitud);
        //solicitud.rebaja(vehiculosStock);
        solicitud.ejecutar();
    }

    public void anulaSolicitudRebaja(int orden) {
        solicitudes.get(orden).anula();
    }

    public void restableceSolicitudRebaja(int orden) {
        solicitudes.get(orden).restablece();
    }

    public void agrega(Auto vehiculo) {
        vehiculosStock.add(vehiculo);
    }
    
    public String contenidoDelCatalogo(){
        String s="";
         for (Auto vehiculo : vehiculosStock) {
            s = s + vehiculo.toString() + "\n";
        }
        return s;
    }
    

    public void visualiza() {
        for (Auto vehiculo : vehiculosStock) {
            System.out.println(vehiculo.toString())
            ;
        }
    }
}
