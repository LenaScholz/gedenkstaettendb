package uos.lscholz.gedenkstaettendb.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainView.class.getClassLoader().getResource("view/StartWindow.fxml"));
        Pane root = (Pane) loader.load();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Auswahl");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
