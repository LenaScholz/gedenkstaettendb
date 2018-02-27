package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * TODO: possibly turn this into separate classes in the future
 */
public class DataPane extends GridPane{

    private String type;
    private Label label;
    private Node content;


    public DataPane(String label, String type, String content){
        this.type = type;
        this.label = new Label(label);
    }

    private void handleContent(String type, String content){
        switch (type){
            case "String":;break;
            case "Integer":;break;
            case "Boolean":;break;
            default:throw new RuntimeException("Typ wird nicht unterstützt");

        }
    }

    private void handleString(String content){
        this.content = new TextField(content);
    }

    private void HandleInteger(String content){
        this.content = new TextField(content);
    }
}
