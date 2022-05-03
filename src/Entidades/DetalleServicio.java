/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Steven
 */
public class DetalleServicio extends Detalle {
    
    //attributes
    private int id_servicio;
    private int id_veterinario;
    private int id_animal;
    
    //constructors
    public DetalleServicio(int id_servicio, String descripcion,int id_veterinario, int id_animal, int id_venta, int cantidad, double descuento, double precio, double total) {
        super(id_venta, descripcion, cantidad, descuento, precio, total);
        this.id_servicio = id_servicio;
        this.id_veterinario = id_veterinario;
        this.id_animal = id_animal;
    }
    
    public DetalleServicio(){
        super();
        id_servicio = 0;
        id_veterinario = 0;
        id_animal = 0;
    }
    
    //getters and setters

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }
    
}
