package uos.lscholz.gedenkstaettendb.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.Iterator;

/**
 * Group of Labels and data inserts to specify the name and structure of a Datafield (to be used when
 * the user needs to create a new source
 */
public class DatafieldGroupPane extends GridPane{

    private Label datafieldLabel;
    private CheckBox pagination;
    private Label kindOfDataLabel;
    private ComboBox kindOfData;
    private Label identifierLabel;
    private TextField identifier;
    private Button datafieldDelete;
    private Separator separator;

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
        this.pagination = new CheckBox("Paginierung");
        this.kindOfDataLabel = new Label("Art der Daten");
        this.kindOfData = new ComboBox(kindOfDataChoices);
        this.identifierLabel = new Label("Bezeichner");
        this.identifier = new TextField();
        this.datafieldDelete = new Button("X");
        this.datafieldDelete.setId("deleteButton");
        this.separator = new Separator();
        this.separator.setId("separator");

        this.add(datafieldDelete,1,1);
        this.add(pagination,3,3);
        this.add(datafieldLabel,2,1);
        this.add(kindOfDataLabel,2,2);
        this.add(kindOfData,2,3);
        this.add(identifierLabel,2,4);
        this.add(identifier,2,5,2,1);
        this.add(separator,1,6,3,1);

        Iterator<Node> iterator = this.getChildren().iterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            this.setHgrow(node, Priority.ALWAYS);
            this.setVgrow(node,Priority.ALWAYS);
        }
    }

}
