/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Config.Config;
import Entidades.DetalleProducto;
import Entidades.DetalleServicio;
import java.sql.*;

/**
 *
 * @author Steven
 */
public class AdDetalle {

    private Connection _cnn;
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    public AdDetalle() throws Exception {

        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            _mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }

    public int insertarDetalleP(DetalleProducto dProducto) throws Exception {
        int resultado = -1;

        String sentencia = "insert into Detalle_producto(id_venta, id_producto, descripcion, cantidad, precio, descuento, total)"
                + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dProducto.getId_venta());
            ps.setInt(2, dProducto.getId_producto());
            ps.setString(3, dProducto.getDescripcion());
            ps.setInt(4, dProducto.getCantidad());
            ps.setDouble(5, dProducto.getPrecio());
            ps.setDouble(6, dProducto.getDescuento());
            ps.setDouble(7, dProducto.getTotal());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs != null && rs.next()) {
                resultado = rs.getInt(1);
                _mensaje = "Detalle Ingresado satisfactoriamente";
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;
    }
    
    public int insertarDetalleS(DetalleServicio dServicio) throws Exception {
        int resultado = -1;

        String sentencia = "insert into Detalle_servicio(id_venta, id_servicio, descripcion, id_veterinario, id_animal, cantidad, precio, descuento, total) "
                + "values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dServicio.getId_venta());
            ps.setInt(2, dServicio.getId_servicio());
            ps.setString(3, dServicio.getDescripcion());
            ps.setInt(4, dServicio.getId_veterinario());
            ps.setInt(5, dServicio.getId_animal());
            ps.setInt(6, dServicio.getCantidad());
            ps.setDouble(7, dServicio.getPrecio());
            ps.setDouble(8, dServicio.getDescuento());
            ps.setDouble(9, dServicio.getTotal());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs != null && rs.next()) {
                resultado = rs.getInt(1);
                _mensaje = "Detalle Ingresado satisfactoriamente";
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;
    }

}
