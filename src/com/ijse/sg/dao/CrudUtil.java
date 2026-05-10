/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.dao;

import com.ijse.sg.db.DBConnection;
import com.ijse.sg.entity.CustomerEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
/**
 *
 * @author kavinduakash
 */
public class CrudUtil {
    
    public static boolean executeUpdate(String sql, Object...values) throws SQLException {
        Connection conn = DBConnection.getInstance().getConnection();
        
        if(conn!=null) {
        
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            int i = 0;
            for (Object value : values) {
                ++i;
                pstm.setObject(i, value);
            }
            
            int result = pstm.executeUpdate();
            
            return result>0;

        }
        
        return false;
    }
    
}
