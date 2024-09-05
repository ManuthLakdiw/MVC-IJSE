/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.dto.ItemDto;
import edu.ijse.mvc.model.ItemModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author manuthlakdiv
 */
public class ItemController {
    
        private final ItemModel ITEM_MODEL;

    public ItemController() {
        this.ITEM_MODEL = new ItemModel();
    }

    public ArrayList<ItemDto> getAllItem() throws SQLException, ClassNotFoundException{
        ArrayList<ItemDto> itemList = ITEM_MODEL.getAll();
        return itemList;
    }
    
    public String save(ItemDto itemDto) throws SQLException, ClassNotFoundException{
        itemDto.setDescription("car");
        String resp = ITEM_MODEL.saveItem(itemDto);
        System.out.println(itemDto.toString());
       
        return resp;
    }
    
    public String update(ItemDto itemDto) throws SQLException, ClassNotFoundException{
        
        String resp = ITEM_MODEL.updateItem(itemDto); // pass to the model
       
        return resp;
    }
    
    public String delete(ItemDto itemDto) throws SQLException, ClassNotFoundException{
        
        String resp = ITEM_MODEL.deleteItem(itemDto); // pass to the model
       
        return resp;
    }
    
}
    

