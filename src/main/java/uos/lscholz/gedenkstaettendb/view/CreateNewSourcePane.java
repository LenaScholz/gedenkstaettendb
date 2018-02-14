package uos.lscholz.gedenkstaettendb.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.List;

public class CreateNewSourcePane extends GridPane {

    private Label nameOfSourceLabel;
    private TextField nameOfSource;

    private List<DatafieldGroupPane> datafields;






    public CreateNewSourcePane(){
        this.nameOfSourceLabel = new Label("Name der Quelle");
        this.nameOfSource = new TextField();

        this.add(nameOfSourceLabel,1,1);
        this.add(nameOfSource,1,2);

        //TODO: dynamic generation and storage in datafields-list
        this.add(new DatafieldGroupPane("Datenfeld 1"),1,3);
        this.add(new DatafieldGroupPane("Datenfeld 2"),1,4);
        this.add(new DatafieldGroupPane("Datenfeld 3"),1,5);

    }
}
