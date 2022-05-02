/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author Steven
 */
public class Venta extends Factura {

    private int id_venta;
    private int id_cliente;
    private boolean existe;
    
    public Venta(int id_venta, int id_cliente, Date fecha, int id_vendedor, double importe, double descuento,String estado,String tipo) {
        super(fecha, id_vendedor, importe, descuento, estado, tipo);
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.existe = true;
    }
    
    public Venta(){
       super();
       id_venta= 0;
       id_cliente = 0;
       existe = false;
    }
    
    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public boolean isExiste(){
        return existe;
    }
    
    public void setExiste(boolean existe){
        this.existe = existe;
    }
}
