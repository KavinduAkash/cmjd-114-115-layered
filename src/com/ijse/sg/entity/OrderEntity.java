/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.entity;

import java.util.Date;

/**
 *
 * @author kavinduakash
 */
public class OrderEntity {
    private int id;
    private int customerId;
    private Date date;

    public OrderEntity() {
    }

    public OrderEntity(int id, int customerId, Date date) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OrderEntity{" + "id=" + id + ", customerId=" + customerId + ", date=" + date + '}';
    }
}
