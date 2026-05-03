/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.sg.dao;

import com.ijse.sg.entity.ItemEntity;

/**
 *
 * @author kavinduakash
 */
public interface ItemDAO extends CrudDAO<ItemEntity> {

    public ItemEntity search(int id) throws Exception;

}
