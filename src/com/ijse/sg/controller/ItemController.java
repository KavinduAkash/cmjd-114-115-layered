/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.controller;

import com.ijse.sg.bo.ItemBO;
import com.ijse.sg.bo.ItemBOImpl;
import com.ijse.sg.dao.DAOFactory;
import com.ijse.sg.dao.custom.ItemDAO;
import com.ijse.sg.dao.custom.impl.ItemDAOImpl;
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
public class ItemController {
    
    ItemBO itemBO = new ItemBOImpl();
   
    
    public boolean saveItem(ItemDTO dto) throws Exception {
        
       boolean result = itemBO.saveItem(dto);
       return result;
    
    }
    
    public boolean updateItem(ItemDTO dto) throws Exception {
        
        boolean result = itemBO.updateItem(dto);
       return result;
    
    }
    
    public boolean deleteItem(int id) throws Exception {
    
        boolean result = itemBO.deleteItem(id);
       return result;
    
    }
    
    public List<ItemDTO> getItems() throws Exception {
        
       List<ItemDTO> result = itemBO.getItems();
       return result;
        
    }
    
    public ItemDTO getItemDetails(int id) throws Exception {

       ItemDTO result = itemBO.getItemDetails(id);
       return result;
        
    }
    
}
