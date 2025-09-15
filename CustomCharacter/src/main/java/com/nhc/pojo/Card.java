/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.pojo;

/**
 *
 * @author nguye
 */
public class Card {

    private int id;
    private String name;
    private String moTa;
    private int atk;
    private Character character;
    private Border border;

    private Card(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.moTa= b.moTa;
        this.atk = b.atk;
        this.character = b.character;
        this.border = b.border;
    }

    public static class Builder {

        private int id;
        private String name;
        private String moTa;
        private int atk;
        private Character character;
        private Border border;

        public Builder(String name) {
            this.name = name;
            this.atk = 0;
        }
        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        public Builder addMoTa(String mt){
            this.moTa = mt;
            return this;
        }
        public Builder addAtk(int atk){
            this.atk = atk;
            return this;
        }
        public Builder addCharacter(Character c){
            this.character = c;
            return this;
        }
        public Builder addBorder(Border b){
            this.border = b;
            return this;
        }
        public Card build(){
            return new Card(this);
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    /**
     * @return the atk
     */
    public int getAtk() {
        return atk;
    }

    /**
     * @param atk the atk to set
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

    /**
     * @return the character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * @param character the character to set
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * @return the border
     */
    public Border getBorder() {
        return border;
    }

    /**
     * @param border the border to set
     */
    public void setBorder(Border border) {
        this.border = border;
    }

}
