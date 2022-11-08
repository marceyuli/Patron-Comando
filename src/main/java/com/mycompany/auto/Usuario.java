package com.mycompany.auto;

public class Usuario {

    public static void main(String[] args) {
        Auto vehiculo1 = new Auto("A01", 1, 1000.0);        
        Auto vehiculo2 = new Auto("A11", 6, 2000.0);
        Auto vehiculo3 = new Auto("Z03", 2, 3000.0);
        Catalogo catalogo = new Catalogo();
        catalogo.agrega(vehiculo1);
        catalogo.agrega(vehiculo2);
        catalogo.agrega(vehiculo3);
        System.out.println("Visualizacion inicial del catalogo");
        catalogo.visualiza();
        System.out.println();
        SolicitudRebajaCommand solicitudRebaja = new SolicitudRebajaCommand(10, 5, 0.1, catalogo.vehiculosStock);
        catalogo.ejecutaSolicitudRebaja(solicitudRebaja);
        System.out.println("Visualizacion del catalogo tras ejecutar la primera solicitud");
        catalogo.visualiza();
        System.out.println();
        SolicitudRebajaCommand solicitudRebaja2 = new SolicitudRebajaCommand(10, 5, 0.5, catalogo.vehiculosStock);
        catalogo.ejecutaSolicitudRebaja(solicitudRebaja2);
        System.out.println("Visualizacion del catalogo tras "
                + "ejecutar la segunda solicitud");
        catalogo.visualiza();
        System.out.println();
        catalogo.anulaSolicitudRebaja(1);
        System.out.println("Visualizacion del catalogo tras "
                + "anular la primera solicitud");
        catalogo.visualiza();
        System.out.println();
        catalogo.restableceSolicitudRebaja(1);
        System.out.println("Visualizacion del catalogo tras "
                + "restablecer la primera solicitud");
        catalogo.visualiza();
        catalogo.visualiza();
        System.out.println();
    }
}
