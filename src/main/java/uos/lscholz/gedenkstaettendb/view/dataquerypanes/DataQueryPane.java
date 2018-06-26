package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.DeleteButton;

public class DataQueryPane extends GridPane {

    private DeleteButton removeButton;
    private ComboBox select;


    public DataQueryPane(){
        this.removeButton = new DeleteButton();
        //TODO: fill with categories from Database
        this.select = new ComboBox();

    }
}
