package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;

public abstract class QuerySection extends GridPane {

    private String[] contents;
    public QuerySection(String [] contents){
        this.contents = contents;
    }

}
