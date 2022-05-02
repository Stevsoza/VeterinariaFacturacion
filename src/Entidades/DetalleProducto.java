/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Steven
 */
public class DetalleProducto extends Detalle {

    //attributes
    
    private int id_producto;
    
    //constructors
    public DetalleProducto(int id_venta, int id_producto, String descripcion, int cantidad, double descuento, double precio,double total) {
        super(id_venta, descripcion, cantidad, descuento, precio, total);
        this.id_producto = id_producto;
    }
    
    public DetalleProducto(){
        super();
        id_producto = 0;
    }

    //getters and setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
}
