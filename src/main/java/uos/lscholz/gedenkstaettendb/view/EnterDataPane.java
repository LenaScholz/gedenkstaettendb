package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.model.SampleSource;
import uos.lscholz.gedenkstaettendb.view.datapanes.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * TODO: should this itself be the scrollpane?
 *
 * Interface requesting the data for a (future) DB-entry
 */
public class EnterDataPane extends GridPane {

    private ScrollPane scrollPane;
    private GridPane gridPane;
    private List<DataPane> datapanes;

    /**
     * TODO: adapt to actual source once DB is set up
     *
     */
    public EnterDataPane(){
        this.datapanes = new LinkedList<DataPane>();
        this.scrollPane = new ScrollPane();
        this.gridPane = new GridPane();
        SampleSource source = new SampleSource();
        int i = 0; //Todo: do this prettier
        for(Map.Entry<String,String> entry : source.datatypes.entrySet()){
            DataPane dataPane = this.createDataPane(entry.getKey(),entry.getValue(),source.contents.get(entry.getKey()));
            this.datapanes.add(dataPane);
            this.gridPane.add(dataPane,1,i++);
            this.gridPane.add(new Separator(),1,i++);
        }
        this.scrollPane.setContent(this.gridPane);
        this.scrollPane.prefHeightProperty().bind(this.heightProperty());
        this.scrollPane.prefWidthProperty().bind(this.widthProperty());
        this.add(this.scrollPane,1,1);

    }

    /**
     * TODO: complete proper Factory
     * @param label
     * @param type
     * @param contents
     * @return
     */
    private DataPane createDataPane(String label, String type, String [] contents) {
        DataPane dataPane = null;
        switch (type) {
            case "TEXT":
                return new TextDataPane(label, type, contents);
            case "DATE":
                return new DateDataPane(label, type, contents);
            case "FLOAT":
            case "DOUBLE":
            case "DECIMAL":
                return new FloatDataPane(label, type, contents);
            case "INTEGER":
            case "INT":
            case "BIGINT":
                return new IntegerDataPane(label, type, contents);
            case "BOOLEAN":
            case "BOOL":
                return new BooleanDataPane(label, type, contents);
            default:
                throw new RuntimeException("Typ wird nicht unterstützt");
        }
    }
}

