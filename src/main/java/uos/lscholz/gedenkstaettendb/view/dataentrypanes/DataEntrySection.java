package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.DeleteButton;
import uos.lscholz.gedenkstaettendb.view.HasSections;
import uos.lscholz.gedenkstaettendb.view.RemovableSection;
import uos.lscholz.gedenkstaettendb.view.eventHandlers.RemoveSectionHandler;

public abstract class DataEntrySection extends GridPane implements RemovableSection {

    private DeleteButton deleteButton;
    private boolean hasPagination;
    private Control contentControl;
    private Label paginationLabel;
    private TextField paginationText;



    public DataEntrySection(boolean hasPagination, String content){
        this.hasPagination = hasPagination;
        this.deleteButton = new DeleteButton();
        this.deleteButton.setOnAction(new RemoveSectionHandler(this));
        //TODO Error handling
        if(content!= null) {
            this.contentControl = this.newContentControl(content);
        }else {
            this.contentControl = this.newContentControl();
        }
        //TODO: do not set size explicitely
        contentControl.setMinWidth(400);

        this.add(deleteButton,1,1);
        this.add(contentControl,2,1);

        if(this.hasPagination){
            this.paginationLabel = new Label("Paginierung: ");
            this.paginationText = new TextField("");
            this.add(paginationLabel,3,1);
            this.add(paginationText,4,1);
        }


    }

    abstract Control newContentControl();
    abstract Control newContentControl(String content);

    @Override
    public void removeSection() {
        //TODO: make prettyer if possible
        if(this.getParent() instanceof HasSections){
            ((HasSections) this.getParent()).removeSection(this);
        }else{
            throw new RuntimeException("Section called from Parent that does not have sections");
        }
    }
}
