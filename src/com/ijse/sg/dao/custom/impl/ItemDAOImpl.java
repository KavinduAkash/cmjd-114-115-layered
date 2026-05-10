/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao.custom.impl;

import com.ijse.sg.dao.custom.ItemDAO;
import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.ItemDTO;
import com.ijse.sg.entity.ItemEntity;
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
public class ItemDAOImpl implements ItemDAO {
    
    @Override
    public boolean save(ItemEntity entity) throws Exception {
            boolean rs = false;
        
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "INSERT INTO items(id, name, qty, unit_price) VALUES (?,?,?,?)";
            
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setInt(1, entity.getId());
                stm.setString(2, entity.getName());
                stm.setInt(3, entity.getQty());
                stm.setDouble(4, entity.getUnitPrice());
                
            int result = stm.executeUpdate();
                
                rs = result > 0;
            }
            
            return rs;
    }
    
    @Override
    public boolean update(ItemEntity entity) throws Exception {
            boolean rs = false;
        
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                String sql = "UPDATE items SET name=?, qty=?, unit_price=? WHERE id=?";
            
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setString(1, entity.getName());
                stm.setInt(2, entity.getQty());
                stm.setDouble(3, entity.getUnitPrice());
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
                String sql = "DELETE FROM items WHERE id=?";
            
                PreparedStatement stm = conn.prepareStatement(sql);
                
                stm.setInt(1, id);
                
                int result = stm.executeUpdate();
                
                rs = result > 0;
            }

            return rs;
    }
    
    @Override
    public List<ItemEntity> getAll() throws Exception {
            List<ItemEntity> entities = new ArrayList<>();
       
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
                    
                    ItemEntity entity = new ItemEntity(id, name, qty, price);
                    entities.add(entity);
                }
                
            }
        
            return entities;
    }
    
    @Override
    public ItemEntity search(int id) throws Exception {
            ItemEntity entity = null;
        
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
                    
                    entity = new ItemEntity(id, name, qty, price);
                }
                
            }
        
            return entity;
    }
    
}
