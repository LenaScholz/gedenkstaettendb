package uos.lscholz.gedenkstaettendb.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Group of Labels and data inserts to specify the name and structure of a Datafield (to be used when
 * the user needs to create a new source
 */
public class DatafieldGroupPane extends GridPane{

    private Label datafieldLabel;
    private Label kindOfDataLabel;
    private ComboBox kindOfData;
    private Label identifierLabel;
    private TextField identifier;
    private Button datafieldDelete;

    public DatafieldGroupPane(){
        this("Datenfeld");
    }

    /**
     *
     * @param name name of the Datafield
     */
    public DatafieldGroupPane(String name){
        ObservableList<String> kindOfDataChoices =
                FXCollections.observableArrayList("Text","Datum","natürliche Zahl","Fließkommazahl","Wahrheitswert");

        this.datafieldLabel = new Label(name);
        this.kindOfDataLabel = new Label("Art der Daten");
        this.kindOfData = new ComboBox(kindOfDataChoices);
        this.identifierLabel = new Label("Bezeichner");
        this.identifier = new TextField();
        this.datafieldDelete = new Button("X");
        this.datafieldDelete.setId("deleteButton");

        this.add(datafieldDelete,1,1);
        this.add(datafieldLabel,2,1);
        this.add(kindOfDataLabel,2,2);
        this.add(kindOfData,2,3);
        this.add(identifierLabel,2,4);
        this.add(identifier,2,5);
    }

}
