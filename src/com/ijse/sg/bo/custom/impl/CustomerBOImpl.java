/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.bo.custom.impl;

import com.ijse.sg.bo.custom.CustomerBO;
import com.ijse.sg.dao.DAOFactory;
import com.ijse.sg.dao.custom.CustomerDAO;
import com.ijse.sg.dto.CustomerDTO;
import com.ijse.sg.entity.CustomerEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public class CustomerBOImpl implements CustomerBO {
    
    private final CustomerDAO customerDAO = (CustomerDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
            CustomerEntity customerEntity = convertCustomerDTOToCustomerEntity(dto);
            boolean result = customerDAO.save(customerEntity);
            return result;
    }
    
    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
            CustomerEntity customerEntity = convertCustomerDTOToCustomerEntity(dto);
            boolean result = customerDAO.update(customerEntity);
            return result;
    }
    
    @Override
    public boolean deleteCustomer(int id) throws Exception {
        boolean result = customerDAO.delete(id);
        return result;
    }
    
    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
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
