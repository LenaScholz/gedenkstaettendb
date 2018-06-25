package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.model.SampleSource;
import uos.lscholz.gedenkstaettendb.view.dataentrypanes.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * Interface requesting the data for a (future) DB-entry
 */
public class EnterDataPane extends GridPane {

    private Label sourceLabel;
    private Label sourceNameLabel;
    private Hyperlink changeSourceLink;
    private ScrollPane scrollPane;
    private GridPane gridPane;
    private List<DataPane> datapanes;

    /**
     * TODO: adapt to actual source once DB is set up
     *
     */
    public EnterDataPane(){

        this.sourceLabel = new Label("Quelle:");
        //Todo: enter correct name of source
        this.sourceNameLabel = new Label("Name der Quelle");
        this.changeSourceLink = new Hyperlink("Quelle wechseln");

        this.datapanes = new LinkedList<DataPane>();
        this.scrollPane = new ScrollPane();
        this.gridPane = new GridPane();
        SampleSource source = new SampleSource();
        int i = 0; //Todo: do this prettier
        for(Map.Entry<String,String> entry : source.datatypes.entrySet()){
            DataPane dataPane = DataPaneFactory.createDataPane(entry.getKey(),entry.getValue(),source.contents.get(entry.getKey()));
            this.datapanes.add(dataPane);
            this.gridPane.add(dataPane,1,i++);
            Separator separator = new Separator();
            separator.setId("separator");
            this.gridPane.add(separator,1,i++);
        }
        this.scrollPane.setContent(this.gridPane);
        this.scrollPane.prefHeightProperty().bind(this.heightProperty());
        this.scrollPane.prefWidthProperty().bind(this.widthProperty());

        this.add(this.sourceLabel,1,1);
        this.add(this.sourceNameLabel,2,1);
        this.add(this.changeSourceLink,3,1);
        this.add(this.scrollPane,1,2,3,1);

    }

}

