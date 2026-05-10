/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.entity;

/**
 *
 * @author kavinduakash
 */
public class CustomEntity {
    
    private int customerId;
    private String customerName;
    private int orderCount;

    public CustomEntity() {
    }

    public CustomEntity(int customerId, String customerName, int orderCount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderCount = orderCount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "CustomEntity{" + "customerId=" + customerId + ", customerName=" + customerName + ", orderCount=" + orderCount + '}';
    }
    
}
