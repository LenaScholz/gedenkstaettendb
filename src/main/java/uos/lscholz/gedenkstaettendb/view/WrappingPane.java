package uos.lscholz.gedenkstaettendb.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class WrappingPane extends BorderPane{

    private Button backButton;
    private Button forwardButton;
    private StackPane centerStackPane;

    public WrappingPane(){
        this.backButton = new Button("Zurück");
        this.backButton.setId("backButton");
        this.forwardButton = new Button("Weiter");
        this.forwardButton.setId("forwardButton");
        this.setTop(backButton);
        this.setBottom(forwardButton);
        this.centerStackPane = new StackPane();
        this.setCenter(centerStackPane);
        this.setAlignment(getBottom(),Pos.BASELINE_RIGHT);
    }

    public void addCenterLayer(Node node){
        this.centerStackPane.getChildren().add(node);

    }
}
