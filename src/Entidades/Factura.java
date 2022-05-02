/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;
import java.time.LocalDate;
/**
 *
 * @author Steven
 */
public abstract class Factura {

    //attributes
    private Date fecha;
    private int id_vendedor;
    private double importe;    
    private double descuento;
    private String estado;
    private String tipo;
    
    //constructors
    public Factura(Date fecha, int id_vendedor, double importe, double descuento ,String estado ,String tipo) {
        this.fecha = fecha;
        this.id_vendedor = id_vendedor;
        this.importe = importe;
        this.descuento = descuento;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Factura() {
        fecha = Date.valueOf(LocalDate.now());
        id_vendedor = 0;
        importe = 0;
        descuento = 0;
        estado = "";
    }
    
    //getters, setters
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
