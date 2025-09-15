/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.nhc.services.charactertheme;

import com.nhc.pojo.Character;

/**
 *
 * @author nguye
 */
public enum Fantasy {
    HIEPSI {
        @Override
        void getCharacter(String s) {
            Character c = new Character();
            c.setName(s);
        }
    }, PHAPSU {
        @Override
        void getCharacter(String c) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };

    abstract void getCharacter(String s);
}
