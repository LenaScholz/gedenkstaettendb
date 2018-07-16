package uos.lscholz.gedenkstaettendb.view.eventHandlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import uos.lscholz.gedenkstaettendb.view.AddableSection;

public class AddSectionHandler implements EventHandler {

    private AddableSection object;

    public AddSectionHandler(AddableSection object){
        this.object = object;
    }

    @Override
    public void handle(Event event) {
        object.addSection();
    }
}
