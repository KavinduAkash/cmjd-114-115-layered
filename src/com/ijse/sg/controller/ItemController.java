/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.controller;

import com.ijse.sg.dao.ItemDAOImpl;
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
public class ItemController {
    
    private final ItemDAOImpl itemDAO = new ItemDAOImpl();
    
    public boolean saveItem(ItemDTO dto) throws Exception {
        return itemDAO.save(dto);
    }
    
    public boolean updateItem(ItemDTO dto) throws Exception {
        return itemDAO.update(dto);
    }
    
    public boolean deleteItem(int id) throws Exception {
       return itemDAO.delete(id);
    }
    
    public List<ItemDTO> getItems() throws Exception {
        List<ItemDTO> items = itemDAO.getAll();
        return items;
    }
    
    public ItemDTO getItemDetails(int id) throws Exception {
        ItemDTO item = itemDAO.search(id);
        return item;
    }
    
}
