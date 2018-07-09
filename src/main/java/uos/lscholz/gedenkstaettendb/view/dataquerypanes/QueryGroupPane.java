package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.DeleteButton;

public class QueryGroupPane extends GridPane{

    private DeleteButton deleteButton;
    private ComboBox<String> comboBox;
    private QuerySection querySection;

    public QueryGroupPane(){

        ObservableList<String> kindOfDataChoices =
                FXCollections.observableArrayList("Text","Datum","natürliche Zahl","Fließkommazahl","Wahrheitswert");

        this.deleteButton = new DeleteButton();
        this.comboBox = new ComboBox<>(kindOfDataChoices);
        this.comboBox.getSelectionModel().select("Text");
        this.querySection = QuerySectionFactory.createQuerySection("TEXT");

        this.add(deleteButton,1,1);
        this.add(comboBox,2,1);
        this.add(querySection,1,2,2,1);

    }
}
