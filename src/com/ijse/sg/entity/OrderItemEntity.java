/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.entity;

/**
 *
 * @author kavinduakash
 */
public class OrderItemEntity {
    private int id;
    private int orderId;
    private int orderItemId;
    private double unitPrice;
    private int qty;
    private double totalPrice;     

    public OrderItemEntity() {
    }

    public OrderItemEntity(int id, int orderId, int orderItemId, double unitPrice, int qty, double totalPrice) {
        this.id = id;
        this.orderId = orderId;
        this.orderItemId = orderItemId;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderItemEntity{" + "id=" + id + ", orderId=" + orderId + ", orderItemId=" + orderItemId + ", unitPrice=" + unitPrice + ", qty=" + qty + ", totalPrice=" + totalPrice + '}';
    }
}
