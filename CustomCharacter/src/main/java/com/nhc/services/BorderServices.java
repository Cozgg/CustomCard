/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.services;

import com.nhc.pojo.Border;
import com.nhc.pojo.Card;
import com.nhc.utils.MyConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class BorderServices extends BaseServices<Border>{
     public List<Border> list() throws SQLException{
        Connection conn = MyConnector.getInstance().connect();
        
        PreparedStatement stm = conn.prepareCall("SELECT * FROM border");
        
        ResultSet rs = stm.executeQuery();
        
        List<Border> borders = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            
            Border b = new Border(id, name);
            borders.add(b);
        }
        return borders;
    }
}
