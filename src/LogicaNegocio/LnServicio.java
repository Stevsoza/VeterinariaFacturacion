/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import AccesoDatos.AdServicio;
import Entidades.Servicio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class LnServicio {
    
    private String _mensaje;
    
    public String getMensaje(){
    
        return _mensaje;
    }
    
    public List<Servicio> ListarRegistros(String condicion) throws  Exception{
        List<Servicio> lista = new ArrayList<>();
        
        AdServicio adServicio;
        
        try{
            adServicio = new AdServicio();
            lista = adServicio.ListarRegistros(condicion);
        }catch(Exception ex){
            throw ex;
        }
        return lista;
    }
    
    public Servicio ObtenerRegistro(String condicion) throws Exception{
    
        Servicio resultado;
        AdServicio adServicio;
        
        try{
            adServicio = new AdServicio();
            resultado = adServicio.ObtenerRegistro(condicion);
            if(resultado.isExiste()){
                _mensaje= "Servicio recuperado exitosamente";
            }
            else{
                _mensaje= "El Servicio no existe";
            }
            
        }catch(Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
}
