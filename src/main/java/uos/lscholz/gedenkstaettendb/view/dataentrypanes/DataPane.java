package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.AddButton;
import uos.lscholz.gedenkstaettendb.view.DeleteButton;
import uos.lscholz.gedenkstaettendb.view.HasSections;
import uos.lscholz.gedenkstaettendb.view.eventHandlers.AddSectionHandler;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Group of Labels and data inserts representing a datafield
 * to be used when the user is inserting or editing the data of an entry in the DB
 */
public class DataPane extends GridPane implements HasSections {

    private String type;
    private Label label;
    private boolean hasPagination;
    private List<DataEntrySection> contentSections;
    private AddButton addData;

    /**
     *  @param label Name of the datafield
     * @param type Type of the data stored in the datafield
     * @param contents Array of the data already stored for that datafield
     * @param hasPagination
     */
    public DataPane(String label, String type, String[] contents, boolean hasPagination){
        this.contentSections = new LinkedList<DataEntrySection>();

        this.type = type;
        this.label = new Label(label);
        this.hasPagination = hasPagination;
        this.addData = new AddButton();
        this.addData.setOnAction(new AddSectionHandler(this));
        this.add(addData,1,1);
        this.add(this.label,2,1);

        if(contents == null){
            this.addSection();

        } else {
            for (int i = 0; i < contents.length; i++) {
                this.addSection(contents[i]);
            }
        }
    }

    public String getType(){
        return this.type;
    }

    private void addSection(String content){
        DataEntrySection section = DataSectionFactory.createDataSection(this.type, this.hasPagination,content);

        this.contentSections.add(section);
        this.add(section,1,(2+this.contentSections.size()),2,1);
    }

    public void addSection(){
        this.addSection(null);
    }

    public void removeSection(Node node) {
        this.getChildren().remove(node);
        this.contentSections.remove(node);
    }
}
