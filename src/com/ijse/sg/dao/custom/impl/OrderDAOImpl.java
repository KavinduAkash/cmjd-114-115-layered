/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao.custom.impl;

import com.ijse.sg.dao.custom.OrderDAO;
import com.ijse.sg.entity.OrderEntity;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean save(OrderEntity entity) throws Exception {
        
    }

    @Override
    public boolean update(OrderEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int id) throws Exception {
        return false;
    }

    @Override
    public List<OrderEntity> getAll() throws Exception {
        return null;
    }
    
}
