/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.services.charactertheme;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

/**
 *
 * @author nguye
 */
public class FantasyCharacterFactory implements CharacterFactory{

    @Override
    public void loadCharComboBox(ComboBox cb) {
        cb.setItems(FXCollections.observableArrayList(Fantasy.values()));
    }

    @Override
    public String toString() {
        return "Fantasy"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

}
