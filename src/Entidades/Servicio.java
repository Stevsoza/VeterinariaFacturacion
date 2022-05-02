/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Steven
 */
public class Servicio {

    private int id_servicio;
    private String descripcion;
    private double precio;
    private double descuento;
    private boolean existe;
    
    public Servicio(int id_servicio, String descripcion, double precio, double descuento) {
        this.id_servicio = id_servicio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.existe = true;
    }
    
    public Servicio(){
        id_servicio = 0;
        descripcion = "";
        precio = 0;
        descuento = 0;
        existe = false;
    }
    
    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public boolean isExiste(){
        return existe;
    }
    
    public void setExiste(boolean existe){
        this.existe = existe;
    }
    
    public double getDescuento(){
        return descuento;
    }
    
    public void setDescuento(double descuento){        
        this.descuento = descuento;
    }
}
