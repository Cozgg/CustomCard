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
public enum Theme {
    DARK {
        @Override
        public void updateTheme(Scene scene) {
            ThemeManager.setThemeFactory(new DarkThemeFactory());
            ThemeManager.applyTheme(scene);
        }
    }, LIGHT {
        @Override
        public void updateTheme(Scene scene) {
            ThemeManager.setThemeFactory(new LightThemeFactory());
            ThemeManager.applyTheme(scene);
        }
    }, DEFAULT {
        @Override
        public void updateTheme(Scene scene) {
            ThemeManager.setThemeFactory(new DefaultThemeFactory());
            ThemeManager.applyTheme(scene);
        }
    };
    
    public abstract void updateTheme(Scene scene);
}
