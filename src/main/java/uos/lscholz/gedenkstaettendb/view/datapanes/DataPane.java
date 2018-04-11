package uos.lscholz.gedenkstaettendb.view.datapanes;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.AddButton;
import uos.lscholz.gedenkstaettendb.view.DeleteButton;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: possibly turn this into separate classes in the future
 *
 * Group of Labels and data inserts representing a datafield
 * to be used when the user is inserting or editing the data of an entry in the DB
 */
public abstract class DataPane extends GridPane{

    private String type;
    private Label label;
    private List<Node> contentNodes;
    private AddButton addData;
    private List<DeleteButton> dataDeletes;
    private List<TextField> pagination;

    /**
     *
     * @param label Name of the datafield
     * @param type Type of the data stored in the datafield
     * @param contents Array of the data already stored for that datafield
     */
    public DataPane(String label, String type, String [] contents){
        this.contentNodes = new LinkedList<Node>();
        this.dataDeletes = new LinkedList<DeleteButton>();
        this.pagination = new LinkedList<TextField>();
        this.type = type;
        this.label = new Label(label);
        this.addData = new AddButton();
        this.add(addData,1,1);
        this.add(this.label,2,1);

        if(contents == null){
            this.dataDeletes.add(new DeleteButton());
            this.contentNodes.add(newContentNode());
            this.pagination.add(new TextField(""));
            this.add(dataDeletes.get(0), 1, 2);
            this.add(contentNodes.get(0), 2, 2);
            this.add(new Label("Paginierung: "),3,2);
            this.add(this.pagination.get(0),4,2);

        } else {
            for (int i = 0; i < contents.length; i++) {
                this.dataDeletes.add(new DeleteButton());

                this.contentNodes.add(this.newContentNode(contents[i]));
                this.pagination.add(new TextField(""));

                this.add(dataDeletes.get(i), 1, (2 + i));
                this.add(contentNodes.get(i), 2, (2 + i));
                this.add(new Label("Paginierung: "),3,(2+i));
                this.add(this.pagination.get(i),4,(2+i));
            }
        }
    }


    protected abstract Node newContentNode(String content);

    protected abstract Node newContentNode();


}
