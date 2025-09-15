package com.nhc.customcharacter;

import com.nhc.pojo.Border;
import com.nhc.pojo.Character;
import com.nhc.services.BorderServices;
import com.nhc.services.CharacterServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable{
    
    @FXML ComboBox<Character> cbChar;   
    @FXML ComboBox<Border> cbBorder;
    
    private static final BorderServices borderServices = new BorderServices();
    private static final CharacterServices charServices = new CharacterServices();
    
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbChar.setItems(FXCollections.observableList(charServices.list()));
            this.cbBorder.setItems(FXCollections.observableList(borderServices.list()));
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
