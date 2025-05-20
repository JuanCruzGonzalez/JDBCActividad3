/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.GenericDAO;
import model.Instrumento;
import java.util.List;
/**
 *
 * @author juanc
 */

public class InstrumentoServiceImpl implements GenericService<Instrumento> {

    private final GenericDAO<Instrumento> instrumentoDAO;

    public InstrumentoServiceImpl(GenericDAO<Instrumento> instrumentoDAO) {
        this.instrumentoDAO = instrumentoDAO;
    }

    @Override
    public void guardar(Instrumento instrumento) throws Exception {
        if (instrumento.getNombre() == null || instrumento.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del instrumento no puede estar vacío.");
        }
        if (instrumento.getCantidad() < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser menor a cero.");
        }
        instrumentoDAO.guardar(instrumento);
    }

    @Override
    public List<Instrumento> obtenerTodos() throws Exception {
        return instrumentoDAO.obtenerTodos();
    }
}
