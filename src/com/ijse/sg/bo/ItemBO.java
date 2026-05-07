/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.sg.bo;

import com.ijse.sg.dto.ItemDTO;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public interface ItemBO {
    public boolean saveItem(ItemDTO dto) throws Exception;
    public boolean updateItem(ItemDTO dto) throws Exception;
    public boolean deleteItem(int id) throws Exception;
    public List<ItemDTO> getItems() throws Exception;
}
