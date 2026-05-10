/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao.custom.impl;

import com.ijse.sg.dao.CrudUtil;
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
        boolean result = CrudUtil.executeUpdate(
                "INSERT INTO items(id, name, qty, unit_price) VALUES (?,?,?,?)", 
                entity.getId(), 
                entity.getName(), 
                entity.getQty(), 
                entity.getUnitPrice()
        );
        return result;
    }
    
    @Override
    public boolean update(ItemEntity entity) throws Exception {
            boolean result = CrudUtil.executeUpdate(
                "UPDATE items SET name=?, qty=?, unit_price=? WHERE id=?", 
                entity.getName(), 
                entity.getQty(), 
                entity.getUnitPrice(),
                entity.getId()
            );
            return result;
    }
    
    @Override
    public boolean delete(int id) throws Exception {
            boolean result = CrudUtil.executeUpdate(
                "DELETE FROM items WHERE id=?", 
                id
            );
            return result;
    }
    
    @Override
    public List<ItemEntity> getAll() throws Exception {
            List<ItemEntity> entities = new ArrayList<>();
       
            ResultSet result = CrudUtil.executeQuery("SELECT * FROM items");
            
            while(result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    int qty = result.getInt("qty");
                    double price = result.getDouble("unit_price");
                    
                    ItemEntity entity = new ItemEntity(id, name, qty, price);
                    entities.add(entity);
            }
        
            return entities;
    }
    
    @Override
    public ItemEntity search(int id) throws Exception {
            ItemEntity entity = null;
        
            ResultSet result = CrudUtil.executeQuery("SELECT * FROM items WHERE id=?", id);
            
            while(result.next()) {
                    int itemId = result.getInt("id");
                    String name = result.getString("name");
                    int qty = result.getInt("qty");
                    double price = result.getDouble("unit_price");
                    
                    entity = new ItemEntity(id, name, qty, price);
                }
        
            return entity;
    }
    
}
