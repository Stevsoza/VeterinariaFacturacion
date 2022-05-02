/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import AccesoDatos.AdAnimal;
import Entidades.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class LnAnimal {
    
    private String _mensaje;
    
    public String getMensaje(){
    
        return _mensaje;
    }
    
    public List<Animal> ListarRegistros(String condicion) throws Exception{
        
        List<Animal> resultado = new ArrayList();
        
        AdAnimal adAnimal;
        try{
        
            adAnimal = new AdAnimal();
            resultado = adAnimal.ListarRegistros(condicion);
        }
        catch(Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    
    public Animal ObtenerRegistro(String condicion) throws Exception{
    
        Animal resultado;
        AdAnimal adAnimal;
        
        try{
            adAnimal = new AdAnimal();
            resultado = adAnimal.ObtenerRegistro(condicion);
            if(resultado.isExiste()){
                _mensaje= "Animal recuperado exitosamente";
            }
            else{
                _mensaje= "El animal no existe";
            }
            
        }catch(Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    
}
