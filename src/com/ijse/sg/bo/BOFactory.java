/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.bo;

import com.ijse.sg.bo.custom.impl.ItemBOImpl;
import com.ijse.sg.bo.custom.impl.CustomerBOImpl;
import com.ijse.sg.dao.DAOFactory;
import com.ijse.sg.dao.SuperDAO;
import com.ijse.sg.dao.custom.impl.CustomerDAOImpl;
import com.ijse.sg.dao.custom.impl.ItemDAOImpl;

/**
 *
 * @author kavinduakash
 */
public class BOFactory {
    private static BOFactory df;
    
    private BOFactory() {
    }
    
    public static enum BOTypes {
        CUSTOMER, ITEM // ORDER, ORDER_ITEM
    }
    
    public static BOFactory getInstance() {
        return (df==null) ? df = new BOFactory() : df;
    }
    
    public SuperBO getBO(BOTypes type) {
        switch(type) {
            case BOTypes.CUSTOMER:
                return new CustomerBOImpl();
                
            case BOTypes.ITEM:  
                return new ItemBOImpl();
                
            default:
                return null;
        }
        
    }
}
