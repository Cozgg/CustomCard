/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.utils.themes;

import com.nhc.customcharacter.App;
import java.net.URL;

/**
 *
 * @author nguye
 */
public class DefaultThemeFactory implements ThemeFactory{

    @Override
    public String getStyleSheet() {
        return App.class.getResource("styles.css").toExternalForm();
    }
    
}
