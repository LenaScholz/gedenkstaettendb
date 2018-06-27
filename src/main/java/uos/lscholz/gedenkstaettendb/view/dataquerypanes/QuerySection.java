package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.scene.AccessibleAttribute;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;

public abstract class QuerySection extends GridPane {

    private String[] contents;

    public QuerySection(){
        this(null);
    }
    public QuerySection(String ... contents){
        this.contents = contents;
    }

}
