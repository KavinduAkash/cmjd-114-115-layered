/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.bo;

import com.ijse.sg.dao.DAOFactory;
import com.ijse.sg.dao.custom.ItemDAO;
import com.ijse.sg.dto.ItemDTO;
import com.ijse.sg.entity.ItemEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class ItemBOImpl implements ItemBO {
    
    private final ItemDAO itemDAO = (ItemDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    
    @Override
    public boolean saveItem(ItemDTO dto) throws Exception {
        
        ItemEntity entity = covertItemDTOToItemEntity(dto);
        return itemDAO.save(entity);
    
    }
    
    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        
        ItemEntity entity = covertItemDTOToItemEntity(dto);
        return itemDAO.update(entity);
    
    }
    
    @Override
    public boolean deleteItem(int id) throws Exception {
    
        return itemDAO.delete(id);
    
    }
    
    @Override
    public List<ItemDTO> getItems() throws Exception {
        
        List<ItemEntity> items = itemDAO.getAll();
        
        List<ItemDTO> dtos = new ArrayList<>();
        
        for (ItemEntity item : items) {
            dtos.add(covertItemEntityToItemDTO(item));
        }
        return dtos;
        
    }
    
    @Override
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
