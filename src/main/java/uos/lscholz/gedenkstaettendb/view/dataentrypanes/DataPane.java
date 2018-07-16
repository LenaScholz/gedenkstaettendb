package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.AddButton;
import uos.lscholz.gedenkstaettendb.view.DeleteButton;
import uos.lscholz.gedenkstaettendb.view.HasSections;
import uos.lscholz.gedenkstaettendb.view.RemovableSection;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Group of Labels and data inserts representing a datafield
 * to be used when the user is inserting or editing the data of an entry in the DB
 */
public abstract class DataPane extends GridPane implements RemovableSection {

    private String type;
    private Label label;
    private List<Control> contentControls;
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
        this.contentControls = new LinkedList<Control>();
        this.dataDeletes = new LinkedList<DeleteButton>();
        this.pagination = new LinkedList<TextField>();
        this.type = type;
        this.label = new Label(label);
        this.addData = new AddButton();
        this.add(addData,1,1);
        this.add(this.label,2,1);

        if(contents == null){
            this.dataDeletes.add(new DeleteButton());
            this.contentControls.add(newContentControl());
            //TODO: do not set size explicitely
            this.contentControls.get(0).setMinWidth(400);
            this.layoutContents(0);

        } else {
            for (int i = 0; i < contents.length; i++) {
                this.dataDeletes.add(new DeleteButton());
                this.contentControls.add(this.newContentControl(contents[i]));
                //TODO: do not set size explicitely
                this.contentControls.get(i).setMinWidth(400);
                this.layoutContents(i);
            }
        }
    }

    public String getType(){
        return this.type;
    }


    //TODO wrong spot for this, split this class to subsections!
    public void removeSection() {
        if(this.getParent() instanceof HasSections){
            ((HasSections) this.getParent()).removeSection(this);
        }else{
            throw new RuntimeException("Section called from Parent that does not have sections");
        }
    }

    protected abstract Control newContentControl(String content);

    protected abstract Control newContentControl();


    private void layoutContents(int i){
        this.pagination.add(new TextField(""));
        this.pagination.get(i).setDisable(true);

        this.add(dataDeletes.get(i), 1, (2 + i));
        this.add(contentControls.get(i), 2, (2 + i));
        this.add(new Label("Paginierung: "),3,(2+i));
        this.add(this.pagination.get(i),4,(2+i));
    }
}
