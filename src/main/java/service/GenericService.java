/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
/**
 *
 * @author juanc
 */

public interface GenericService<T> {
   
    void guardar(T entity) throws Exception;
       
    List<T> obtenerTodos() throws Exception;
}