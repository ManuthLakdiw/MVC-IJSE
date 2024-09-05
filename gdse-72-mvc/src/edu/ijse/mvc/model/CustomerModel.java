/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.CustomerDto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author manuthlakdiv
 */
public class CustomerModel {
    
    public ArrayList<CustomerDto> getAll() throws SQLException, ClassNotFoundException{
    
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "select * from customer";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        
         ArrayList<CustomerDto> cusDtos = new ArrayList<>();
                
                
        while(rst.next()){
            CustomerDto cDto = new CustomerDto();
            cDto.setId(rst.getString("CustID"));
            cDto.setTitle(rst.getString("CustTitle"));
            cDto.setName(rst.getString("CustName"));
            cDto.setDob(rst.getString("DOB"));
            cDto.setSalary(rst.getDouble("salary"));
            cDto.setAddress(rst.getString("CustAddress"));
            cDto.setCity(rst.getString("City"));
            cDto.setProvince(rst.getString("Province"));
            cDto.setPostalCode(rst.getString("PostalCode"));
            
            cusDtos.add(cDto);
               
        }
        
        return cusDtos;
    
    
    }
    
    public String saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = ("insert into customer values(?,?,?,?,?,?,?,?,?)");
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getId());
        statement.setString(2, dto.getTitle());
        statement.setString(3, dto.getName());
        statement.setString(4, dto.getDob());
        statement.setDouble(5, dto.getSalary());
        statement.setString(6, dto.getAddress());
        statement.setString(7, dto.getCity());
        statement.setString(8, dto.getProvince());
        statement.setString(9, dto.getPostalCode());
  
        int result = statement.executeUpdate();
        return result > 0 ? "Successful" : "Fail";
        
    }
    
    public String updateCustomer(CustomerDto dto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "update customer set CustTitle = ? , CustName = ? , DOB = ? , salary = ? , CustAddress = ? , City = ? , Province = ? , PostalCode = ? where CustID = ? ";
        
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, dto.getTitle());
        statement.setString(2, dto.getName());
        statement.setString(3, dto.getDob());
        statement.setDouble(4, dto.getSalary());
        statement.setString(5, dto.getAddress());
        statement.setString(6, dto.getCity());
        statement.setString(7, dto.getProvince());
        statement.setString(8, dto.getPostalCode());
        statement.setString(9, dto.getId());
        
        
        int result = statement.executeUpdate();
        return result > 0 ? "Successful" : "Fail";


    
    }
    
    
     public String deleteCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM customer WHERE CustID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getId());


        int result = statement.executeUpdate();
        return result > 0 ? "Successful" : "Fail";
    }
        
        
    
    
        
    
}
