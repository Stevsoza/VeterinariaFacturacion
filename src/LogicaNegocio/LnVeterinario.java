/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import AccesoDatos.AdVeterinario;
import Entidades.Veterinario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class LnVeterinario {
    private String _mensaje;
    
    public String getMensaje(){
    
        return _mensaje;
    }
    
    
    public List<Veterinario> ListarRegistros(String condicion) throws Exception{
        
        List<Veterinario> resultado = new ArrayList();
        
        AdVeterinario adVeterinario;
        try{
        
            adVeterinario = new AdVeterinario();
            resultado = adVeterinario.ListarRegistros(condicion);
        }
        catch(Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    
    public Veterinario ObtenerRegistro(String condicion) throws Exception{
    
        Veterinario resultado;
        AdVeterinario adVeterinario;
        
        try{
            adVeterinario = new AdVeterinario();
            resultado = adVeterinario.ObtenerRegistro(condicion);
            if(resultado.isExiste()){
                _mensaje= "Veterinario recuperado exitosamente";
            }
            else{
                _mensaje= "El Veterinario no existe";
            }
            
        }catch(Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
}
