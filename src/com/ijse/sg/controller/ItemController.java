/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.controller;

import com.ijse.sg.dao.ItemDAO;
import com.ijse.sg.dao.ItemDAOImpl;
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
    
    private final ItemDAO itemDAO = new ItemDAOImpl();
    
    public boolean saveItem(ItemDTO dto) throws Exception {
        
        ItemEntity entity = covertItemDTOToItemEntity(dto);
        return itemDAO.save(entity);
    
    }
    
    public boolean updateItem(ItemDTO dto) throws Exception {
        
        ItemEntity entity = covertItemDTOToItemEntity(dto);
        return itemDAO.update(entity);
    
    }
    
    public boolean deleteItem(int id) throws Exception {
    
        return itemDAO.delete(id);
    
    }
    
    public List<ItemDTO> getItems() throws Exception {
        
        List<ItemEntity> items = itemDAO.getAll();
        
        List<ItemDTO> dtos = new ArrayList<>();
        
        for (ItemEntity item : items) {
            dtos.add(covertItemEntityToItemDTO(item));
        }
        return dtos;
        
    }
    
    public ItemDTO getItemDetails(int id) throws Exception {

        ItemEntity item = itemDAO.search(id);
        ItemDTO dto = covertItemEntityToItemDTO(item);
        return dto;
        
    }
    
    private ItemEntity covertItemDTOToItemEntity(ItemDTO dto) {
        return new ItemEntity(dto.getId(), dto.getName(), dto.getQty(), dto.getPrice());
    }
    
    private ItemDTO covertItemEntityToItemDTO(ItemEntity entity) {
        return new ItemDTO(entity.getId(), entity.getName(), entity.getQty(), entity.getUnitPrice());
    }
    
}
