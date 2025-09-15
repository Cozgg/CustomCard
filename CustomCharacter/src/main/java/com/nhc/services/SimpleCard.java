/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.services;

import com.nhc.pojo.Card;

/**
 *
 * @author nguye
 */
public class SimpleCard implements IEffect {

    private Card c;

    public SimpleCard(Card c) {
        this.c = c;
    }

    @Override
    public String updateCardEffect() {
        return "The ";
    }

    @Override
    public int updateAtk() {
        return c.getAtk();
    }

}
