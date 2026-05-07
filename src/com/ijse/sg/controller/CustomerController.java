/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.controller;

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
   
    private final CustomerDAO customerDAO = (CustomerDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        
            CustomerEntity customerEntity = convertCustomerDTOToCustomerEntity(dto);
            boolean result = customerDAO.save(customerEntity);
            return result;
    
    }
    
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
            
            CustomerEntity customerEntity = convertCustomerDTOToCustomerEntity(dto);
            boolean result = customerDAO.update(customerEntity);
            return result;
            
    }
    
    public boolean deleteCustomer(int id) throws Exception {
        
        boolean result = customerDAO.delete(id);
        return result;
        
    }
    
    public List<CustomerDTO> getCustomers() throws Exception {
               
        List<CustomerEntity> customers = customerDAO.getAll();
        
        List<CustomerDTO> dtos = new ArrayList<>();
        
        for (CustomerEntity customer : customers) {
            CustomerDTO dto = convertCustomerEntityToCustomerDTO(customer);
            dtos.add(dto);
        }
        
        return dtos;
        
    }
    
    private CustomerEntity convertCustomerDTOToCustomerEntity(CustomerDTO dto) {
        
        CustomerEntity customerEntity = new CustomerEntity(dto.getId(), dto.getName(), dto.getEmail(), dto.getAddress());
        return customerEntity;
        
    }
    
    private CustomerDTO convertCustomerEntityToCustomerDTO(CustomerEntity entity) {
        
        CustomerDTO customerEntity = new CustomerDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getAddress());
        return customerEntity;
        
    }
    
}
