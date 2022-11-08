package com.mycompany.auto;

import java.util.ArrayList;
import java.util.List;

public class SolicitudRebajaCommand implements Command{
    
    protected List<Auto> vehiculosARebajar = new ArrayList<>();
    protected List<Auto> vehiculosStock;
    protected long hoy;
    protected long tiempoEnStock;
    protected double tasaDescuento;

    public SolicitudRebajaCommand(long hoy, long tiempoEnStock,
            double tasaDescuento , List<Auto> vehiculosStock) {
        this.vehiculosStock = vehiculosStock;
        this.hoy = hoy;
        this.tiempoEnStock = tiempoEnStock;
        this.tasaDescuento = tasaDescuento;
    }
      @Override
    public void ejecutar() {
        vehiculosARebajar.clear();
        for (Auto vehiculo : vehiculosStock) {
            if (vehiculo.getTiempoEnStock(hoy)
                    >= tiempoEnStock) {
                vehiculosARebajar.add(vehiculo);
            }
        }
        for (Auto vehiculo : vehiculosARebajar) {
            vehiculo.modificaPrecio(1.0 - tasaDescuento);
        }
    }

    public void anula() {
        for (Auto vehiculo : vehiculosARebajar) {
            vehiculo.modificaPrecio(1.0 / (1.0 - tasaDescuento));
        }
    }

    public void restablece() {
        for (Auto vehiculo : vehiculosARebajar) {
            vehiculo.modificaPrecio(1.0 - tasaDescuento);
        }
    }

  
}
