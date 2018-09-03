/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hos.dao;

import java.util.ArrayList;

/**
 *
 * @author slash
 */
public interface CrudDAO<T, ID> extends SuperDAO{
    public Boolean save(T entity)throws Exception;
    
    public Boolean delete(ID id)throws Exception;
    
    public Boolean update(T entity)throws Exception;
    
    public ArrayList<T> getAll()throws Exception;
    
    public T findByID(ID id)throws Exception;
}
