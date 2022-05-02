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
public class Vendedor extends Persona {

    private int id_vendedor;
    private boolean existe;
    
    public Vendedor(int id_vendedor, String nombre, String apellido1, String apellido2, Date fechaNacimiento, String telefono, String email) {
        super(nombre,apellido1,apellido2,fechaNacimiento,telefono,email);
        this.id_vendedor = id_vendedor;
        this.existe = true;
    }
    
    public Vendedor(){
        super();
        id_vendedor = 0;
        existe = false;
    }
    
    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
}
