/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Config.Config;
import Entidades.Animal;
import Entidades.Veterinario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class AdAnimal {

    private Connection _cnn;
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    //constructor
    public AdAnimal() throws Exception {

        try {
            String url = Config.getConnectionString();
            _cnn = DriverManager.getConnection(url);
            _mensaje = "";
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Animal> ListarRegistros(String condicion) throws SQLException{
        ResultSet rs = null;
        List<Animal> lista = new ArrayList<>();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_animal, id_cliente, alias, especie, raza, color ,fecha_nacimiento from animal";
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Animal(rs.getInt("id_animal"), rs.getInt("id_cliente"),
                        rs.getString("alias"), rs.getString("especie"), rs.getString("raza"),rs.getString("color"),rs.getDate("fecha_nacimiento")));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return lista;
    }
    
    public Animal ObtenerRegistro(String condicion) throws SQLException {

        Animal animal = new Animal();
        ResultSet rs = null;
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select id_animal, id_cliente, alias, especie, raza, color ,fecha_nacimiento from animal";
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                animal.setId_animal(rs.getInt(1));
                animal.setId_cliente(rs.getInt(2));
                animal.setAlias(rs.getString(3));
                animal.setEspecie(rs.getString(4));
                animal.setRaza(rs.getString(5));
                animal.setColor(rs.getString(6));
                animal.setFechaNacimiento(rs.getDate(7));
                animal.setExiste(true);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return animal;
    }
}
