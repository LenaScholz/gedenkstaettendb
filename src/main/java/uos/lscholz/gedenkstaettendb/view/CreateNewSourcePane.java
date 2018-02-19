package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.List;

public class CreateNewSourcePane extends GridPane {

    private Label nameOfSourceLabel;
    private TextField nameOfSource;
    private Button addDatafieldButton;
    private Label addDatafield;
    private ScrollPane scrollPane;
    private GridPane datafieldsGridPane;

    private List<DatafieldGroupPane> datafields;



    public CreateNewSourcePane(){
        this.setHgap(20);
        this.setVgap(20);
        this.nameOfSourceLabel = new Label("Name der Quelle");
        this.nameOfSource = new TextField();

        this.scrollPane = new ScrollPane();
        this.datafieldsGridPane = new GridPane();

        this.addDatafieldButton = new Button("+");
        this.addDatafieldButton.setId("addButton");
        this.addDatafield = new Label("Weiteres Datenfeld hinzufügen");

        this.add(nameOfSourceLabel,1,1,2,1);
        this.add(nameOfSource,1,2,2,1);

        scrollPane.setContent(datafieldsGridPane);
        this.add(scrollPane,1,3,2,1);
        //TODO: dynamic generation and storage in datafields-list
        datafieldsGridPane.add(new DatafieldGroupPane("Datenfeld 1"),1,3,2,1);
        datafieldsGridPane.add(new DatafieldGroupPane("Datenfeld 2"),1,4,2,1);
        datafieldsGridPane.add(new DatafieldGroupPane("Datenfeld 3"),1,5,2,1);
        datafieldsGridPane.add(new DatafieldGroupPane("Datenfeld 4"),1,6,2,1);
        datafieldsGridPane.add(new DatafieldGroupPane("Datenfeld 5"),1,7,2,1);

        this.add(addDatafieldButton,1,6);
        this.add(addDatafield,2,6);

    }
}
