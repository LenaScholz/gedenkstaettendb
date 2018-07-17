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
import uos.lscholz.gedenkstaettendb.view.HasSections;
import uos.lscholz.gedenkstaettendb.view.RemovableSection;
import uos.lscholz.gedenkstaettendb.view.eventHandlers.RemoveSectionHandler;

public class QueryGroupPane extends GridPane implements RemovableSection {

    private DeleteButton deleteButton;
    private ComboBox<String> comboBox;
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
        this.deleteButton.setOnAction(new RemoveSectionHandler(this));

        this.add(deleteButton,1,1);
        this.add(comboBox,2,1);
        this.add(querySection,2,2);
        this.add(separator,1,3,2,1);

    }

    @Override
    public void removeSection() {
        //TODO: make prettyer if possible
        if(this.getParent().getParent().getParent().getParent().getParent() instanceof HasSections){
            ((HasSections) this.getParent().getParent().getParent().getParent().getParent()).removeSection(this);
        }else{
            throw new RuntimeException("Section called from Parent that does not have sections");
        }
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
