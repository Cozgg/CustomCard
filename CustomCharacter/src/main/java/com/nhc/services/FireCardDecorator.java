/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.services;

/**
 *
 * @author nguye
 */
public class FireCardDecorator extends CardEffectDecorator{

    public FireCardDecorator(IEffect decorator) {
        super(decorator);
    }

    @Override
    public String updateCardEffect() {
        return decorator.updateCardEffect() + ", Hieu ung lua";
    }

    @Override
    public int updateAtk() {
        return this.decorator.updateAtk() + 10000;
    }
    
}
