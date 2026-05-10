/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.sg.bo.custom;

import com.ijse.sg.bo.SuperBO;
import com.ijse.sg.dto.CustomerDTO;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public interface CustomerBO extends SuperBO {
    public boolean saveCustomer(CustomerDTO dto) throws Exception;
    public boolean updateCustomer(CustomerDTO dto) throws Exception;
    public boolean deleteCustomer(int id) throws Exception;
    public List<CustomerDTO> getAllCustomers() throws Exception;
}
