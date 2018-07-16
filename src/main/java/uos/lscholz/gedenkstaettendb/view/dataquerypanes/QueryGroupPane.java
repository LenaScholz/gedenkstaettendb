package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import uos.lscholz.gedenkstaettendb.view.DeleteButton;

public class QueryGroupPane extends GridPane{

    private DeleteButton deleteButton;
    private ComboBox<String> comboBox;
    private HBox hBox;
    private QuerySection querySection;
    private Separator separator;

    public QueryGroupPane(){

        ObservableList<String> kindOfDataChoices =
                FXCollections.observableArrayList("Text","Datum","natürliche Zahl","Fließkommazahl","Wahrheitswert");

        this.deleteButton = new DeleteButton();
        this.comboBox = new ComboBox<>(kindOfDataChoices);
        this.comboBox.getSelectionModel().select("Text");

        this.querySection = QuerySectionFactory.createQuerySection("TEXT");
        this.separator = new Separator();
        this.separator.setId("separator");

        this.comboBox.setOnAction(new SelectionHandler());

        this.add(deleteButton,1,1);
        this.add(comboBox,2,1);
        this.add(querySection,2,2);
        this.add(separator,1,3,2,1);

    }

    private class SelectionHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            String type;
            switch (comboBox.getSelectionModel().getSelectedIndex()){
                case 0: type = "TEXT"; break;
                case 1: type = "DATE"; break;
                case 2: type = "INT"; break;
                case 3: type = "FLOAT"; break;
                case 4: type = "BOOLEAN";break;
                default:throw new RuntimeException("illegal choice");
            }
            getChildren().remove(querySection);
            querySection = QuerySectionFactory.createQuerySection(type);
            add(querySection,2,2);
        }
    }
}
