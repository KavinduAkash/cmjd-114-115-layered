/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.controller;

import com.ijse.sg.bo.BOFactory;
import com.ijse.sg.bo.custom.OrderBO;
import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.OrderDTO;
import com.ijse.sg.dto.OrderItemDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author kavinduakash
 */
public class OrderController {
    
    OrderBO orderBO = (OrderBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
    
    public boolean placeOrder(OrderDTO order) throws Exception {
        boolean result = orderBO.placeOrder(order);
        return result;
    }
    
    public void filterOrderCustomers(Date startDate, Date endDate) throws Exception {
        orderBO.filterOrderCustomers(startDate, endDate);
    }
    
}
