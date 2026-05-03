/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.sg.dao;

import com.ijse.sg.entity.CustomerEntity;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public interface CrudDAO<T> extends SuperDAO {
    public boolean save(T entity) throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(int id) throws Exception;
    public List<T> getAll() throws Exception;
}
