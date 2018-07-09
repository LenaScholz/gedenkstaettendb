package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.DeleteButton;

public class QueryGroupPane extends GridPane{

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

        this.add(deleteButton,1,1);
        this.add(comboBox,2,1);
        this.add(querySection,2,2);
        this.add(separator,1,3,2,1);

    }
}
