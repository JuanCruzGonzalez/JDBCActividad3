/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import config.DatabaseConnection;
import model.Instrumento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentoDAOImpl implements GenericDAO<Instrumento>{

    @Override
    public List<Instrumento> obtenerTodos() {
        List<Instrumento> lista = new ArrayList<>();
        String sql = "SELECT * FROM instrumentos";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Instrumento i = new Instrumento(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("tipo"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
                lista.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener instrumentos: " + e.getMessage());
        }
        return lista;
    }
    @Override
    public boolean guardar(Instrumento instrumento) {
        String sql = "INSERT INTO instrumentos(nombre, tipo, precio, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, instrumento.getNombre());
            stmt.setString(2, instrumento.getTipo());
            stmt.setDouble(3, instrumento.getPrecio());
            stmt.setInt(4, instrumento.getCantidad());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al guardar instrumento: " + e.getMessage());
            return false;
        }
    }
}