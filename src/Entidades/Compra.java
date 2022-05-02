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
public class Compra extends Factura {

    private int id_compra;
    private int id_proveedor;
    private boolean existe;
    
    public Compra(int id_compra, int id_proveedor, Date fecha, int id_vendedor, double importe, double descuento, String estado ,String tipo) {
        super(fecha, id_vendedor, importe, descuento, estado, tipo);
        this.id_compra = id_compra;
        this.id_proveedor = id_proveedor;
        this.existe = true;
    }

    public Compra() {
        super();
        id_compra = 0;
        id_proveedor = 0;
        existe=false;
    }
    
    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    public boolean isExiste(){
        return existe;
    }
    
    public void setExiste(boolean existe){
        this.existe= existe;
    }
}
