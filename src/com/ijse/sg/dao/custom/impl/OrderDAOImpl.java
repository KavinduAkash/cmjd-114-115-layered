/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao.custom.impl;

import com.ijse.sg.dao.DAOFactory;
import com.ijse.sg.dao.custom.OrderDAO;
import com.ijse.sg.dao.custom.OrderItemDAO;
import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.OrderDTO;
import com.ijse.sg.dto.OrderItemDTO;
import com.ijse.sg.entity.OrderEntity;
import com.ijse.sg.entity.OrderItemEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class OrderDAOImpl implements OrderDAO {

    OrderItemDAO orderItemDAO = (OrderItemDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_ITEM);

    @Override
    public boolean save(OrderEntity entity) throws Exception {
        return false;
    }
    
    @Override
    public boolean save(OrderEntity entity, List<OrderItemEntity> orderItemEntites) throws Exception {
        Connection conn = null;
        boolean rs = false;
        
        try {
            
            conn = DBConnection.getInstance().getConnection();
           
            conn.setAutoCommit(false);
            
            String sql = "INSERT INTO orders(customer_id) VALUES (?)";
           
            PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
            stm.setInt(1, entity.getCustomerId());
                
            int result1 = stm.executeUpdate();
            
            if(result1 > 0) {
//                sql = "SELECT * FROM customers ORDER BY id DESC LIMIT 1";
//                ResultSet result2 = stm.executeQuery(sql);
                
                ResultSet result2 = stm.getGeneratedKeys();
                while(result2.next()) {
//                    int orderId = result2.getInt("id");
                    int orderId = result2.getInt(1);
                    rs = this.placeOrderItems(orderItemEntites, orderId);
                    if(rs) {
                        conn.commit();
                    }
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
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
    
    private boolean placeOrderItems(List<OrderItemEntity> orderItemEntites, int orderId) throws Exception {
            
            System.out.println("----------------> orderItemEntites list: " + orderItemEntites.size());
        
            for (OrderItemEntity orderItemEntity : orderItemEntites) {
                orderItemEntity.setOrderId(orderId);
                System.out.println("----------------> orderItemEntity Id: " + orderItemEntity.getOrderId());
                boolean result = orderItemDAO.save(orderItemEntity);
            }
            
            return true;
    }
    
}
