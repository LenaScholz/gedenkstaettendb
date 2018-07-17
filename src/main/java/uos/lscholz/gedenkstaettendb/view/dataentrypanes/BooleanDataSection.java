package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;

public class BooleanDataSection extends DataEntrySection{
    /**
     *
     * @param pagination
     * @param content
     */
    public BooleanDataSection(boolean pagination, String content) {
        super(pagination,content);
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
