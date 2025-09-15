/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.services;

/**
 *
 * @author nguye
 */
public class ShinyCardDecorator extends CardEffectDecorator{

    public ShinyCardDecorator(IEffect decorator) {
        super(decorator);
    }

    @Override
    public String updateCardEffect() {
        return this.decorator.updateCardEffect()+ ", Hieu ung lap lanh";
    }

    @Override
    public int updateAtk() {
        return this.decorator.updateAtk() + 20000;
    }
    
}
