/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.controller;

import com.ijse.sg.dao.CustomerDAOImpl;
import com.ijse.sg.db.DBConnection;
import com.ijse.sg.dto.CustomerDTO;
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
    
    private final CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
            boolean result = customerDAO.save(dto);
            return result;
    }
    
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        
            boolean result = customerDAO.update(dto);
            return result;
            
    }
    
    public boolean deleteCustomer(int id) throws Exception {
        
        boolean result = customerDAO.delete(id);
        return result;
        
    }
    
    public List<CustomerDTO> getCustomers() throws Exception {
               
        List<CustomerDTO> customers = customerDAO.getAll();
        return customers;
    }
    
}
