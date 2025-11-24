/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica02;

import java.util.List;

/**
 *
 * @author josealanth
 */
public interface IDAOGeneral <T,K>{
    //Define el comportamiento 
    boolean guardar(T pojo);
    T eliminar(K k);
    T modificar(T pojo, K k);
    T findByID(K k);
    List<T> findAll();
    
}
