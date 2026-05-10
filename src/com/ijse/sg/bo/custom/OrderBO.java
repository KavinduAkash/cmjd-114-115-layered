/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.sg.bo.custom;

import com.ijse.sg.bo.SuperBO;
import com.ijse.sg.dto.OrderDTO;

/**
 *
 * @author kavinduakash
 */
public interface OrderBO extends SuperBO {
    public boolean placeOrder(OrderDTO orderDTO) throws Exception;
}
