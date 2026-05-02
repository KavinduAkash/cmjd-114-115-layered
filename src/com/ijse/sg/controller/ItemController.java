/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.controller;

import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.ItemDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class ItemController {
    
    public boolean saveItem(ItemDTO dto) throws Exception {
        boolean rs = false;
        
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "INSERT INTO items(id, name, qty, unit_price) VALUES (" + dto.getId() + ", '" + dto.getName() + "', "+ dto.getQty() +", " + dto.getPrice() + ")";
            
                Statement stm = conn.createStatement();
                
                int result = stm.executeUpdate(sql);
                
                rs = result > 0;
            }
            
            return rs;
    }
    
    public boolean updateItem(ItemDTO dto) throws Exception {
        boolean rs = false;
        
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                String sql = "UPDATE items SET name='" + dto.getName() + "', qty=" + dto.getQty() + ", unit_price='" + dto.getPrice() + "' WHERE id=" + dto.getId();
            
                Statement stm = conn.createStatement();
                
                int result = stm.executeUpdate(sql);
                
                rs = result > 0;
            }
        
            return rs;
    }
    
    public boolean deleteItem(int id) throws Exception {
       boolean rs = false;
            
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                String sql = "DELETE FROM items WHERE id=" + id;
            
                Statement stm = conn.createStatement();
                
                int result = stm.executeUpdate(sql);
                
                rs = result > 0;
            }

            return rs;
    }
    
    public List<ItemDTO> getItems() throws Exception {
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
    
    public ItemDTO getItemDetails(int id) throws Exception {
        ItemDTO dto = null;
        
            Connection conn = DBConnection.getInstance().getConnection();
            
            if(conn!=null) {
                
                String sql = "SELECT * FROM items WHERE id=" + id;
                
                Statement stm = conn.createStatement();
                
                ResultSet result = stm.executeQuery(sql);
            
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
