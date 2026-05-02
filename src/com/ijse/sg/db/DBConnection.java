/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.sg.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kavinduakash
 */
public class DBConnection {
    
    private final String DB_URL = "jdbc:mysql://localhost:3306/supermarket";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "ijse";
    
    private static DBConnection dbc;
    private Connection conn;
    
    private DBConnection() throws SQLException  {
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    public static DBConnection getInstance() throws SQLException {
        return (dbc==null) ? dbc = new DBConnection() : dbc;
    }
    
    public Connection getConnection() {
        return conn;
    }
    
}