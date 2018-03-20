package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.Button;

/**
 * Helper Class creating a Button to for example remove a datafield from a source
 */
public class DeleteButton extends Button{

    /**
     * DeleteButton labelled with "X | Text"
     * @param text text to be depicted alongside the "X"-symbol
     */
    public DeleteButton(String text){
        if(text != null){
            this.setText("X | "+text);
        } else {
            this.setText("X");
        }
        this.setId("deleteButton");
    }

    /**
     * Simple DeleteButton labelled with "X"
     */
    public DeleteButton(){
        this(null);
    }

}
