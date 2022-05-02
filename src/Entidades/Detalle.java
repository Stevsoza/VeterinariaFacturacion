/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Steven
 */
public abstract class Detalle {
    
    //attributes
    private int id_venta;
    private String descripcion;
    private int cantidad;
    private double descuento;
    private double precio;
    private double total;
    private boolean existe;
    
    //constructors

    public Detalle(int id_venta,String descripcion, int cantidad, double descuento, double precio, double total) {
        this.id_venta = id_venta;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.precio = precio;
        this.total = total;
        this.existe = true;
    }
    
    public Detalle(){
        id_venta = 0;
        descripcion = "";
        cantidad = 0;
        descuento = 0;
        precio = 0;
        total = 0;
        existe = false;
    }

    
    //getters and setters
    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
}
