/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
/**
 *
 * @author juanc
 */

public interface GenericDAO<T> {
    
    public boolean guardar(T entity) throws Exception;
 
    List<T> obtenerTodos() throws Exception;
}