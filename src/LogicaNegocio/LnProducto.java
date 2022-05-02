/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import AccesoDatos.AdProducto;
import Entidades.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class LnProducto {
    
    private String _mensaje;
    
    public String getMensaje(){
    
        return _mensaje;
    }
    
    public List<Producto> ListarRegistros(String condicion) throws Exception{
        
        List<Producto> resultado = new ArrayList();
        
        AdProducto adProducto;
        try{
        
            adProducto = new AdProducto();
            resultado = adProducto.ListarRegistros(condicion);
        }
        catch(Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    
    public Producto ObtenerRegistro(String condicion) throws Exception{
    
        Producto resultado;
        AdProducto adProducto;
        
        try{
            adProducto = new AdProducto();
            resultado = adProducto.ObtenerRegistro(condicion);
            if(resultado.isExiste()){
                _mensaje= "Producto recuperado exitosamente";
            }
            else{
                _mensaje= "El producto no existe";
            }
            
        }catch(Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    
}
