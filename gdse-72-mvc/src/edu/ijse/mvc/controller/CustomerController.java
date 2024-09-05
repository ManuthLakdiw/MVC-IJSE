/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.dto.CustomerDto;
import edu.ijse.mvc.model.CustomerModel;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author manuthlakdiv
 */
public class CustomerController {
    private final CustomerModel cusModel;

    public CustomerController() {
        this.cusModel  = new CustomerModel();
    }
    
    public ArrayList<CustomerDto> getAllCustomer() throws SQLException, ClassNotFoundException{
        ArrayList<CustomerDto> customerList = cusModel.getAll();
        return customerList;
    }
    
    
    public String save(CustomerDto customerDto) throws SQLException, ClassNotFoundException{
        String resp = cusModel.saveCustomer(customerDto);
        
        return resp;
    
    }
    
    public String update(CustomerDto customerDto) throws ClassNotFoundException, SQLException{
        String resp = cusModel.updateCustomer(customerDto);
        
        return resp;
    
    }
    
    
     public String delete(CustomerDto customerDto) throws ClassNotFoundException, SQLException{
        String resp = cusModel.deleteCustomer(customerDto);
        
        return resp;
    
    }
        
        
    
}
