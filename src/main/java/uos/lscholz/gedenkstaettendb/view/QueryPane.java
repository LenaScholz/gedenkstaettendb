package uos.lscholz.gedenkstaettendb.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.dataquerypanes.QueryGroupPane;
import uos.lscholz.gedenkstaettendb.view.eventHandlers.AddSectionHandler;

import java.util.LinkedList;

public class QueryPane extends GridPane implements AddableSection {

    private Label descriptionlabel;
    private ScrollPane scrollPane;
    private GridPane gridPane;
    private AddButton addButton;
    private LinkedList<QueryGroupPane> queryGroups;
    private Button sendQueryButton;

    public QueryPane(){
        this.descriptionlabel = new Label("Stellen Sie eine Abfrage");
        this.scrollPane = new ScrollPane();
        this.gridPane = new GridPane();
        this.addButton = new AddButton("Abfragefeld hinzufügen");
        this.sendQueryButton = new Button("Abfrage stellen");
        this.sendQueryButton.setId("createButton");
        this.queryGroups = new LinkedList<QueryGroupPane>();

        this.scrollPane.setContent(gridPane);
        scrollPane.prefHeightProperty().bind(this.heightProperty());
        scrollPane.prefWidthProperty().bind(this.widthProperty());
        this.add(descriptionlabel,1,1);
        this.add(scrollPane,1,2);
        this.add(addButton,1,3);
        this.add(sendQueryButton,1,4);

        this.addButton.setOnAction(new AddSectionHandler(this));


    }


    public void addSection(){

        QueryGroupPane groupPane = new QueryGroupPane();
        this.queryGroups.add(groupPane);
        this.gridPane.add(groupPane,1,this.queryGroups.size()+1);

    }

}
