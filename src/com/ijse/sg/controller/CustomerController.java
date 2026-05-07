/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.controller;

import com.ijse.sg.bo.BOFactory;
import com.ijse.sg.bo.CustomerBO;
import com.ijse.sg.bo.CustomerBOImpl;
import com.ijse.sg.dao.custom.CustomerDAO;
import com.ijse.sg.dao.custom.impl.CustomerDAOImpl;
import com.ijse.sg.dao.DAOFactory;
import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.CustomerDTO;
import com.ijse.sg.entity.CustomerEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class CustomerController {
   
    CustomerBO customerBO = (CustomerBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        
            boolean result = customerBO.saveCustomer(dto);
            return result;
    
    }
    
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
            
            boolean result = customerBO.updateCustomer(dto);
            return result;
            
    }
    
    public boolean deleteCustomer(int id) throws Exception {
        
         boolean result = customerBO.deleteCustomer(id);
         return result;
        
    }
    
    public List<CustomerDTO> getCustomers() throws Exception {
               
       List<CustomerDTO> customerList = customerBO.getAllCustomers();
       return customerList;
        
    }
    
}