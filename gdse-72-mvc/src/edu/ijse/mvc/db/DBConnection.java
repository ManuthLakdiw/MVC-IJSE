/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.db;

/**
 *
 * @author manuthlakdiv
 */

import java.sql.*;

public class DBConnection {
    
        private static DBConnection dbConnection;

    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root","Manu@213");
    }

    public static DBConnection getInstance()  throws ClassNotFoundException, SQLException {
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}


    

