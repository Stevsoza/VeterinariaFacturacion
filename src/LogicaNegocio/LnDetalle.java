/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import AccesoDatos.AdDetalle;
import Entidades.DetalleProducto;
import Entidades.DetalleServicio;

/**
 *
 * @author Steven
 */
public class LnDetalle {
    
    private String _mensaje;
    
    public String getMensaje(){
    
        return _mensaje;
    }
    
    
    public int insertarDetalleS(DetalleServicio dServicio) throws Exception{
    
        int id = -1;
        AdDetalle adDetalle;
        
        try{
            adDetalle = new AdDetalle();
            id = adDetalle.insertarDetalleS(dServicio);
            _mensaje = adDetalle.getMensaje();
        }
        catch(Exception ex){
            throw ex;
        }
        return id;
    }
    
    public int insertarDetalleP(DetalleProducto dProducto) throws Exception{
    
        int id = -1;
        AdDetalle adDetalle;
        
        try{
            adDetalle = new AdDetalle();
            id = adDetalle.insertarDetalleP(dProducto);
            _mensaje = adDetalle.getMensaje();
        }
        catch(Exception ex){
            throw ex;
        }
        return id;
    }
}
