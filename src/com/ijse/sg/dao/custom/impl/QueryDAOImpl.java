/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao.custom.impl;

import com.ijse.sg.dao.CrudUtil;
import com.ijse.sg.dao.custom.QueryDAO;
import com.ijse.sg.entity.CustomEntity;
import java.util.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author kavinduakash
 */
public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<CustomEntity> filterOrderCustomers(Date startDate, Date endDate) throws Exception {
        ResultSet result = CrudUtil.executeQuery(
                "SELECT c.id, c.name, COUNT(o.id) as order_count FROM customers c, orders o WHERE c.id = o.customer_id AND o.date > ? AND o.date < ? GROUP BY c.id", 
                startDate, 
                endDate
        );
        
        List<CustomEntity> customEntityList = new ArrayList<>();
        
        while(result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            int orderCount = result.getInt("order_count");
            
            CustomEntity entity = new CustomEntity(id, name, orderCount);
            customEntityList.add(entity);
        }
        
        return customEntityList;
       
    }
    
}
