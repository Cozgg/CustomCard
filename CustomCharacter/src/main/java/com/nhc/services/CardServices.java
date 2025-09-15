/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.services;

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
public class CardServices extends BaseServices<Card>{
    public List<Card> list() throws SQLException{
        Connection conn = MyConnector.getInstance().connect();
        
        PreparedStatement stm = conn.prepareCall("SELECT * FROM card");
        
        ResultSet rs = stm.executeQuery();
        
        List<Card> cards = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String moTa = rs.getString("mota");
            int atk = rs.getInt("atk");
            
            Card c = new Card.Builder(id, name).addMoTa(moTa).addAtk(atk).build();
            cards.add(c);
        }
        return cards;
    }
    
    public boolean addCard(Card c) throws SQLException{
        String sql = "INSERT INTO card(name, mota, id_character, id_border, atk) VALUES(?,?,?,?,?)";
        
        Connection conn = MyConnector.getInstance().connect();
        conn.setAutoCommit(false);
        PreparedStatement stm = conn.prepareCall(sql);
        stm.setString(1, c.getName());
        stm.setString(2, c.getMoTa());
        stm.setInt(3, c.getCharacter().getId());
        stm.setInt(4, c.getBorder().getId());
        stm.setInt(5, c.getAtk());
        if(stm.executeUpdate() > 0){
            conn.commit();
            return true;
        } else{
            conn.rollback();
            return false;
        }
    }
}
