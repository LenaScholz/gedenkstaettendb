package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.scene.control.TextField;

public class FloatQuerySection extends QuerySection {

    private TextField lowerFloat;
    private TextField upperFloat;

    public FloatQuerySection (){
        this(null);

    }

    public FloatQuerySection(String ... contents){
        this.lowerFloat = new TextField();
        this.upperFloat = new TextField();
        if(contents!= null) {
            switch (contents.length) {
                case 0:
                    break;
                case 2:
                    this.upperFloat.setText(contents[1]);
                case 1:
                    this.lowerFloat.setText(contents[0]);
                    break;
                default:
                    throw new RuntimeException("Too many arguments in contents");
            }
        }
        this.add(lowerFloat,1,1);
        this.add(upperFloat,2,1);

    }

    @Override
    protected String getHelpInfo() {
        return null;
    }
}
