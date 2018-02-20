package uos.lscholz.gedenkstaettendb.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        WrappingPane root = new WrappingPane();
        /**CreateNewSourcePane createSourcePane = new CreateNewSourcePane();
        root.addCenterLayer(createSourcePane);**/
        SelectDataEntryActionPane selectDataEntryActionPane = new SelectDataEntryActionPane();
        root.addCenterLayer(selectDataEntryActionPane);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/Stylesheet.css");

        primaryStage.setTitle("Personendatenbank");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
