/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhc.utils.themes;

import javafx.scene.Scene;

/**
 *
 * @author nguye
 */
public class ThemeManager {
    private static ThemeFactory theme = new DefaultThemeFactory();

    public static void setThemeFactory(ThemeFactory atheme){
        theme = atheme;
    }
    
    public static void applyTheme(Scene scene){
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(theme.getStyleSheet());
    }
}
