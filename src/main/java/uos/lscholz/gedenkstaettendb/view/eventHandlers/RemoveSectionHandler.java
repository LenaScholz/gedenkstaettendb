package uos.lscholz.gedenkstaettendb.view.eventHandlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import uos.lscholz.gedenkstaettendb.view.HasSections;
import uos.lscholz.gedenkstaettendb.view.RemovableSection;


public class RemoveSectionHandler implements EventHandler {

    private RemovableSection section;

    public RemoveSectionHandler(RemovableSection section){
        this.section = section;
    }

    @Override
    public void handle(Event event) {
        section.removeSection();
    }
}
