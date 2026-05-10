/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.bo.custom.impl;

import com.ijse.sg.bo.custom.OrderBO;
import com.ijse.sg.dao.DAOFactory;
import com.ijse.sg.dao.custom.OrderDAO;
import com.ijse.sg.dto.OrderDTO;
import com.ijse.sg.entity.OrderEntity;

/**
 *
 * @author kavinduakash
 */
public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = (OrderDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    
    @Override
    public boolean placeOrder(OrderDTO orderDTO) throws Exception {
        
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerId(orderDTO.getCustomerId());
        
        orderDAO.save(orderEntity);

    }
    
}
