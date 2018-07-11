package uos.lscholz.gedenkstaettendb.view.listeners;

import javafx.scene.control.Button;
import uos.lscholz.gedenkstaettendb.view.QueryPane;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddQuerySectionListener extends MouseAdapter {

    private QueryPane queryPane;

    public AddQuerySectionListener(QueryPane queryPane){
        this.queryPane = queryPane;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getSource() instanceof Button && ((Button)e.getSource()).getId().equals("addButton")){
            this.queryPane.addQuerySection();
        }
    }
}
