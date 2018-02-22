package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;
import java.util.List;

public class CreateNewSourcePane extends GridPane {

    private Label nameOfSourceLabel;
    private TextField nameOfSource;
    private Label kindOfSourceLabel;
    private TextField kindOfSource;
    private Label sourceDescriptionLabel;
    private TextArea sourceDescription;
    private Label datafieldsLabel;
    private Button addDatafieldButton;

    private Button createSourceButton;

    private ScrollPane scrollPane;
    private GridPane datafieldsGridPane;

    private List<DatafieldGroupPane> datafields;



    public CreateNewSourcePane(){
        this.datafields = new LinkedList<DatafieldGroupPane>();

        this.nameOfSourceLabel = new Label("Name der Quelle");
        this.nameOfSource = new TextField();
        this.kindOfSourceLabel = new Label("Art der Quelle");
        this.kindOfSource = new TextField();
        this.sourceDescriptionLabel = new Label("Beschreibung der Quelle");
        this.sourceDescription = new TextArea();
        this.datafieldsLabel = new Label("Datenfelder");
        this.createSourceButton = new Button("Quelle erstellen");
        this.createSourceButton.setId("createButton");

        this.scrollPane = new ScrollPane();
        this.datafieldsGridPane = new GridPane();

        this.addDatafieldButton = new Button("+ | Weiteres Datenfeld hinzufügen");
        this.addDatafieldButton.setId("addButton");

        this.add(nameOfSourceLabel,1,1,2,1);
        this.add(nameOfSource,1,2,2,1);
        this.add(kindOfSourceLabel,1,3,2,1);
        this.add(kindOfSource,1,4,2,1);
        this.add(sourceDescriptionLabel,1,5,2,1);
        this.add(sourceDescription,1,6,2,1);
        this.add(datafieldsLabel,1,7);

        scrollPane.setContent(datafieldsGridPane);
        scrollPane.prefHeightProperty().bind(this.heightProperty());
        scrollPane.prefWidthProperty().bind(this.widthProperty());


        this.add(scrollPane,1,8,2,1);
        //TODO: dynamic generation and storage in datafields-list
        for(int i=0;i<5;i++) {
            this.addDatafieldGroupPane();
        }

        this.add(addDatafieldButton,1,9);
        this.add(createSourceButton,1,10,2,1);

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
