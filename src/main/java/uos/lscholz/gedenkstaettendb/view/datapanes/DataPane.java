package uos.lscholz.gedenkstaettendb.view.datapanes;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import uos.lscholz.gedenkstaettendb.view.AddButton;
import uos.lscholz.gedenkstaettendb.view.DeleteButton;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: possibly turn this into separate classes in the future
 *
 * Group of Labels and data inserts representing a datafield
 * to be used when the user is inserting or editing the data of an entry in the DB
 */
public class DataPane extends GridPane{

    private String type;
    private Label label;
    private List<Node> contentNodes;
    private AddButton addData;
    private List<DeleteButton> dataDeletes;
    private Separator separator;


    /**
     *
     * @param label Name of the datafield
     * @param type Type of the data stored in the datafield
     * @param contents Array of the data already stored for that datafield
     */
    public DataPane(String label, String type, String [] contents){
        this.contentNodes = new LinkedList<Node>();
        this.dataDeletes = new LinkedList<DeleteButton>();
        this.type = type;
        this.label = new Label(label);
        this.addData = new AddButton();
        this.add(addData,1,1);
        this.add(this.label,2,1);




        if(contents != null){
            handleContent(type,contents);
        } else {
            handleEmptyContent(type);
        }
    }

    /**
     * Helper function to add the correct data insert and the data already given to this view
     * @param type Type of the data stored in the datafield
     * @param contents Array of the data already stored for the datafield
     */
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

    /**
     * Helper function to add the correct data insert to this view
     * @param type
     */
    private void handleEmptyContent(String type){
        this.dataDeletes.add(new DeleteButton());
        Node node;
        switch (type){
            case "TEXT": node = handleText("");break;
            case "DATE":node = handleDate("1900-01-01");break;
            case "FLOAT": case "DOUBLE": case "DECIMAL": node = handleFloat("");break;
            case "INTEGER": case "INT": case "BIGINT":node = handleInteger("");break;
            case "BOOLEAN": case "BOOL":node = handleBoolean("false");break;
            default:throw new RuntimeException("Typ wird nicht unterstützt");
        }
        this.contentNodes.add(node);

        this.add(dataDeletes.get(0),1,2);
        this.add(contentNodes.get(0),2,2);
    }

    /**
     *
     * @param content value that is already given
     * @return editable Textfield with given content displayed
     */
    private Node handleText(String content){
        return new TextField(content);
    }

    /**
     *
     * @param content value that is already given
     * @return editable DatePicker with given date displayed
     */
    private Node handleDate(String content) {
        LocalDate date;
        try{
            date = LocalDate.parse(content);
        } catch (DateTimeParseException e){
            throw new RuntimeException("Given type and content do not match");
        }
        return new DatePicker(date);
    }


    /**
     *
     * @param content value that is already given
     * @return editable TextField with given Integer displayed
     */
    private Node handleInteger(String content){
        return new TextField(content);
    }

    /**
     *
     * @param content value that is already given
     * @return editable CheckBox with given value set
     */
    private Node handleBoolean(String content){
        CheckBox checkBox= new CheckBox();
        checkBox.setSelected(Boolean.parseBoolean(content));
        return checkBox;
    }

    /**
     *
     * @param content value that is already given
     * @return editable TextField with given Float displayed
     */
    private Node handleFloat(String content){
        return new TextField(content);
    }
}
