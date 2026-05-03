/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao;

/**
 *
 * @author kavinduakash
 */
public class DAOFactory {
    
    public static enum DAOTypes {
        CUSTOMER, ITEM // ORDER, ORDER_ITEM
    }
    
    public SuperDAO getDAO(DAOTypes type) {
        switch(type) {
            case DAOTypes.CUSTOMER:
                return new CustomerDAOImpl();
                
            case DAOTypes.ITEM:  
                return new ItemDAOImpl();
                
            default:
                return null;
        }
        
    }
    
}
