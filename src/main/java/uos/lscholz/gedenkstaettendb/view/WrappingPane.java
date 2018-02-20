package uos.lscholz.gedenkstaettendb.view;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;


public class WrappingPane extends BorderPane{

    private Button backButton;
    private StackPane centerStackPane;

    public WrappingPane(){
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        this.setPrefSize(screen.getWidth()*0.75,screen.getHeight()*0.75);

        this.backButton = new Button("Zurück");
        this.backButton.setId("backButton");
        this.setTop(backButton);
        this.centerStackPane = new StackPane();
        this.setCenter(centerStackPane);
    }

    public void addCenterLayer(Parent parent){
        this.centerStackPane.getChildren().add(parent);

    }
}
