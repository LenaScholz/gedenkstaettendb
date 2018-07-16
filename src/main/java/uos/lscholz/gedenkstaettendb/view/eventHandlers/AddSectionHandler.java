package uos.lscholz.gedenkstaettendb.view.eventHandlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import uos.lscholz.gedenkstaettendb.view.HasSections;

public class AddSectionHandler implements EventHandler {

    private HasSections section;

    public AddSectionHandler(HasSections section){
        this.section = section;
    }

    @Override
    public void handle(Event event) {
        section.addSection();
    }
}
