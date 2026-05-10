/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.sg.bo.custom;

import com.ijse.sg.bo.SuperBO;
import com.ijse.sg.dto.CustomDTO;
import com.ijse.sg.dto.OrderDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public interface OrderBO extends SuperBO {
    public boolean placeOrder(OrderDTO orderDTO) throws Exception;
    
    public List<CustomDTO> filterOrderCustomers(Date startDate, Date endDate) throws Exception;
}
