/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.services;

/**
 *
 * @author nguye
 */
public abstract class CardEffectDecorator implements IEffect{
    protected IEffect decorator;

    public CardEffectDecorator(IEffect decorator) {
        this.decorator = decorator;
    }
    
}
