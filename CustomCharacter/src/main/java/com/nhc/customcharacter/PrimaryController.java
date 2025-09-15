package com.nhc.customcharacter;

import com.nhc.pojo.Border;
import com.nhc.pojo.Card;
import com.nhc.pojo.Character;
import com.nhc.services.BorderServices;
import com.nhc.services.CardServices;
import com.nhc.services.CharacterServices;
import com.nhc.services.FireCardDecorator;
import com.nhc.services.FlyWeightFactory;
import com.nhc.services.IEffect;
import com.nhc.services.ShinyCardDecorator;
import com.nhc.services.SimpleCard;
import com.nhc.services.charactertheme.CharacterFactory;
import com.nhc.services.charactertheme.FantasyCharacterFactory;
import com.nhc.services.charactertheme.MordenCharacterFactory;
import com.nhc.utils.themes.Theme;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

    @FXML
    ComboBox<Character> cbChar;
    @FXML
    ComboBox<Border> cbBorder;
    @FXML
    private TableView<Card> tbCard;
    @FXML
    CheckBox chkFire;
    @FXML
    CheckBox chkShiny;
    @FXML
    TextField txtName;
    @FXML ComboBox<Theme> cbTheme;
    @FXML ComboBox<CharacterFactory> cbFac;
    

    private static final CardServices cardServices = new CardServices();

    private static final BorderServices borderServices = new BorderServices();
    private static final CharacterServices charServices = new CharacterServices();

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbBorder.setItems(FXCollections.observableList(FlyWeightFactory.getData(borderServices, "border")));
            this.tbCard.setItems(FXCollections.observableList(FlyWeightFactory.getData(cardServices, "card")));
            this.cbTheme.setItems(FXCollections.observableArrayList(Theme.values()));
            this.cbFac.setItems(FXCollections.observableArrayList(new FantasyCharacterFactory(), new MordenCharacterFactory()));
            this.loadColumns();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadColumns() {
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

    public void handleAddCard() throws SQLException {
        Character character = this.cbChar.getSelectionModel().getSelectedItem();
        Border b = this.cbBorder.getSelectionModel().getSelectedItem();
        String name = this.txtName.getText();
        Card c = new Card.Builder(name).addCharacter(character).addBorder(b).build();
        IEffect simpleCard = new SimpleCard(c);
        if (chkFire.isSelected()) {
            simpleCard = new FireCardDecorator(simpleCard);
        }
        if(chkShiny.isSelected()){
            simpleCard = new ShinyCardDecorator(simpleCard);
        }
        c.setMoTa(simpleCard.updateCardEffect());
        c.setAtk(simpleCard.updateAtk());
        if(cardServices.addCard(c)){
            this.tbCard.setItems(FXCollections.observableList(cardServices.list()));
            System.out.println("Them thanh cong");
        }
        else System.out.println("Them that bai");
    }
    
    public void handleChangeTheme(ActionEvent e){
        this.cbTheme.getSelectionModel().getSelectedItem().updateTheme(this.cbTheme.getScene());
    }
    
    public void handleChangeCharacterTheme(ActionEvent e){
        this.cbFac.getSelectionModel().getSelectedItem().loadCharComboBox(cbChar);
    }
}
