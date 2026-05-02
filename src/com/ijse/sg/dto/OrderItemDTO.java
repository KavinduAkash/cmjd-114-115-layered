/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dto;

/**
 *
 * @author kavinduakash
 */
public class OrderItemDTO {
    private int itemId;
    private double unitPrice;
    private int qty;

    public OrderItemDTO() {
    }

    public OrderItemDTO(int itemId, double unitPrice, int qty) {
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    @Override
    public String toString() {
        return "OrderItemDTO{" + "itemId=" + itemId + ", unitPrice=" + unitPrice + ", qty=" + qty + '}';
    }
}
