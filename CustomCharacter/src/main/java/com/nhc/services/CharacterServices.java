/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.services;

import com.nhc.pojo.Character;

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
public class CharacterServices extends BaseServices<Character>{
     public List<Character> list() throws SQLException{
        Connection conn = MyConnector.getInstance().connect();
        
        PreparedStatement stm = conn.prepareCall("SELECT * FROM nhanvat");
        
        ResultSet rs = stm.executeQuery();
        
        List<Character> characters = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            
            Character c = new Character(id, name);
            characters.add(c);
        }
        return characters;
    }
}
