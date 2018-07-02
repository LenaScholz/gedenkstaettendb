package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.scene.control.CheckBox;

public class BooleanQuerySection extends QuerySection {

    private CheckBox checkBox;

    public BooleanQuerySection(){
        this("true");
    }

    public BooleanQuerySection(String ... contents){
        super(contents);
        if(contents.length > 1){
            throw new RuntimeException("Too many arguments in contents");
        }
        this.checkBox = new CheckBox();
        if(contents.length>0 && contents[0]!=null){
            this.checkBox.setSelected(Boolean.valueOf(contents[0]));
        }
        this.add(this.checkBox,1,1);
    }

    @Override
    protected String getHelpInfo() {
        return null;
    }

}
