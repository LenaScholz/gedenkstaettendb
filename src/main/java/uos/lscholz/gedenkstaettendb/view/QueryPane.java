package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.dataquerypanes.QueryGroupPane;
import uos.lscholz.gedenkstaettendb.view.dataquerypanes.QuerySection;
import uos.lscholz.gedenkstaettendb.view.dataquerypanes.QuerySectionFactory;

import java.util.LinkedList;

public class QueryPane extends GridPane {

    private Label descriptionlabel;
    private ScrollPane scrollPane;
    private GridPane gridPane;
    private AddButton addButton;
    private LinkedList<QueryGroupPane> queryGroups;

    public QueryPane(){
        this.descriptionlabel = new Label("Stellen Sie eine Abfrage");
        this.scrollPane = new ScrollPane();
        this.gridPane = new GridPane();

        this.addButton = new AddButton("Weiteres Abfragefeld hinzufügen");
        this.queryGroups = new LinkedList<QueryGroupPane>();

        //TODO actual functionality
        for(int i = 0; i<6;i++){
            this.addQuerySection();
        }

        this.scrollPane.setContent(gridPane);
        this.add(descriptionlabel,1,1);
        this.add(scrollPane,1,2);
        this.add(addButton,1,3);



    }

    public void addQuerySection(){
        QueryGroupPane groupPane = new QueryGroupPane();
        this.queryGroups.add(groupPane);
        this.gridPane.add(groupPane,1,this.queryGroups.size()+1);
    }

}
