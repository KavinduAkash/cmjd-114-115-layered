/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao.custom.impl;

import com.ijse.sg.dao.custom.OrderItemDAO;
import com.ijse.sg.db.DBConnection;
import com.ijse.sg.entity.OrderItemEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class OrderItemDAOImpl implements OrderItemDAO {

    @Override
    public boolean save(OrderItemEntity entity) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO order_items(order_id, item_id, unit_price, qty, total_price) VALUES (?, ?, ?, ?, ?)";
           
        PreparedStatement stm = conn.prepareStatement(sql);
                
        stm.setInt(1, order.getOrderId());
        stm.setInt(2, orderItemDTO.getItemId());
        stm.setDouble(3, orderItemDTO.getUnitPrice());
        stm.setInt(4, orderItemDTO.getQty());
        stm.setDouble(5, orderItemDTO.getUnitPrice()*orderItemDTO.getQty());

        int result = stm.executeUpdate(); 
                
        if(result <= 0) {
            throw new SQLException();
        }
        
        return true;
    }

    @Override
    public boolean update(OrderItemEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int id) throws Exception {
        return false;
    }

    @Override
    public List<OrderItemEntity> getAll() throws Exception {
        return true;
    }
    
}
