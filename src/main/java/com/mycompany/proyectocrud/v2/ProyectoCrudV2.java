/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectocrud.v2;

import dao.GenericDAO;
import dao.InstrumentoDAOImpl;
import model.Instrumento;
import service.GenericService;
import service.InstrumentoServiceImpl;
/**
 *
 * @author juanc
 */

public class ProyectoCrudV2 {
    public static void main(String[] args) {

        GenericDAO<Instrumento> instrumentoDAO = new InstrumentoDAOImpl();

        GenericService<Instrumento> InstrumentoService = new InstrumentoServiceImpl(instrumentoDAO);

        try {
            Instrumento nuevo = new Instrumento(
                0,
                "Guitarra",                
                "Cuerda",      
                1000.0,                  
                15                         
            );

            InstrumentoService.guardar(nuevo);
        
            System.out.println("Producto guardado exitosamente.");

            System.out.println("?istado de productos:");
            for (Instrumento p : InstrumentoService.obtenerTodos()) {
                System.out.println("🔹 ID: " + p.getId() +
                                ", Nombre: " + p.getNombre() +
                                ", Tipo: " + p.getTipo() +
                                ", Precio: " + p.getPrecio() +
                                ", Cantidad: " + p.getCantidad());
            }

        } catch (Exception e) {
            System.err.println("Error al guardar o recuperar productos: " + e.getMessage());
        }
    }
}