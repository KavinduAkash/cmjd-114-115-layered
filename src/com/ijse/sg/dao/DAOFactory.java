/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao;

import com.ijse.sg.dao.custom.impl.ItemDAOImpl;
import com.ijse.sg.dao.custom.impl.CustomerDAOImpl;
import com.ijse.sg.dao.custom.impl.OrderDAOImpl;
import com.ijse.sg.dao.custom.impl.OrderItemDAOImpl;
import com.ijse.sg.dao.custom.impl.QueryDAOImpl;

/**
 *
 * @author kavinduakash
 */
public class DAOFactory {
    
    private static DAOFactory df;
    
    private DAOFactory() {
    }
    
    public static enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDER_ITEM, QUERY
    }
    
    public static DAOFactory getInstance() {
        return (df==null) ? df = new DAOFactory() : df;
    }
    
    public SuperDAO getDAO(DAOTypes type) {
        switch(type) {
            case DAOTypes.CUSTOMER:
                return new CustomerDAOImpl();
                
            case DAOTypes.ITEM:  
                return new ItemDAOImpl();
            
            case DAOTypes.ORDER:  
                return new OrderDAOImpl();
                
            case DAOTypes.ORDER_ITEM:  
                return new OrderItemDAOImpl();
            
            case DAOTypes.QUERY:  
                return new QueryDAOImpl();
                
            default:
                return null;
        }
        
    }
    
}
