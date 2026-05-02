/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class OrderDTO {
    private int orderId;
    private int customerId;
    private List<OrderItemDTO> orderItemList;
    private Date date;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, int customerId, List<OrderItemDTO> orderItemList, Date date) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderItemList = orderItemList;
        this.date = date;
    }

    public OrderDTO(int customerId, List<OrderItemDTO> orderItemList) {
        this.customerId = customerId;
        this.orderItemList = orderItemList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemDTO> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItemDTO> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "customerId=" + customerId + ", orderItemList=" + orderItemList + ", date=" + date + '}';
    }
}
