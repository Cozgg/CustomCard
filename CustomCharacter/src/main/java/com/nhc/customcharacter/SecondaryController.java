package com.nhc.customcharacter;

import com.nhc.pojo.Card;
import com.nhc.services.BaseServices;
import com.nhc.services.CardServices;
import com.nhc.services.FlyWeightFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController implements Initializable{

    @FXML private TableView<Card> tbCard;
    private static final CardServices cardServices = new CardServices();
    
    
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.tbCard.setItems(FXCollections.observableList(FlyWeightFactory.getData(cardServices, "card")));
            this.loadColumns();
        } catch (SQLException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadColumns(){
        TableColumn colId = new TableColumn("ID");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn colName = new TableColumn("Name");
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn colContent = new TableColumn("Mo ta");
        colContent.setCellValueFactory(new PropertyValueFactory("moTa"));
        TableColumn colAtk = new TableColumn("Luc chien");
        colAtk.setCellValueFactory(new PropertyValueFactory("atk"));
        
        this.tbCard.getColumns().clear();
        this.tbCard.getColumns().addAll(colId, colName, colContent, colAtk);
    }
}