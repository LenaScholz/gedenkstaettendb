package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.Button;

/**
 * Helper Class creating a Button to for example add another datafield to a source
 */
public class AddButton extends Button{

    /**
     * AddButton labelled with "+ | Text"
     * @param text text to be depicted alongside the "+"-symbol
     */
    public AddButton(String text){
        if(text != null){
            this.setText("+ | "+text);
        } else {
            this.setText("+");
        }
        this.setId("addButton");
    }

    /**
     * Simple AddButton labelled with "+"
     */
    public AddButton(){
        this(null);
    }
}
