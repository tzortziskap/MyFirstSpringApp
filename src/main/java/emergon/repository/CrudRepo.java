/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import java.util.List;

/**
 *
 * @author tzortziskapellas
 */
public interface CrudRepo <E>{
    
    E save(E e);
    boolean delete(int id);
    E findById(int id);
    List<E> findAll();
    
    
    
    
}
