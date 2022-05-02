/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

/**
 *
 * @author Steven
 */

import java.sql.*;
import Config.Config;
import Entidades.Producto;
import java.util.ArrayList;
import java.util.List;


public class AdProducto {
    private Connection _cnn;
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    //constructor
    public AdProducto() throws Exception {

        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            _mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public List<Producto> ListarRegistros(String condicion) throws SQLException {

        ResultSet rs = null;
        List<Producto> lista = new ArrayList();
        try {

            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_producto, descripcion, categoria, precio, descuento, existencia from producto";
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Producto(rs.getInt("id_producto"), rs.getString("descripcion"),
                        rs.getString("categoria"), rs.getDouble("precio"), rs.getDouble("descuento"),rs.getInt("existencia")));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return lista;
    }
    
    public Producto ObtenerRegistro(String condicion) throws SQLException {

        Producto producto = new Producto();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_producto, descripcion, categoria, precio, descuento, existencia from producto";
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                producto.setId_producto(rs.getInt(1));
                producto.setDescripcion(rs.getString(2));
                producto.setCategoria(rs.getString(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setDescuento(rs.getDouble(5));
                producto.setExistencia(rs.getInt(6));
                producto.setExiste(true);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return producto;
    }
}
