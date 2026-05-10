/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.sg.dao.custom;

import com.ijse.sg.dao.CrudDAO;
import com.ijse.sg.entity.OrderEntity;
import com.ijse.sg.entity.OrderItemEntity;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public interface OrderDAO extends CrudDAO<OrderEntity> {
    public boolean save(OrderEntity entity, List<OrderItemEntity> orderItemEntites) throws Exception;
}
