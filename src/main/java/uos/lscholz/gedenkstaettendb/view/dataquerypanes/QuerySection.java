package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.scene.AccessibleAttribute;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;

public abstract class QuerySection extends GridPane {

    private String[] contents;
    private Button infoButton;

    public QuerySection(){
        this(null);
    }
    public QuerySection(String ... contents){
        this.contents = contents;
        this.infoButton = new Button("i");
        //this.add(infoButton,1,1);
    }

    protected abstract String getHelpInfo();

}
