package uos.lscholz.gedenkstaettendb.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import uos.lscholz.gedenkstaettendb.view.EnterDataPane;
import uos.lscholz.gedenkstaettendb.view.WrappingPane;
import uos.lscholz.gedenkstaettendb.view.QueryPane;
import uos.lscholz.gedenkstaettendb.view.CreateNewSourcePane;
import uos.lscholz.gedenkstaettendb.view.EnterDataPane;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        WrappingPane root = new WrappingPane();
//        CreateNewSourcePane createSourcePane = new CreateNewSourcePane();
//        root.addCenterLayer(createSourcePane);
//        SelectDataEntryActionPane selectDataEntryActionPane = new SelectDataEntryActionPane();
//        root.addCenterLayer(selectDataEntryActionPane);
        EnterDataPane enterDataPane = new EnterDataPane();
        root.addCenterLayer(enterDataPane);
//        QueryPane queryPane = new QueryPane();
//        root.addCenterLayer(queryPane);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/Stylesheet.css");

        primaryStage.setTitle("Personendatenbank");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
