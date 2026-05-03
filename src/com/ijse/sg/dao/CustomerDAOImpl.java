/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao;

import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.CustomerDTO;
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
public class CustomerDAOImpl {
    
    public boolean save(CustomerDTO dto) throws Exception {
        Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "INSERT INTO customers(id, name, email, address) VALUES (?,?,?,?)";
                
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setInt(1 , dto.getId()); // (question_mark, value)
                stm.setString(2, dto.getName());
                stm.setString(3, dto.getEmail());
                stm.setString(4, dto.getAddress());

                int result = stm.executeUpdate();
               
                return result > 0;
            }
       
            return false;
    }
    
    public boolean update(CustomerDTO dto) throws Exception {
            boolean rs = false;

            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "UPDATE customers SET name=?, email=?, address=? WHERE id=?";
            
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getEmail());
                stm.setString(3, dto.getAddress());
                stm.setInt(4, dto.getId());
                
                int result = stm.executeUpdate();
                
                rs = result > 0;
            }
            
            return rs;
    }
    
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
    
    public List<CustomerDTO> getAll() throws Exception {
            List<CustomerDTO> dtos = new ArrayList<>();
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
                    
                    CustomerDTO cdto = new CustomerDTO(id, name, email, address);
                    dtos.add(cdto);
                }
            }
        
            return dtos;
            
    }
    
}
