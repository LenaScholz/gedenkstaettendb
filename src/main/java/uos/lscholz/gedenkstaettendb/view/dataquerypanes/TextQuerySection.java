package uos.lscholz.gedenkstaettendb.view.dataquerypanes;


import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class TextQuerySection extends QuerySection{
    private TextField textField;
    private CheckBox fuzzySearch;

    public TextQuerySection(){

    }

    public TextQuerySection(String ... contents){
        this.textField = new TextField();
        this.fuzzySearch = new CheckBox("Unscharfe Suche");
        //TODO: set according to contents?
        this.fuzzySearch.setSelected(false);
        String text = "";
        for(String s:contents){
            //TODO: appropriate separator?
            text+= (s + "; ");
        }
        this.textField.setText(text);
        this.add(textField,1,1);
        this.add(fuzzySearch,2,1);
    }

    @Override
    protected String getHelpInfo() {
        return null;
    }
}
