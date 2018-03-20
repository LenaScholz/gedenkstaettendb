package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.Button;

public class AddButton extends Button{

    public AddButton(String string){
        if(string != null){
            this.setText("+ | "+string);
        } else {
            this.setText("+");
        }
        this.setId("addButton");
    }

    public AddButton(){
        this(null);
    }
}
