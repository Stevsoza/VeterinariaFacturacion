/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Config.Config;
import Entidades.Venta;
import java.sql.*;

/**
 *
 * @author Steven
 */
public class AdVenta {

    private Connection _cnn;
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    public AdVenta() throws Exception {

        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            _mensaje = "";
        } catch(Exception ex) {
            throw ex;
        }
    }

    public int Insertar(Venta venta) throws Exception {

        int id_venta = -1;

        try {
            if (!venta.isExiste()) {
                String sentencia = "insert into factura_venta(fecha) values(?)";
                PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
                ps.setDate(1, venta.getFecha());
                ps.execute();

                ResultSet rs = ps.getGeneratedKeys();

                if (rs != null && rs.next()) {

                    id_venta = rs.getInt(1);
                    _mensaje = "Factura creada";
                }

            } else {
                String sentencia = "UPDATE FACTURA_VENTA SET FECHA = ?, ID_VENDEDOR = ?, ID_CLIENTE = ?, IMPORTE = ?, DESCUENTO = ?, ESTADO = ?, TIPO = ?"
                        + "         WHERE ID_VENTA = ?";
                PreparedStatement ps = _cnn.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
                ps.setDate(1, venta.getFecha());
                ps.setInt(2, venta.getId_vendedor());
                ps.setInt(3, venta.getId_cliente());
                ps.setDouble(4, venta.getImporte());
                ps.setDouble(5 , venta.getDescuento());
                ps.setString(6, venta.getEstado());
                ps.setString(7, venta.getTipo());
                ps.setInt(8, venta.getId_venta());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                
                if (rs != null && rs.next()) {

                    id_venta = rs.getInt(1);
                    _mensaje = "Factura Guardada";
                }
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }

        return id_venta;
    }

}
