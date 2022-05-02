/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import AccesoDatos.AdVendedor;
import Entidades.Vendedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class LnVendedor {
    
    private String _mensaje;
    
    public String getMensaje(){
    
        return _mensaje;
    }
    
    public List<Vendedor> ListarRegistros(String condicion) throws Exception{
        
        List<Vendedor> resultado = new ArrayList();
        
        AdVendedor adVendedor;
        try{
        
            adVendedor = new AdVendedor();
            resultado = adVendedor.ListarRegistros(condicion);
        }
        catch(Exception ex)
        {
            throw ex;
        }
        return resultado;
    }
    
}
