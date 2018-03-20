package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: possibly turn this into separate classes in the future
 *
 */
public class DataPane extends GridPane{

    private String type;
    private Label label;
    private List<Node> contentNodes;
    private AddButton addData;
    private List<DeleteButton> dataDeletes;
    private Separator separator;


    public DataPane(String label, String type, String [] contents){
        this.contentNodes = new LinkedList<Node>();
        this.dataDeletes = new LinkedList<DeleteButton>();
        this.type = type;
        this.label = new Label(label);
        this.addData = new AddButton();
        this.add(addData,1,1);
        this.add(this.label,2,1);
        handleContent(type,contents);
        this.separator = new Separator();
        this.add(separator,1,(3+this.contentNodes.size()),2,1);
    }

    private void handleContent(String type, String [] contents){

        for(int i = 0; i< contents.length; i++){
            this.dataDeletes.add(new DeleteButton());
            Node node;
            switch (type){
                case "TEXT": node = handleText(contents[i]);break;
                case "DATE":node = handleDate(contents[i]);break;
                case "FLOAT": case "DOUBLE": case "DECIMAL": node = handleFloat(contents[i]);break;
                case "INTEGER": case "INT": case "BIGINT":node = handleInteger(contents[i]);break;
                case "BOOLEAN": case "BOOL":node = handleBoolean(contents[i]);break;
                default:throw new RuntimeException("Typ wird nicht unterstützt");
            }
            this.contentNodes.add(node);

            this.add(dataDeletes.get(i),1,(2+i));
            this.add(contentNodes.get(i),2,(2+i));
        }
    }

    private Node handleText(String content){
        return new TextField(content);
    }

    private Node handleDate(String content) {
        LocalDate date;
        try{
            date = LocalDate.parse(content);
        } catch (DateTimeParseException e){
            throw new RuntimeException("Given type and content do not match");
        }
        return new DatePicker(date);
    }


    private Node handleInteger(String content){
        return new TextField(content);
    }

    private Node handleBoolean(String content){
        CheckBox checkBox= new CheckBox();
        checkBox.setSelected(Boolean.parseBoolean(content));
        return checkBox;
    }

    private Node handleFloat(String content){
        return new TextField(content);
    }
}
