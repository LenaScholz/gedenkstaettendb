package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;
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
        this.datafields = new LinkedList<DatafieldGroupPane>();
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
        scrollPane.prefHeightProperty().bind(this.heightProperty());
        scrollPane.prefWidthProperty().bind(this.widthProperty());


        this.add(scrollPane,1,3,2,1);
        //TODO: dynamic generation and storage in datafields-list
        for(int i=0;i<5;i++) {
            this.addDatafieldGroupPane();
        }

        this.add(addDatafieldButton,1,6);
        this.add(addDatafield,2,6);

    }

    /**
     * add one more DatafieldGroup to this view
     */
    public void addDatafieldGroupPane (){
        DatafieldGroupPane newDGP = new DatafieldGroupPane("Datenfeld "+(datafields.size()+1));
        datafields.add(newDGP);
        this.datafieldsGridPane.add(newDGP,1,datafields.size(),2,1);
        /**newDGP.prefWidthProperty().bind(this.datafieldsGridPane.widthProperty());
        newDGP.prefHeightProperty().bind(this.datafieldsGridPane.heightProperty());**/

    }
}
