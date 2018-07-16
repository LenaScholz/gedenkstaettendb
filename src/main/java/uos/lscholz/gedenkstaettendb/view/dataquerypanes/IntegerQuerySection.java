package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.scene.control.TextField;

public class IntegerQuerySection extends QuerySection{
    private TextField lowerInt;
    private TextField upperInt;
    public IntegerQuerySection(){
        this(null);
    }

    public IntegerQuerySection(String ... contents){
        this.lowerInt = new TextField();
        this.upperInt = new TextField();
        if(contents!= null) {
            switch (contents.length) {
                case 0:
                    break;
                case 2:
                    this.upperInt.setText(contents[1]);
                case 1:
                    this.lowerInt.setText(contents[0]);
                    break;
                default:
                    throw new RuntimeException("Too many arguments in contents");
            }
        }
        this.add(lowerInt,1,1);
        this.add(upperInt,2,1);

    }

    @Override
    protected String getHelpInfo() {
        return null;
    }
}
