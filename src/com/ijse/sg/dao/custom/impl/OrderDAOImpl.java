/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao.custom.impl;

import com.ijse.sg.dao.custom.OrderDAO;
import com.ijse.sg.db.DBConnection;
import com.ijse.sg.entity.OrderEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean save(OrderEntity entity) throws Exception {
        Connection conn = null;
        boolean rs = false;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
           
            conn.setAutoCommit(false);
            
            String sql = "INSERT INTO orders(customer_id) VALUES (?)";
           
            PreparedStatement stm = conn.prepareStatement(sql);
                
            stm.setInt(1, order.getCustomerId());
                
            int result1 = stm.executeUpdate();
                
            if(result1 > 0) {
                sql = "SELECT * FROM customers ORDER BY id DESC LIMIT 1";
                ResultSet result2 = stm.executeQuery(sql);

                while(result2.next()) {
                    int orderId = result2.getInt("id");
                    order.setOrderId(orderId);
                    rs = this.placeOrderItems(order);
                    if(rs) {
                        conn.commit();
                    }
                }
            }
            
        } catch(Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return rs;
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
