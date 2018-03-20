package uos.lscholz.gedenkstaettendb.view;

import javafx.scene.control.Button;

public class DeleteButton extends Button{

    public DeleteButton(String string){
        if(string != null){
            this.setText("X | "+string);
        } else {
            this.setText("X");
        }
        this.setId("deleteButton");
    }

    public DeleteButton(){
        this(null);
    }

}
