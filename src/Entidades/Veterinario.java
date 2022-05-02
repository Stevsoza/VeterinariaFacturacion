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
public class Veterinario extends Persona{
    
    //attributes
    private int id_veterinario;
    private boolean existe;
    
    //constructor
    public Veterinario(int id_veterinario,String nombre, String apellido1, String apellido2, Date fechaNacimiento, String telefono, String email){
        super(nombre, apellido1, apellido2, fechaNacimiento, telefono, email);
        this.id_veterinario = id_veterinario;
        this.existe = true;
    }
    
    public Veterinario(){
        super();
        id_veterinario = 0 ;
        existe = false;
    }
    
    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public boolean isExiste() {
        return existe;
    }
    
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
}
