/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocrud.v2;

import java.sql.Connection;
import java.sql.SQLException;
import config.DatabaseConnectionPool;
/**
 *
 * @author juanc
 */

public class TestConexion {
public static void main(String[] args) {
        try (Connection conn = DatabaseConnectionPool.getConnection()) {
            if (conn != null) {
                System.out.println("Conexión establecida con éxito.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}