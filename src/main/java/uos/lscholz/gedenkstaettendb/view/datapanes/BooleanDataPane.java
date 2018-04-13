package uos.lscholz.gedenkstaettendb.view.datapanes;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;

public class BooleanDataPane extends DataPane{
    /**
     * @param label    Name of the datafield
     * @param type     Type of the data stored in the datafield
     * @param contents Array of the data already stored for that datafield
     */
    public BooleanDataPane(String label, String type, String[] contents) {
        super(label, type, contents);
    }

    @Override
    protected Control newContentControl(String content) {
        CheckBox checkBox= new CheckBox();
        checkBox.setSelected(Boolean.parseBoolean(content));
        return checkBox;
    }

    @Override
    protected Control newContentControl() {
        return this.newContentControl("false");
    }
}
