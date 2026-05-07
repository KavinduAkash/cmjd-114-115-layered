/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao.custom.impl;

import com.ijse.sg.dao.custom.CustomerDAO;
import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.CustomerDTO;
import com.ijse.sg.entity.CustomerEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class CustomerDAOImpl implements CustomerDAO {
    
    @Override
    public boolean save(CustomerEntity entity) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "INSERT INTO customers(id, name, email, address) VALUES (?,?,?,?)";
                
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setInt(1 , entity.getId()); // (question_mark, value)
                stm.setString(2, entity.getName());
                stm.setString(3, entity.getEmail());
                stm.setString(4, entity.getAddress());

                int result = stm.executeUpdate();
               
                return result > 0;
            }
       
            return false;
    }
    
    @Override
    public boolean update(CustomerEntity entity) throws Exception {
            boolean rs = false;

            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "UPDATE customers SET name=?, email=?, address=? WHERE id=?";
            
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setString(1, entity.getName());
                stm.setString(2, entity.getEmail());
                stm.setString(3, entity.getAddress());
                stm.setInt(4, entity.getId());
                
                int result = stm.executeUpdate();
                
                rs = result > 0;
            }
            
            return rs;
    }
    
    @Override
    public boolean delete(int id) throws Exception {
            boolean rs = false;
        
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
               
                
                String sql = "DELETE FROM customers WHERE id=?";
                
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setInt(1, id);
                
                int result = stm.executeUpdate();
                
                rs = result > 0;
                
            }
      
            return rs;
    }
    
    @Override
    public List<CustomerEntity> getAll() throws Exception {
            
            List<CustomerEntity> entities = new ArrayList<>();
            
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "SELECT * FROM customers";
                
                Statement stm = conn.createStatement();
                
                ResultSet result = stm.executeQuery(sql);
            
                while(result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    String email = result.getString("email");
                    String address = result.getString("address");
                    
                    CustomerEntity entity = new CustomerEntity(id, name, email, address);
                    entities.add(entity);
                }
            }
        
            return entities;
            
    }
    
}
