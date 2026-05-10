/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao.custom.impl;

import com.ijse.sg.dao.CrudUtil;
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
          boolean result = CrudUtil.executeUpdate(
                  "INSERT INTO customers(id, name, email, address) VALUES (?,?,?,?)", 
                  entity.getId(), 
                  entity.getName(), 
                  entity.getEmail(), 
                  entity.getAddress()
          );
          
          return result;
    }
    
    @Override
    public boolean update(CustomerEntity entity) throws Exception {
        
            boolean result = CrudUtil.executeUpdate(
                    "UPDATE customers SET name=?, email=?, address=? WHERE id=?", 
                    entity.getName(), 
                    entity.getEmail(), 
                    entity.getAddress(), 
                    entity.getId()
            );
            
            return result;
    }
    
    @Override
    public boolean delete(int id) throws Exception {
            boolean result = CrudUtil.executeUpdate(
                    "DELETE FROM customers WHERE id=?", 
                    id
            );
            return result;
    }
    
    @Override
    public List<CustomerEntity> getAll() throws Exception {
            
            List<CustomerEntity> entities = new ArrayList<>();
            
            ResultSet result = CrudUtil.executeQuery("SELECT * FROM customers");
            
            while(result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    String email = result.getString("email");
                    String address = result.getString("address");
                    
                    CustomerEntity entity = new CustomerEntity(id, name, email, address);
                    entities.add(entity);
            }
        
            return entities;
            
    }
    
}
