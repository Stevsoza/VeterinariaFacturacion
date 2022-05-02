/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import AccesoDatos.AdVenta;
import Entidades.Venta;

/**
 *
 * @author Steven
 */
public class LnVenta {
    private String _mensaje;
    
    public String getMensaje(){
    
        return _mensaje;
    }
    
    public int Insertar(Venta venta) throws Exception{
    
        int id = -1;
        AdVenta adventa;
        
        try{
            adventa = new AdVenta();
            id = adventa.Insertar(venta);
            _mensaje = adventa.getMensaje();
        }
        catch(Exception ex){
            throw ex;
        }
        return id;
    }
}
