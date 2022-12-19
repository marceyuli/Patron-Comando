package com.mycompany.auto;

public class Auto {
     protected String nombre;
     protected long fechaEntradaStock;
     private double precioVenta;

    public Auto(String nombre, long fechaEntradaStock, double precioVenta) {
        this.nombre = nombre;
        this.fechaEntradaStock = fechaEntradaStock;
        this.precioVenta = precioVenta;
    }
     
     public long getTiempoEnStock(long hoy){
         return hoy - fechaEntradaStock;
     }
     public void modificaPrecio (double coeficiente){
         this.precioVenta = 0.01 * Math.round(coeficiente * this.precioVenta * 100);
     }

    @Override
    public String toString() {
        return "Auto{" + "nombre=" + nombre + ", fechaEntradaStock=" + fechaEntradaStock + ", precioVenta=" + precioVenta + '}';
    }
    
    public Memento takeSnaphot() {
        return new Memento(this.precioVenta);
    }
    
    public void restore (Memento memento){
        this.precioVenta = memento.getPrecioVenta();
    }
    public static class Memento {
        private final double precioVenta;
        
        private Memento(double precioAGuardar){
            precioVenta = precioAGuardar;
        }
        
        private double getPrecioVenta(){
            return precioVenta;
        }
    }
}
