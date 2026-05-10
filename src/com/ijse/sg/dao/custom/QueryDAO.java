/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ijse.sg.dao.custom;

import com.ijse.sg.dao.SuperDAO;
import com.ijse.sg.entity.CustomEntity;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kavinduakash
 */
public interface QueryDAO extends SuperDAO {
    public List<CustomEntity> filterOrderCustomers(Date startDate, Date endDate) throws Exception;
}
