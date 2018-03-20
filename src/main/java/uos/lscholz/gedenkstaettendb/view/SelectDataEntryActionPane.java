package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;

/**
 * Interface to choose data entry action on running DB
 */
public class SelectDataEntryActionPane extends GridPane{

    private Button enterDataButton;
    private Hyperlink knownSources;
    private Button importDataButton;
    private Hyperlink supportedFormats;
    private Button createSourceButton;

    public SelectDataEntryActionPane(){
        this.enterDataButton = new Button("Daten aus bereits bekannter Quelle eintragen");
        this.knownSources = new Hyperlink("Bekannte Quellen anzeigen");
        this.importDataButton = new Button("Daten aus anderem Format übertragen");
        this.supportedFormats = new Hyperlink("Unterstützte Formate anzeigen");
        this.createSourceButton = new Button("Quelle ändern oder neu erstellen");

        this.add(enterDataButton,1,1);
        this.add(knownSources,1,2);
        this.add(importDataButton,1,3);
        this.add(supportedFormats,1,4);
        this.add(createSourceButton,1,5);
    }
}
