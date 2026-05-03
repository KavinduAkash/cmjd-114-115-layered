/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao;

import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.ItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class ItemDAOImpl {
    
    public boolean save(ItemDTO dto) throws Exception {
            boolean rs = false;
        
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "INSERT INTO items(id, name, qty, unit_price) VALUES (?,?,?,?)";
            
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setInt(1, dto.getId());
                stm.setString(2, dto.getName());
                stm.setInt(3, dto.getQty());
                stm.setDouble(4, dto.getPrice());
                
                int result = stm.executeUpdate();
                
                rs = result > 0;
            }
            
            return rs;
    }
    
    public boolean update(ItemDTO dto) throws Exception {
            boolean rs = false;
        
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                String sql = "UPDATE items SET name=?, qty=?, unit_price=? WHERE id=?";
            
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setString(1, dto.getName());
                stm.setInt(2, dto.getQty());
                stm.setDouble(3, dto.getPrice());
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
                String sql = "DELETE FROM items WHERE id=?";
            
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setInt(1, id);
                
                int result = stm.executeUpdate();
                
                rs = result > 0;
            }

            return rs;
    }
    
    public List<ItemDTO> getAll() throws Exception {
            List<ItemDTO> dtos = new ArrayList<>();
       
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "SELECT * FROM items";
                
                Statement stm = conn.createStatement();
                
                ResultSet result = stm.executeQuery(sql);
            
                while(result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    int qty = result.getInt("qty");
                    double price = result.getDouble("unit_price");
                    
                    ItemDTO dto = new ItemDTO(id, name, qty, price);
                    dtos.add(dto);
                }
                
            }
        
            return dtos;
    }
    
    public ItemDTO search(int id) throws Exception {
            ItemDTO dto = null;
        
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "SELECT * FROM items WHERE id=?";
                
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setInt(1, id);
                
                ResultSet result = stm.executeQuery();
            
                while(result.next()) {
                    int itemId = result.getInt("id");
                    String name = result.getString("name");
                    int qty = result.getInt("qty");
                    double price = result.getDouble("unit_price");
                    
                    dto = new ItemDTO(itemId, name, qty, price);
                }
                
            }
        
            return dto;
    }
    
}
