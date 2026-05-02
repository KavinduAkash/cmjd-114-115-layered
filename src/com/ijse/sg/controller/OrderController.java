/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.controller;

import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.OrderDTO;
import com.ijse.sg.dto.OrderItemDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kavinduakash
 */
public class OrderController {
    
    public boolean placeOrder(OrderDTO order) throws Exception {
        Connection conn = null;
        boolean rs = false;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
           
            conn.setAutoCommit(false);
            
            String sql = "INSERT INTO orders(customer_id) VALUES (" + order.getCustomerId() + ")";
           
            Statement stm = conn.createStatement();
                
            int result1 = stm.executeUpdate(sql);
                
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
    
    public boolean placeOrderItems(OrderDTO order) throws Exception {
            boolean rs = false;
        
            Connection conn = DBConnection.getInstance().getConnection();
           
            for (OrderItemDTO orderItemDTO : order.getOrderItemList()) {
             
                String sql = "INSERT INTO order_items(order_id, item_id, unit_price, qty, total_price) VALUES (" + order.getOrderId() + ", " + orderItemDTO.getItemId() + ", " + orderItemDTO.getUnitPrice() + ", " + orderItemDTO.getQty() + ", " + (orderItemDTO.getUnitPrice() * orderItemDTO.getQty()) +  ")";
           
                Statement stm = conn.createStatement();

                int result = stm.executeUpdate(sql); 
                
                if(result <= 0) {
                    throw new SQLException();
                }
            }
          
        return rs;
    }
    
}
