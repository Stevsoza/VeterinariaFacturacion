/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Config.Config;
import Entidades.Servicio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class AdServicio {
    private Connection _cnn;
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    //constructor
    public AdServicio() throws Exception {

        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            _mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public List<Servicio> ListarRegistros(String condicion) throws SQLException {

        ResultSet rs = null;
        List<Servicio> lista = new ArrayList();
        try {

            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_servicio ,descripcion, precio, descuento from servicio";
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Servicio(rs.getInt("id_servicio"), rs.getString("descripcion"),
                        rs.getDouble("precio"), rs.getDouble("descuento")));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return lista;
    }
    
    public Servicio ObtenerRegistro(String condicion) throws SQLException {

        Servicio servicio = new Servicio();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_servicio, descripcion, precio, descuento from servicio";
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                servicio.setId_servicio(rs.getInt(1));
                servicio.setDescripcion(rs.getString(2));
                servicio.setPrecio(rs.getDouble(3));
                servicio.setDescuento(rs.getDouble(4));
                servicio.setExiste(true);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return servicio;
    }
    
}
